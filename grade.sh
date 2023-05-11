CPATH='".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar"'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
file=`find student-submission/ListExamples.java`
if [[ -f $file ]]
    then
        cp student-submission/ListExamples.java grading-area/
        cp GradeServer.java grading-area/
        cp Server.java grading-area/
        cp -r lib/ grading-area/
        cp TestListExamples.java grading-area/
    else
        echo Please provide the correct file named ListExamples.java
        exit
fi
cd grading-area/
javac -cp $CPATH TestListExamples.java 2> compiler-err.txt
if [[ $? != 0 ]]
    then
        echo The file did not compile correctly. Please make sure there are no errors in your code
        exit
fi
# java -cp $CPATH org.junit.runner.JUnitCore TestListExamples
import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
  @Test(timeout = 500)
  public void testFilter() {
    List<String> listTest1 = Arrays.asList("moon", "moon", "thing", "moon", "moons");
    List<String> listTest2 = Arrays.asList("thing", "another thing");
    IsMoon moonSC = new IsMoon();
    listTest1 = ListExamples.filter(listTest1, moonSC);
    listTest2 = ListExamples.filter(listTest2, moonSC);
    List<String> expected1 = Arrays.asList("moon", "moon", "moon");
    List<String> expected2 = Arrays.asList();
    assertEquals(expected1, listTest1);
    assertEquals(expected2, listTest2);
  }
}

import org.junit.jupiter.api.Test;  
import static org.junit.jupiter.api.Assertions.*;  
  
public class SolutionTest {  
  
    @Test  
    public void testCompareVersion_EqualVersions() {  
        Solution solution = new Solution();  
        assertEquals(0, solution.compareVersion("1.0.0", "1.0.0"));  
    }  
  
    @Test  
    public void testCompareVersion_Version1GreaterThanVersion2() {  
        Solution solution = new Solution();  
        assertEquals(1, solution.compareVersion("1.2.3", "1.2.2"));  
        assertEquals(1, solution.compareVersion("1.10.0", "1.2.0"));  
        assertEquals(1, solution.compareVersion("2.0.0", "1.999.999"));  
    }  
  
    @Test  
    public void testCompareVersion_Version1LessThanVersion2() {  
        Solution solution = new Solution();  
        assertEquals(-1, solution.compareVersion("1.2.2", "1.2.3"));  
        assertEquals(-1, solution.compareVersion("1.2.0", "1.10.0"));  
        assertEquals(-1, solution.compareVersion("1.999.999", "2.0.0"));  
    }  
  
    @Test  
    public void testCompareVersion_DifferentLengths() {  
        Solution solution = new Solution();  
        assertEquals(1, solution.compareVersion("1.2", "1.1.9")); // 1.2 is treated as 1.2.0  
        assertEquals(-1, solution.compareVersion("1.1", "1.1.1")); // 1.1 is treated as 1.1.0  
        assertEquals(0, solution.compareVersion("1.2.3", "1.2.3.0")); // Trailing zeros should not matter  
    }  
  
    @Test  
    public void testCompareVersion_EmptyVersions() {  
        Solution solution = new Solution();  
        assertThrows(NumberFormatException.class, () -> solution.compareVersion("", "1.0.0"));  
        assertThrows(NumberFormatException.class, () -> solution.compareVersion("1.0.0", ""));  
        assertThrows(NumberFormatException.class, () -> solution.compareVersion("", ""));  
    }  
  
    @Test  
    public void testCompareVersion_NonNumericVersions() {  
        Solution solution = new Solution();  
        assertThrows(NumberFormatException.class, () -> solution.compareVersion("1.a.0", "1.0.0"));  
        assertThrows(NumberFormatException.class, () -> solution.compareVersion("1.0.0", "1.0.b"));  
    }  
}
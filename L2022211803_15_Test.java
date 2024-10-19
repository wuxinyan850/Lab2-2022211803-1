import org.junit.jupiter.api.Test;  
import static org.junit.jupiter.api.Assertions.*;  
  
public class SolutionTest {  
  
    // 测试两个相等的版本号，期望返回0  
    @Test  
    public void testCompareVersion_EqualVersions() {  
        Solution solution = new Solution();  
        assertEquals(0, solution.compareVersion("1.0.0", "1.0.0"), "两个版本号相等，应返回0");  
    }  
  
    // 测试版本号1大于版本号2的几种情况，期望返回1  
    @Test  
    public void testCompareVersion_Version1GreaterThanVersion2() {  
        Solution solution = new Solution();  
        assertEquals(1, solution.compareVersion("1.2.3", "1.2.2"), "1.2.3应大于1.2.2");  
        assertEquals(1, solution.compareVersion("1.10.0", "1.2.0"), "1.10.0应大于1.2.0，因为10大于2");  
        assertEquals(1, solution.compareVersion("2.0.0", "1.999.999"), "2.0.0应大于1.999.999，因为2大于1");  
    }  
  
    // 测试版本号1小于版本号2的几种情况，期望返回-1  
    @Test  
    public void testCompareVersion_Version1LessThanVersion2() {  
        Solution solution = new Solution();  
        assertEquals(-1, solution.compareVersion("1.2.2", "1.2.3"), "1.2.2应小于1.2.3");  
        assertEquals(-1, solution.compareVersion("1.2.0", "1.10.0"), "1.2.0应小于1.10.0，因为2小于10");  
        assertEquals(-1, solution.compareVersion("1.999.999", "2.0.0"), "1.999.999应小于2.0.0，因为1小于2");  
    }  
  
    // 测试不同长度的版本号，期望正确处理缺失的修订号（视为0）  
    @Test  
    public void testCompareVersion_DifferentLengths() {  
        Solution solution = new Solution();  
        assertEquals(1, solution.compareVersion("1.2", "1.1.9"), "1.2（视为1.2.0）应大于1.1.9");  
        assertEquals(-1, solution.compareVersion("1.1", "1.1.1"), "1.1（视为1.1.0）应小于1.1.1");  
        assertEquals(0, solution.compareVersion("1.2.3", "1.2.3.0"), "1.2.3和1.2.3.0应相等，因为末尾的0不影响比较");  
    }  
  
    // 测试空版本号字符串，期望抛出NumberFormatException  
    @Test  
    public void testCompareVersion_EmptyVersions() {  
        Solution solution = new Solution();  
        assertThrows(NumberFormatException.class, () -> solution.compareVersion("", "1.0.0"), "空版本号应抛出NumberFormatException");  
        assertThrows(NumberFormatException.class, () -> solution.compareVersion("1.0.0", ""), "空版本号应抛出NumberFormatException");  
        assertThrows(NumberFormatException.class, () -> solution.compareVersion("", ""), "两个空版本号应抛出NumberFormatException");  
    }  
  
    // 测试包含非数字字符的版本号，期望抛出NumberFormatException  
    @Test  
    public void testCompareVersion_NonNumericVersions() {  
        Solution solution = new Solution();  
        assertThrows(NumberFormatException.class, () -> solution.compareVersion("1.a.0", "1.0.0"), "包含非数字字符的版本号应抛出NumberFormatException");  
        assertThrows(NumberFormatException.class, () -> solution.compareVersion("1.0.0", "1.0.b"), "包含非数字字符的版本号应抛出NumberFormatException");  
    }  
}

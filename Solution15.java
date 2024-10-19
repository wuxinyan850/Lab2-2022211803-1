import java.util.*;

/*
 * @Description
 * 
 * 比较版本号
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * 返回规则如下：
 * 如果 version1 > version2 返回 1，
 *  如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 * 
 * 示例 1：
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 * 示例 2：
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
 * 示例 3：
 * 输入：version1 = "0.1", version2 = "1.1"
 * 输出：-1
 * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
 */
class Solution {    
    // 方法用于比较两个版本号  
    public int compareVersion(String version1, String version2) {    
        // 使用点号（.）分割版本号字符串为修订号数组  
        String[] v1 = version1.split("\\.");    
        String[] v2 = version2.split("\\.");    
          
        // 使用一个索引变量i来遍历两个修订号数组  
        int i = 0;    
          
        // 当至少有一个版本号还有修订号没有比较完时，继续循环  
        while (i < v1.length || i < v2.length) {    
            int x = 0, y = 0;    
              
            // 如果v1还有修订号未比较，将其转换为整数  
            if (i < v1.length) {    
                x = Integer.parseInt(v1[i]);    
            }    
              
            // 如果v2还有修订号未比较，将其转换为整数  
            if (i < v2.length) {    
                y = Integer.parseInt(v2[i]);    
            }    
              
            // 比较两个修订号  
            if (x > y) {    
                // 如果v1的当前修订号大于v2的，返回1，表示version1 > version2  
                return 1;    
            } else if (x < y) {    
                // 如果v1的当前修订号小于v2的，返回-1，表示version1 < version2  
                return -1;    
            }    
              
            // 如果两个修订号相等，继续比较下一个修订号  
            i++;    
        }    
          
        // 如果所有修订号都比较完毕且都相等，返回0，表示两个版本号相等  
        return 0;    
    }    
}

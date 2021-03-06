import java.util.ArrayList;
import java.util.List;

class Solution {
    String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits)
    {
        if(digits.length() == 0) return ans;
        generate("", 0, digits);
        return ans;
    }

    private void generate(String prefix, int index, String digits)
    {
        if(index == digits.length())
        {
            ans.add(prefix);
            return;
        }
        int num = digits.charAt(index) - '0'; //wonderful
        String letter = letters[num];
        for(char c : letter.toCharArray())
        {
            generate(prefix + c, index + 1, digits);
        }
    }
}
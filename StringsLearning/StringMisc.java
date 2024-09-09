
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMisc {

    public static void subsets(String result, String target, ArrayList<String> list) {
        // System.out.println(result+" d "+target);
        if (target.isEmpty()) {
            list.add(result);
            return;
        }
        subsets(result, target.substring(1), list);
        subsets(result + target.charAt(0), target.substring(1), list);
    }

    // public static ArrayList<String> subsetsWithoutDuplicates(String processedString,String target){
    //     if (target.isEmpty()) {
    //         ArrayList<String> al=new ArrayList<>();
    //         al.add(processedString);
    //         return al;
    //     }
    // }
    public static ArrayList<String> subSetWithoutRecurssion(String target) {
        ArrayList<String> al = new ArrayList<>();
        al.add("");
        for (int i = 0; i < target.length(); i++) {
            ArrayList<String> newList = new ArrayList<>();
            for (int j = 0; j < al.size(); j++) {
                newList.add(al.get(j) + target.charAt(i));
            }
            al.addAll(newList);
        }
        return al;
    }

    // Return type is slighlty differnet
    public static List<ArrayList<Integer>> subSetWithoutRecurssionAndDuplicates(int[] target) {
        Arrays.sort(target);
        int start = 0;
        int end = 0;
        List<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int i = 0; i < target.length; i++) {
            if (i > 0 && target[i] == target[i - 1]) {
                start = end;
            }
            end = outer.size();
            for (int j = start; j < end; j++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(target[i]);
                outer.add(inner);
            }
        }
        return outer;
    }

    public static ArrayList<String> premutations(String processedString, String target) {
        if (target.isEmpty()) {
            ArrayList<String> al = new ArrayList<>();
            al.add(processedString);
            return al;
        }
        ArrayList<String> result = new ArrayList<>();
        String newChar = String.valueOf(target.charAt(0));
        for (int i = 0; i <= processedString.length(); i++) {
            result.addAll(premutations(processedString.substring(0, i) + newChar + processedString.substring(i, processedString.length()), target.substring(1)));
        }
        return result;
    }

    public static ArrayList<String> dice(String ans, int target) {
        if (target == 0) {
            ArrayList<String> al = new ArrayList<>();
            al.add(ans);
            return al;
        }
        ArrayList<String> resultSet = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            resultSet.addAll(dice(ans + i, target - i));
        }
        return resultSet;
    }

    // Without similar sets
    public static ArrayList<String> diceWithoutSimilarSets(String ans, int target) {
        if (target == 0) {
            ArrayList<String> al = new ArrayList<>();
            al.add(ans);
            return al;
        }
        ArrayList<String> resultSet = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            if (ans.isEmpty() || (ans.length() > 0 && i >= ans.charAt(ans.length() - 1) - '0')) {
                resultSet.addAll(diceWithoutSimilarSets(ans + i, target - i));
            }
        }
        return resultSet;
    }

    public static List<String> letterCombinations(String digits) {
        String[] list = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = combination(digits, "", list);
        return result;
    }

    public static List<String> combination(String digits, String result, String[] list) {
        if (digits.isEmpty()) {
            List<String> ans = new ArrayList<>();
            ans.add(result);
            return ans;
        }
        int digit = digits.charAt(0) - '1';
        String selectedOption = list[digit];
        List<String> ansList = new ArrayList<>();
        if (selectedOption.isEmpty()) {
            ansList.addAll(combination(digits.substring(1), result, list));
        } else {
            for (int i = 0; i < selectedOption.length(); i++) {
                ansList.addAll(combination(digits.substring(1), result + selectedOption.charAt(i), list));
            }
        }
        return ansList;
    }

    public static ArrayList<String> combinations(String digits, String ans) {
        if (digits.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        int digit = digits.charAt(0) - '1';
        ArrayList<String> result = new ArrayList<>();
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            result.addAll(combinations(digits.substring(1), ans + ch));
        }
        return result;
    }

    public static void main(String args[]) {
        String[] list = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // System.out.println("Hello world"+'1');
        // ArrayList<String> al=new ArrayList<>();
        // subsets("", "abc", al);

        // List<ArrayList<Integer>> al=subSetWithoutRecurssionAndDuplicates(new int[]{1,2,2,4});
        //  for(ArrayList<Integer> s:al){
        //     System.out.println(Arrays.toString(s.toArray()));
        // }
        // System.out.println(Arrays.toString(combinations("23","").toArray()));
        // System.out.println(Arrays.toString(diceWithoutSimilarSets("", 4).toArray()));
        System.out.println(Arrays.toString(letterCombinations("234").toArray()));
    }

}

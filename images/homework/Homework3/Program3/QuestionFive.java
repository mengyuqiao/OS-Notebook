package Homework;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class QuestionFive {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // get input
        String s = sc.nextLine();
        s = s.replace(" ", "");
        String[] numstr = s.split(",");
        int nums[] = new int[numstr.length];

        // transfer string into integer
        for (int i = 0; i < numstr.length; i++) {
            try {
                nums[i] = Integer.parseInt(numstr[i]);
            }catch (Exception e){
                e.printStackTrace();
                return;
            }
        }

        int res = FindIndex(nums, 0, nums.length);
        System.out.println(res);
    }

    public static int FindIndex(int[] nums, int p, int r){
        if (p < r) {
            int q = (p+r)/2;
            if (nums[q] == q+1){
                return q+1;
            }
            else if (nums[q] > q+1){
                return FindIndex(nums, p, q);
            }
            else if (nums[q] < q+1){
                return FindIndex(nums, q+1, r);
            }
        }else {
            if (nums[p] == p+1){
                return p+1;
            }else {
                return -1;
            }
        }
        return -1;
    }
}
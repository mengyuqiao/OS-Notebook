package Homework;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Selection {
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

        // selection sort
        nums = FindMedian(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    // Part A
    public static int[] SelectionSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int key = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[key]){
                    key = j;
                }
            }
            int temp = nums[key];
            nums[key] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    // Part B
    public static int[] SmallestK(int[] nums, int k){
        for (int i = 0; i < k; i++) {
            int key = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[key]){
                    key = j;
                }
            }
            int temp = nums[key];
            nums[key] = nums[i];
            nums[i] = temp;
        }
        return Arrays.copyOfRange(nums, 0, k);
    }

    // Part C
    public static int[] FindMedian(int[] nums){
        boolean twoMedian = false;
        int mid = nums.length/2+1;
        if (nums.length % 2 == 0){
            twoMedian = true;
        }

        nums = SmallestK(nums, mid);

        if (twoMedian){
            return Arrays.copyOfRange(nums, nums.length-2, nums.length);
        }else {
            return Arrays.copyOfRange(nums, nums.length-1, nums.length);
        }
    }
}
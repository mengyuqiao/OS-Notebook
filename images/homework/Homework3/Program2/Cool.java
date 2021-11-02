package Homework;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Cool {
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

        // get input
        s = sc.nextLine();
        s = s.replace(" ", "");
        numstr = s.split(",");
        int[] gaps = new int[numstr.length];

        // transfer string into integer
        for (int i = 0; i < numstr.length; i++) {
            try {
                gaps[i] = Integer.parseInt(numstr[i]);
            }catch (Exception e){
                e.printStackTrace();
                return;
            }
        }
        
        nums = CoolSort(nums, gaps);
        System.out.println(Arrays.toString(nums));;
    }

    public static int[] CoolSort(int[] nums, int[] gaps){
        for (int j = 0; j < gaps.length; j++) {
            int gap = gaps[j];
            for (int k = 0; k < gap; k++) {
                for (int i = k + gap; i < nums.length; i+=gap) {
                    int key = nums[i];
                    int min = i - gap;
                    while( min>=0 && nums[min]>key){
                        nums[min+gap] = nums[min];
                        min-=gap;
                    }
                    nums[min+gap] = key;
                }
            }
        }
        return nums;
    }
}
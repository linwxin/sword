package datastruct.sort;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[10];
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(100);
        }
        printArray(nums);
        quickSort(nums, 0, nums.length - 1);
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
    }

    public static void quickSort(int[] nums, int head, int rear) {
        if (head > rear) return ;
        int mid = partition(nums, head, rear);
        printArray(nums);
        quickSort(nums, head, mid - 1);
        quickSort(nums, mid + 1, rear);
    }

    public static int partition(int[] nums, int head, int rear) {
        int midNum = nums[rear];
        int mid = head;
        for (int low = head, high = head; high < rear; high++) {
            if (nums[high] <= midNum) {
                swap(nums, low++, high);
            }
            mid = low;
        }
        swap(nums, mid, rear);

        return mid;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}

public class FindNumV2 {

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(7, array));
    }

    public static boolean Find(int target, int [][] array) {
        int rowPre = 0;
        int rowRear = array.length - 1;
        if (array.length == 0)
            return false;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length == 0)
                return false;
            if (array[i][rowPre] <= target && array[i][rowRear] >= target) {
                if (binarySearch(target, array[i]) != -1)
                    return true;
            }

        }
        return false;
    }

    public static int binarySearch(int target, int[] array) {
        int pre = 0;
        int rear = array.length - 1;
        while (pre <= rear) {
            int mid = (pre + rear) / 2;
            if (target == array[mid])
                return mid;
            else if (target < array[mid])
                rear = mid - 1;
            else
                pre = mid + 1;
        }
        return -1;
    }
}

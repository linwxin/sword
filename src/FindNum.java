public class FindNum {
    public static void main(String []args) {
        int[][] array = new int[10][10];
        int num = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = num++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Find(555, array));
    }

    public static boolean Find(int target, int [][] array) {
        int rowPre = 0;
        int rowRear = array.length - 1;
        int colPre = 0;
        int colRear = array[0].length - 1;
        int targetRow = 0;
        while (rowPre <= rowRear) {
            int rowMid = (rowPre + rowRear) / 2;
            if (target < array[rowMid][0]) {
                rowRear = rowMid - 1;
                continue;
            }

            if (target > array[rowMid][array[0].length - 1]) {
                rowPre = rowMid + 1;
                continue;
            }
            // 找到所在行
            if (target >= array[rowMid][0] && target <= array[rowMid][array[0].length - 1]){
                targetRow = rowMid;
                while (colPre <= colRear) {
                    int colMid = (colPre + colRear) / 2;
                    if (target == array[targetRow][colMid])
                        return true;
                    else if (target < array[targetRow][colMid])
                        colRear = colMid - 1;
                    else
                        colPre = colMid + 1;

                }
            }
        }
        return false;
    }
}
package soword;
import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}



public class Solution26 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(23);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(2);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        TreeNode node = Convert(root);
        while(node != null) {
            System.out.print(node.val + " ");
            node = node.right;
        }
        System.out.println("");


    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        List<TreeNode> nodeArray = new ArrayList<>();
        preOrder(nodeArray, pRootOfTree);
        for (TreeNode e : nodeArray) {
            System.out.print(e.val + " ");
        }
        System.out.println("");
        quickSort(nodeArray, 0, nodeArray.size()-1);
        TreeNode preNode = nodeArray.get(0);
        preNode.left = null;
        preNode.right = null;
        TreeNode root = preNode;
        for (int i = 1; i < nodeArray.size(); i++) {
            TreeNode node = new TreeNode(nodeArray.get(i).val);
            preNode.right = node;
            node.left = preNode;
            node.right = null;
            preNode = preNode.right;
        }

        return root;
    }

    public static void preOrder(List<TreeNode> nodeArray, TreeNode root){
        if(root != null) {
            nodeArray.add(root);
            preOrder(nodeArray, root.left);
            preOrder(nodeArray, root.right);
        }
    }

    public static void swap(TreeNode node1, TreeNode node2){
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public  static void quickSort(List<TreeNode> list, int head, int rear) {
        if (head > rear) return ;
        int p = partition(list, head, rear);
        quickSort(list, head, p-1);
        quickSort(list, p+1, rear);
    }

    public static int partition(List<TreeNode> list, int head, int rear) {
        int midVal = list.get(list.size() - 1).val;
        int p = head;
        for (int low = head, high = head; high < rear; high++) {
            if (list.get(high).val <= midVal) {
                swap(list.get(low), list.get(high));
                low++;
            }
            p = low;
        }
        swap(list.get(p), list.get(rear));

        return p;
    }
}

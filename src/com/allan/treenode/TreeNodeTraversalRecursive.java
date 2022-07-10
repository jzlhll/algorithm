package com.allan.treenode;

public class TreeNodeTraversalRecursive {
    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println("val: " + node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void centerOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        centerOrder(node.left);
        System.out.println("val: " + node.val);
        centerOrder(node.right);
    }

    public static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println("val: " + node.val);
    }
}

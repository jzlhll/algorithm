package com.allan.treenode;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class TreeNodeTraversalIterator {
    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                System.out.println("val: " + node.val); //* diff
                node = node.left;
            }
            TreeNode bottomLeft = stack.pop();
            node = bottomLeft.right;
        }
    }

    public static void centerOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode bottomLeft = stack.pop();
            System.out.println("val: " + bottomLeft.val); //* diff
            node = bottomLeft.right;
        }
    }

    public static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode bottomLeft = stack.peek();
            if (bottomLeft.right == null || bottomLeft.right == prev) {
                System.out.println("val: " + bottomLeft.val);
                prev = stack.pop();
            } else {
                node = bottomLeft.right;
            }
        }
    }
}

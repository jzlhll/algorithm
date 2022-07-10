package com.allan.treenode;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        TreeNode node = TreeNode.create(1, 2, 3, 4, null, null, 6, 7, 8, null, null, null, null, null, 11);

        System.out.println("preOder====");
        TreeNodeTraversalIterator.postOrder(node);
        System.out.println("preOder====end===");

        System.out.println("preOder====");
        TreeNodeTraversalRecursive.postOrder(node);
        System.out.println("preOder====end===");
    }
}

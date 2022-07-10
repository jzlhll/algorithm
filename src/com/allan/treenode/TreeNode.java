package com.allan.treenode;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode create(Integer... list) {
        if (list != null && list.length > 0) {
            TreeNode node = new TreeNode(list[0]);

            Deque<TreeNode> nodes = new LinkedList<>();
            nodes.offer(node);
            int lvlSize = 1;
            for (int i = 1; i < list.length;) {
                int tmpSize = lvlSize;
                while (tmpSize-- > 0 && i < list.length) {
                    TreeNode tmp = nodes.poll();
                    if (list[i] != null) {
                        tmp.left = new TreeNode(list[i]);
                        nodes.offer(tmp.left);
                    }
                    i++;
                    if (list[i] != null) {
                        tmp.right = new TreeNode(list[i]);
                        nodes.offer(tmp.right);
                    }
                    i++;
                }

                lvlSize *= 2;
            }

            return node;
        }

        return null;
    }

    public static void printBeautifully(List<TreeNode> fullList, int level) {
        int index = 0;

        for (int l = 0, sz = 1; l < level; l++) {
            int s = sz;
            StringBuilder sb = new StringBuilder();
            while(s-- > 0 && index < fullList.size()) {
                TreeNode n = fullList.get(index++);
                sb.append(n == null ? "null" : n.val).append(" ");
            }
            System.out.println(sb);
            sz *= 2;
        }
    }

    public List<TreeNode> printFulls(int[] levelRet) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);

        int lvlSize = 1;
        int level = 0;

        List<TreeNode> ret = new ArrayList<>();

        while (queue.size() > 0) {
            int lvl = lvlSize;

            List<TreeNode> tmpList = new ArrayList<>();
            boolean hasNotNull = false;
            while (lvl-- > 0) {
                TreeNode n = queue.poll();
                tmpList.add(n);
                if (n != null) {
                    hasNotNull = true;
                }
            }
            if (hasNotNull) {
                int i = 0;
                while (i < tmpList.size()) {
                    TreeNode n = tmpList.get(i++);
                    ret.add(n);
                    if (n == null) {
                        queue.offer(null);
                        queue.offer(null);
                    } else {
                        queue.offer(n.left);
                        queue.offer(n.right);
                    }
                }
            } else {
                break;
            }

            lvlSize *= 2;
            level++;
        }

        System.out.print("level:" + level + "; [");
        for (int i = ret.size() - 1; i >= 0; i--) {
            if (ret.get(i) == null) {
                ret.remove(i);
            } else {
                break;
            }
        }

        for (TreeNode r : ret) {
            System.out.print(r != null ? r.val : "null");
            System.out.print(", ");
        }
        System.out.println("]");
        levelRet[0] = level;
        return ret;
    }
}

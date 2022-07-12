package com.allan.sort.normal;


import com.allan.sort.ISort;

/**
 插入排序。
 时间复杂度O(n^2) 但对于比较有序的数列，时间复杂度能大幅下降
 空间复杂度O(1)
 稳定排序
 原地
 简单
 交换次数O(n^2)
 算法优点：稳定，快。
 算法缺点：比较次数不一定，比较次数越多，插入点后的数据移动越多（特别是当数据总量庞大的时候）。但用链表可以解决这个问题。
 最好情况：序列已经是期望顺序了，在这种情况下，需要进行的比较操作需(n-1)次即可。
 最坏情况：序列是期望顺序的相反序列，那么此时需要进行的比较共有n(n-1)/2次。
 插入排序算法的时间复杂度平均为O(n^2)
 */
public final class InsertSort implements ISort {
    @Override
    public void sort(int[] sources) {
        int N = sources.length;
        //从第2，i=1个元素开始。
        for (int i = 1; i < N; i++) {
            int cur = sources[i];
            //从i-1开始，倒着跟前面的数比较
            int r = i;
            while (r > 0 && cur < sources[r - 1]) {
                sources[r] = sources[r - 1];
                r--; //关键是这个要放里面去
            }
            //如果r == i表示while里面没有出现小于的情况，则跳出了
            if (r != i) {
                sources[r] = cur;
            }
        }
    }

    @Override
    public void sortOpt(int[] sources) {

    }
}


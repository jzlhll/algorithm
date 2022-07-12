package com.allan.sort.supers;


import com.allan.sort.ISort;

/**
 快速排序。 迭代版本。
 时间复杂度O(nlogn)
 空间复杂度O(log(n)) 体现在函数栈
 不稳定排序
 原地
 普通版和优化版

 算法优点：稳定
 一听到这个名字你就知道它存在的意义，就是快，而且效率高！它是处理大数据最快的排序算法之一了。
 快速排序的最坏运行情况是 O(n²)，比如说顺序数列的快排。但它的平摊期望时间是 O(nlogn)，
 且 O(nlogn) 记号中隐含的常数因子很小，比复杂度稳定等于 O(nlogn) 的归并排序要小很多。
 所以，对稳定性没有要求的情况下，快速排序总是优于归并排序。
 */
public final class QuickSort implements ISort {
    @Override
    public void sort(int[] sources) {
        quickSort(sources, 0, sources.length - 1);
    }

    private void quickSort(int[] src, int left, int right) {
        if (left > right) {
            return;
        }

        int mark = partition(src, left, right);
        quickSort(src, left, mark - 1);
        quickSort(src, mark + 1, right);
    }

    private int partition(int[] src, int left, int right) {
        int pivotVal = src[left];

        int l = left; //记录左右指针
        int r = right;

        while (l < r) {
            //因为起手坑在pivot的位置，故而先从右边开始。
            // 如果右边小于基准值，把src[r]变成'坑', 交换到l的位置。l++，r不变。因为他是'坑'.
            while (src[r] > pivotVal && l < r) {
                r--;
            }
            if (l < r) {
                src[l++] = src[r];
            }

            while(src[l] < pivotVal && l < r) {
                l++;
            }
            if (l < r) {
                src[r--] = src[l];
            }
        }
        src[l] = pivotVal;
        return l;
    }

    @Override
    public void sortOpt(int[] sources) {

    }
}


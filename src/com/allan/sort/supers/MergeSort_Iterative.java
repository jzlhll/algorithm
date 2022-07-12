package com.allan.sort.supers;

import com.allan.sort.ISort;

/**
 归并排序 递归版本
 时间复杂度O(nlogn)
 空间复杂度O(n)
 稳定排序
 并非原地

 算法优点：稳定
 当有 n 个记录时，需进行 logn 轮归并排序，每一轮归并，其比较次数不超过 n，元素移动次数都是 n，因此，归并排序的时间复杂度为 O(nlogn)。
 归并排序时需要和待排序记录个数相等的存储空间，所以空间复杂度为 O(n)。
 归并排序适用于数据量大，并且对稳定性有要求的场景。

 他适合超大型数据的，使用外部磁盘存储排序的方案。
 改进点还有多路归并，现在是二叉归并。
 归并排序。 迭代版本
 */
public final class MergeSort_Iterative implements ISort {
    private int[] src;
    private int[] tmp;

    @Override
    public void sort(int[] sources) {
        src = sources;
        int size = src.length;
        tmp = new int[size];

        //外层循环从1开始；逐渐扩大？？
        for (int step = 1; step < size; step *= 2) {
            int doubles = 2 * step;
            //从底部开始往上合并
            for (int start = 0; start < size; start += doubles) {
                int mid = Math.min(size - 1, start + step);
                int right = Math.min(size - 1, start + doubles - 1);
                merge(src, tmp, start, mid, right);
            }
        }
    }

    private static void merge(int[] src, int[] tmp, int left, int mid, int right) {
        //记录下，我们需要merge的2个区间；
        // 左边区间[left, mid]；右边区间从[mid+1,right]
        //t记录下我们塞入tmp数组的index
        int l = left;
        int r = mid + 1;
        int t = 0;

        //拷贝到一个临时数组中去；其实优化点当数据比较少的时候，可以针对这里进行插入排序；不使用tmp数组
        //不断的从2边取放到tmp中，直到有一遍触底
        while (l <= mid && r <= right) {
            if (src[l] <= src[r]) {
                tmp[t++] = src[l++];
            } else {
                tmp[t++] = src[r++];
            }
        }

        //将剩余的一边仅需考入到tmp中
        while (l <= mid) {
            tmp[t++] = src[l++];
        }

        while (r <= right) {
            tmp[t++] = src[r++];
        }


        //将tmp还原到src中
        while (--t >= 0) { //此时tempIndex其实是前面我们存入的tmpSize。所以要先--
            src[right--] = tmp[t];
        }
    }

    @Override
    public void sortOpt(int[] sources) {

    }
}


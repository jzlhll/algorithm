package com.allan.sort.supers;

import com.allan.sort.ISort;

/**
 希尔排序。 插入排序的优化版。
 时间复杂度O(n^(1.3-2))
 空间复杂度O(1)
 不稳定排序
 原地
 复杂
 交换次数
 时间复杂度：需要根据增量的选择来看，通常比O(n^2)要好
 优势：最坏情况下和平均情况差不多，中小规模输入
 劣势：大规模输入（比一般的O(n^2)要好） 不稳定
 ，几乎任何排序工作在开始时都可以用希尔排序，若在实际使用中证明它不够快，再改成快速排序这样更高级的排序算法.
 本质上讲，希尔排序算法是直接插入排序算法的一种改进，减少了其复制的次数，速度要快很多。
 原因是，当n值很大时数据项每一趟排序需要移动的个数很少，但数据项的距离很长。当n值减小时每一趟需要移动的数据增多，
 此时已经接近于它们排序后的最终位置。 正是这两种情况的结合才使希尔排序效率比插入排序高很多。
 */
public final class ShellSort implements ISort {

    @Override
    public void sort(int[] sources) {
        int size = sources.length;

        int gap = Math.max(1, size  * 2 / 5); //gap任取
        //不要求面试能直接写出来。
        //关键点就是三层循环。
        //最外层循环：gap的计算逻辑；
        //第二层循环：从gap开始，到size的循环。
        //第三层循环：根据步调gap，进行插入排序的一趟。

        while(true) {
            for (int i = gap; i < size; i++) {
                int tmp = sources[i];
                int r = i;
                while (r -gap >= 0 && tmp < sources[r - gap]) {
                    sources[r] = sources[r - gap];
                    r -= gap;
                }

                sources[r] = tmp;
            }

            if (gap == 1) {
                break;
            }
            //计算gap
            gap = gap > 6 ? gap / 3 : 1;
        }
    }

    @Override
    public void sortOpt(int[] sources) {
        throw new RuntimeException("no");
    }
}


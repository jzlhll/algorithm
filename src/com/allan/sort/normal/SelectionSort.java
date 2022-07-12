package com.allan.sort.normal;

import com.allan.sort.ISort;

/**
 选择排序。
 时间复杂度O(n^2)
 空间复杂度O(1)
 不稳定排序
 原地
 简单
 交换次数O(n)
 算法来讲，因为数据交换最小的，大部分情况优于冒泡。
 优化算法为一次找到最大和最小。

 算法优点：移动数据的次数已知。
 算法缺点：比较次数多；不稳定。
 选择排序总共要进行n-1次交换
 */
public final class SelectionSort implements ISort {
    @Override
    public void sort(int[] sources) {
        int size = sources.length;

        for(int i = 0; i < size - 1; i++) {
            int minIndex = i;
            //1.1 一趟之后，找到了min index
            for (int j = i + 1; j < size; j++) {
                if (sources[j] < sources[minIndex]) {
                    minIndex = j;
                }
            }
            //1.2 把miniIndex放到前面来
            if (minIndex != i) {
                int tmp = sources[i];
                sources[i] = sources[minIndex];
                sources[minIndex] = tmp;
            }
        }
    }

    @Override
    public void sortOpt(int[] sources) {
        int size = sources.length;

        for(int left = 0, right = size - 1; left < right; left++, right--) {
            int minIndex = left;
            int maxIndex = right;
            //1.1 一趟之后，找到了min index & max index
            for (int j = left; j <= right; j++) {
                if (sources[j] < sources[minIndex]) {
                    minIndex = j;
                }

                if (sources[j] > sources[maxIndex]) {
                    maxIndex = j;
                }
            }
            //1.2 把miniIndex放到前面来
            if (minIndex != left) {
                int tmp = sources[minIndex];
                sources[minIndex] = sources[left];
                sources[left] = tmp;

                //因为上面这个交换动作，会把left和minIndex交换位置。
                // 所以，如果我们的最大值刚好就是这个left，那已经被我们交换走了。所以得换到minIndex的位置
                if (left == maxIndex) {
                    maxIndex = minIndex;
                }
            }
            //1.3 把maxIndex放到后面去
            if (maxIndex != right) {
                int tmp = sources[maxIndex];
                sources[maxIndex] = sources[right];
                sources[right] = tmp;
            }
        }
    }
}

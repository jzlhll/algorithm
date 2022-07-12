package com.allan.sort.normal;

import com.allan.sort.ISort;

/**
 冒泡排序。
 时间复杂度O(n^2)
 空间复杂度O(1)
 稳定排序
 原地
 简单
 交换次数O(n^2)
 普通版和优化版

 算法优点：稳定
 算法缺点：所需时间太长，时间复杂度高，接近O(n²)
 冒泡排序理论上总共要进行n(n-1）/2次交换
 仅供学习，不适合正式使用
 */
public final class BubbleSort implements ISort {
    @Override
    public void sort(int[] sources) {
        int size = sources.length;
        while (size-- > 0) { //1. 外层循环不断缩小 总个数
            for (int i = 0; i < size; i++) { //内循环从 0 < size 这个不断减小的数
                if (sources[i] > sources[i + 1]) { //交换
                    int tmp = sources[i];
                    sources[i] = sources[i + 1];
                    sources[i + 1] = tmp;
                }
            }
        }
    }

    @Override
    public void sortOpt(int[] sources) {
        int size = sources.length;
        //追加一个标记上次排序已经好了的位置
        int mark = 0;
        while (size-- > 0) {
            boolean isNoReplace = true; //1. 通过内循环是否有交换动作，来跳出#1
            for (int i = mark; i < size; i++) { //2. 标记已经排好了的位置，用于下次直接从那个位置开始即可 #2
                if (sources[i] > sources[i + 1]) {
                    if (isNoReplace) { //1. 通过内循环是否有交换动作，来跳出#2
                        isNoReplace = false;
                        mark = i; //2. 标记已经排好了的位置，用于下次直接从那个位置开始即可 #1
                    }
                    int tmp = sources[i];
                    sources[i] = sources[i + 1];
                    sources[i + 1] = tmp;
                }
            }
            if (isNoReplace) { //1. 通过内循环是否有交换动作，来跳出#3
                break;
            }
        }
    }
}


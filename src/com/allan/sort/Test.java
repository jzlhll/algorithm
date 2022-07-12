package com.allan.sort;

public class Test {
    public static void main(String[] args) {
        int count = 100000;

        ISort sort = new InsertSort();//new BubbleSort();//

        int[] src = generate(100, 250);
        demoOnce(sort, copy(src));
        System.out.println("开始计时：");
        long t = System.currentTimeMillis();
        demoTimes(sort, count, copy(src));
        System.out.println("耗时：" + (System.currentTimeMillis() - t));

        System.out.println("==========");

        demoOnceOpt(sort, copy(src));

        t = System.currentTimeMillis();
        demoTimesOpt(sort, count, copy(src));
        System.out.println("耗时：" + (System.currentTimeMillis() - t));
    }

    private static void demoOnce(ISort sort, int[] ret) {
        System.out.println("初始化：");
        print(ret);
        sort.sort(ret);
        System.out.println("排序完：");
        print(ret);
    }

    private static void demoOnceOpt(ISort sort, int[] ret) {
        System.out.println("初始化：");
        print(ret);
        sort.sortOpt(ret);
        System.out.println("排序完：");
        print(ret);
    }

    private static void demoTimes(ISort sort, int count, int[] ret) {
        for (int i = 0; i < count; i++) {
            sort.sort(ret);
        }
    }

    private static void demoTimesOpt(ISort sort, int count, int[] ret) {
        for (int i = 0; i < count; i++) {
            sort.sortOpt(ret);
        }
    }

    private static void print(int[] src) {
        for(int s : src) {
            System.out.print(s);
            System.out.print(", ");
        }
        System.out.println();
    }

    private static int[] generate(int size, int max) {
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = (int) (Math.random() * max);
        }
        return ret;
    }

    private static int[] copy(int[] src) {
        int[] ret = new int[src.length];
        for (int i = 0; i < src.length; i++) {
            ret[i] = src[i];
        }
        return ret;
    }
}

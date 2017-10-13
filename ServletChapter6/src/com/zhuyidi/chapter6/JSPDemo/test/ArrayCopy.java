package com.zhuyidi.chapter6.JSPDemo.test;

import java.util.Arrays;

/**
 * Created by dela on 5/24/17.
 */
public class ArrayCopy {
    public static void main(String args[]){
        int[] array1 = {0, 1, 2, 3, 4, 5};
        int[] array2 = Arrays.copyOf(array1, array1.length);

        for(int num : array1){
            System.out.printf("%3d", num);
        }
        System.out.println();

        for(int num : array2) {
            System.out.printf("%3d", num);
        }
        System.out.println();

        array2[0] = 10;

        for(int num : array1){
            System.out.printf("%3d", num);
        }
        System.out.println();

        for(int num : array2){
            System.out.printf("%3d", num);
        }
    }
}

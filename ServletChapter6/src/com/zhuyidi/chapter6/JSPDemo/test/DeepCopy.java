package com.zhuyidi.chapter6.JSPDemo.test;

/**
 * Created by dela on 5/24/17.
 */
public class DeepCopy {
    public static class cloths{
        String color;
        char size;

        cloths(String col, char si){
            color = col;
            size = si;
        }
    }

    public static void main(String[] args){
        cloths[] c1 = {new cloths("red", 'l'), new cloths("blue", 'm')};
        cloths[] c2 = new cloths[c1.length];

        for(int i = 0; i < c1.length; i++){
            cloths c = new cloths(c1[i].color, c1[i].size);
            c2[i] = c;
        }

        c1[0].color = "yellow";
        System.out.println(c2[0].color);
    }
}

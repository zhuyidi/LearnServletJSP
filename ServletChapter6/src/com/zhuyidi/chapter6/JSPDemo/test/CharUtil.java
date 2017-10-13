package com.zhuyidi.chapter6.JSPDemo.test;

import java.io.*;

/**
 * Created by dela on 5/23/17.
 */
public class CharUtil {
    public static void dump(Reader src, Writer dest) throws IOException {
        Reader input = src;
        Writer output = dest;
        char[] data = new char[1024];
        int length;
        while((length = input.read(data)) != -1){
            output.write(data, 0, length);
        }
    }
    public static void main(String args[]) throws IOException {
        FileReader reader = new FileReader("/home/dela/IdeaProjects/ServletChapter6/src/com/zhuyidi/chapter6/JSPDemo/test/Demo.java");
        StringWriter writer = new StringWriter();
        CharUtil.dump(reader, writer);
        System.out.println(writer.toString());
    }

}

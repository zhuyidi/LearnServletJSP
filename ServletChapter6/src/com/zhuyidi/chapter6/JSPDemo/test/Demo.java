package com.zhuyidi.chapter6.JSPDemo.test;

import com.zhuyidi.chapter6.JSPDemo.test.CharUtil;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by dela on 5/23/17.
 */
public class Demo {
    public static void main(String args[]) throws IOException {
        FileReader reader = new FileReader(args[0]);
        StringWriter writer = new StringWriter();
        CharUtil.dump(reader, writer);
        System.out.println(writer.toString());
    }
}

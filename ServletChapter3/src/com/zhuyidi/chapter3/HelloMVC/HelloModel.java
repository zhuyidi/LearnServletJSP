package com.zhuyidi.chapter3.HelloMVC;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dela on 3/7/17.
 */
public class HelloModel {
    private Map<String, String> messages = new HashMap<String, String>();

    //定义HelloModel的构造方法
    public HelloModel(){
        messages.put("Lucy", "Hi");
        messages.put("Sue", "Hello");
        messages.put("Ann", "Welcome");
    }

    //实现doHello()方法
    public String doHello(String name){
        //通过传参过来的用户名,在哈希表里找到与其对应的欢迎语,并返回拼接好的欢迎语句
        String sentence = messages.get(name);
        return sentence + "," + name + "!";
    }
}

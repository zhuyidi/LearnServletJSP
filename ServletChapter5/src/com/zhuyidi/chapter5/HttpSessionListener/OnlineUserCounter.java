package com.zhuyidi.chapter5.HttpSessionListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by dela on 4/25/17.
 */

@WebListener
public class OnlineUserCounter implements HttpSessionListener {
    private static int counter;

    public static int getCounter(){
        return counter;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        OnlineUserCounter.counter++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        OnlineUserCounter.counter--;
    }
}

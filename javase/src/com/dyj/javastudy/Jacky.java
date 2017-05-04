package com.dyj.javastudy;

/**
 * Created by dengyongjie044 on 2017/5/4.
 */
public class Jacky implements Student {
    @Override
    public void resolveQuestion(Callback callback) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        callback.tellAnswer(3);
    }
}

package com.dyj.javastudy;

/**
 * Created by dengyongjie044 on 2017/5/4.
 */
public class Teacher implements Callback {
    private Student student;

    public Teacher(Student student){
        this.student = student;
    }

    public void askQuestion(){
        student.resolveQuestion(this);
    }

    @Override
    public void tellAnswer(int answer) {
        System.out.println("知道了，你的答案是" + answer);
    }
}

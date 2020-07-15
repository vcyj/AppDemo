package com.example.appdemo;

import java.util.ArrayList;
import java.util.List;

public class Bf implements Subject {
    //观察者清单
    private List<Observer>gf;
    private  String msg;
    public Bf(){
        gf=new ArrayList<>();
    }
    @Override
    public void attach(Observer observer) {

        gf.add(observer);
    }

    @Override
    public void dettach(Observer observer) {
        gf.remove(observer);
    }
    //消息发布
    public void pushTodo(String todo){
        this.msg=todo;
        System.out.println("通知你家长："+msg);
        //通知所以你的朋友
        notifObservers();
    }

    @Override
    public void notifObservers() {
        for (Observer observer:gf){
            observer.update(msg);
        }
    }
}

package com.example.appdemo;

public class Gf implements Observer {
    private String name;
    private String Todo;



    @Override
    public void update(Object msg) {
        this.Todo=(String)msg;
        getit();
    }

    private void getit() {
        System.out.println("尊敬的"+name+"您的某某某正在"+Todo);
    }

    public Gf(String name) {
        this.name=name;
    }
}

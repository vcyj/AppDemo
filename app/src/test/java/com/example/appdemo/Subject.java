package com.example.appdemo;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    List<Observer>observers=new ArrayList<Observer>();

    void attach(Observer observer);
    void dettach(Observer observer);
    void notifObservers();

}

package com.example.appdemo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void client(){
    Bf jeeyu=new Bf();
    Gf wangyan=new Gf("wangyan");
    Gf ycy=new Gf("ycy");
    Gf lyf=new Gf("lyf");

    jeeyu.attach(wangyan);
    jeeyu.attach(ycy);
    jeeyu.attach(lyf);
jeeyu.pushTodo("吃饭");
    jeeyu.dettach(lyf);
    jeeyu.pushTodo("earn the obtention");
    }

}

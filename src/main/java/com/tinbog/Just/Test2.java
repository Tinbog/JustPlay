package com.tinbog.Just;

import java.util.HashMap;
import java.util.List;

public class Test2<T1> extends Test1<T1> implements InterfaceTest<Integer>{
    @Override
    public void test(int i) {
        super.test(i);
    }
    public void test(String i) {

    }


    @Override
    public int test1(int i) {
        return 0;
    }

    @Override
    public int test2(Integer integer) {
        return 0;
    }


    public int test1(String  i) {
        return 0;
    }
    public int test2(String integer) {
        return 0;
    }
}
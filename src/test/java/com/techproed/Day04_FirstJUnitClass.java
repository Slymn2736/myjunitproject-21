package com.techproed;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

public class Day04_FirstJUnitClass {

    //We no longer need MAIN METHOD
    // @Test creates a test case.

    @Test
    public void setUp(){
        System.out.println("This will be reusable set up method");
    }

    @Test
    public void test1(){
        System.out.println("Test Case 1");
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("Test Case 2");
    }

    @Test
    public void test3(){
        System.out.println("Test Case 3");
    }

    @After
    public void tearDown(){
        System.out.println("This will be run after each method");
    }

}

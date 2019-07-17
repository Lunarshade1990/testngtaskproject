package com.lunarshade.testapp;

public class TestRun {
    public static void main(String[] args) {

        CustomTestNG testNG = new CustomTestNG();
        testNG.initializeXml("15", "test");
        testNG.runTestByName("first-test");
    }
}

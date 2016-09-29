package com.github.javadev.model;

public class StringResponse {
    public String string;
    public Integer longestWord;

    @Override
    public String toString() {
        return "string=" + string + ", longestWord=" + longestWord;
    }
}

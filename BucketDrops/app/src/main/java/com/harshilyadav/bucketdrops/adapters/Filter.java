package com.harshilyadav.bucketdrops.adapters;

/**
 * Created by harshilyadav on 25/01/18.
 */

public interface Filter {
    int NONE = 0;
    int MOST_TIME_LEFT = 1;
    int LEAST_TIME_LEFT = 2;
    int COMPLETE = 3;
    int INCOMPLETE = 4;
}
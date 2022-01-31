package com.tencent.lbsapi;

public abstract interface QLBSNotification
{
  public static final int RESULT_LOCATION_ERROR = 0;
  public static final int RESULT_LOCATION_SUCCESS = 1;
  
  public abstract void onLocationNotification(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.lbsapi.QLBSNotification
 * JD-Core Version:    0.7.0.1
 */
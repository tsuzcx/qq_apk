package com.tencent.base;

import android.app.Application;

public class BaseApplication
  extends Application
{
  public void onCreate()
  {
    super.onCreate();
    Global.init(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.base.BaseApplication
 * JD-Core Version:    0.7.0.1
 */
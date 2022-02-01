package com.tencent.mobileqq.triton.sdk.utils;

import android.os.Looper;

public class ThreadUtil
{
  public static boolean isMainThread()
  {
    return Thread.currentThread() == Looper.getMainLooper().getThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.utils.ThreadUtil
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.wifisdk.services.common.api;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public abstract interface IThreadPool
{
  public static final int TYPE_DB = 2;
  public static final int TYPE_FILE = 3;
  public static final int TYPE_NETWORK = 4;
  public static final int TYPE_NORMAL = 0;
  public static final int TYPE_NORMAL_URGENT = 1;
  
  public abstract void addTask(Runnable paramRunnable, String paramString, int paramInt);
  
  public abstract Handler getSubThreadHandler();
  
  public abstract Looper getSubThreadLooper();
  
  public abstract HandlerThread newFreeHandlerThread(String paramString, int paramInt);
  
  public abstract Thread newFreeThread(Runnable paramRunnable, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wifisdk.services.common.api.IThreadPool
 * JD-Core Version:    0.7.0.1
 */
package com.meri.service.monitor;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

public abstract interface a
{
  public abstract boolean forceMonitorAllPkg();
  
  public abstract HandlerThread getHandlerThread(String paramString);
  
  public abstract Handler getMonitorCallbackHandler();
  
  public abstract void onAutoReturn();
  
  public abstract Bundle onConnected(Bundle paramBundle);
  
  public abstract void onCreate();
  
  public abstract void onException(Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.meri.service.monitor.a
 * JD-Core Version:    0.7.0.1
 */
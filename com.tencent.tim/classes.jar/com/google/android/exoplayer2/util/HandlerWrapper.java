package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.os.Message;

public abstract interface HandlerWrapper
{
  public abstract Looper getLooper();
  
  public abstract Message obtainMessage(int paramInt);
  
  public abstract Message obtainMessage(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract Message obtainMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  
  public abstract Message obtainMessage(int paramInt, Object paramObject);
  
  public abstract boolean post(Runnable paramRunnable);
  
  public abstract boolean postDelayed(Runnable paramRunnable, long paramLong);
  
  public abstract void removeCallbacksAndMessages(Object paramObject);
  
  public abstract void removeMessages(int paramInt);
  
  public abstract boolean sendEmptyMessage(int paramInt);
  
  public abstract boolean sendEmptyMessageAtTime(int paramInt, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.util.HandlerWrapper
 * JD-Core Version:    0.7.0.1
 */
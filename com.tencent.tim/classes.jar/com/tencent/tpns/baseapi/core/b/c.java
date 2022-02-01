package com.tencent.tpns.baseapi.core.b;

import android.os.PowerManager.WakeLock;

public class c
{
  private static c a = null;
  private PowerManager.WakeLock b = null;
  
  public static c a()
  {
    if (a == null) {
      a = new c();
    }
    return a;
  }
  
  public void a(PowerManager.WakeLock paramWakeLock)
  {
    this.b = paramWakeLock;
  }
  
  public PowerManager.WakeLock b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.core.b.c
 * JD-Core Version:    0.7.0.1
 */
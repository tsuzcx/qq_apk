package com.tencent.android.tpush.service;

import android.os.PowerManager.WakeLock;

public class d
{
  private static d a = null;
  private PowerManager.WakeLock b = null;
  
  public static d a()
  {
    if (a == null) {
      a = new d();
    }
    return a;
  }
  
  public PowerManager.WakeLock b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.d
 * JD-Core Version:    0.7.0.1
 */
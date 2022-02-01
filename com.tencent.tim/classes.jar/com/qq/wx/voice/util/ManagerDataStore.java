package com.qq.wx.voice.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ManagerDataStore
{
  public static final long NULLNUM = -Math.pow(2.0D, 63.0D);
  private SharedPreferences.Editor a = null;
  private SharedPreferences b = null;
  
  public long getDeltaTime()
  {
    return this.b.getLong("deltaTime", NULLNUM);
  }
  
  public void init(Context paramContext)
  {
    this.b = paramContext.getSharedPreferences("wxvoicesdk", 0);
    this.a = this.b.edit();
  }
  
  public void setDeltaTime(long paramLong)
  {
    this.a.putLong("deltaTime", paramLong);
    this.a.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qq.wx.voice.util.ManagerDataStore
 * JD-Core Version:    0.7.0.1
 */
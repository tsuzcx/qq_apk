package com.huawei.hms.activity.internal;

import android.content.Intent;

public class BusResponseResult
{
  private Intent a;
  private int b;
  
  public int getCode()
  {
    return this.b;
  }
  
  public Intent getIntent()
  {
    return this.a;
  }
  
  public void setCode(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.a = paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.activity.internal.BusResponseResult
 * JD-Core Version:    0.7.0.1
 */
package com.huawei.hms.push;

import com.huawei.hms.push.a.a;

public class BaseException
  extends Exception
{
  private final int a;
  private final a b;
  
  public BaseException(int paramInt)
  {
    this.b = a.a(paramInt);
    this.a = this.b.b();
  }
  
  public int getErrorCode()
  {
    return this.a;
  }
  
  public String getMessage()
  {
    return this.b.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.BaseException
 * JD-Core Version:    0.7.0.1
 */
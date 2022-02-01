package com.tencent.token;

import android.text.TextUtils;

public class ay
{
  private String a = "";
  private int b = -1;
  
  public ay() {}
  
  public ay(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = paramString.split(":");
    } while (paramString.length != 2);
    this.a = paramString[0];
    try
    {
      this.b = Integer.parseInt(paramString[1]);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.a + ":" + this.b;
  }
  
  public String toString()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ay
 * JD-Core Version:    0.7.0.1
 */
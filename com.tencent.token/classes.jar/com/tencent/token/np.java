package com.tencent.token;

import android.text.TextUtils;

public final class np
{
  public String a = "";
  public int b = -1;
  
  public np() {}
  
  public np(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.split(":");
    if (paramString.length != 2) {
      return false;
    }
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
  
  public final String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.np
 * JD-Core Version:    0.7.0.1
 */
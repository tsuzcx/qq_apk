package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.content.res.Resources;

public class p
{
  protected Context a;
  protected Resources b;
  
  public p(Context paramContext)
  {
    this.a = paramContext;
    this.b = paramContext.getResources();
  }
  
  private int a(String paramString1, String paramString2)
  {
    return this.b.getIdentifier(paramString2, paramString1, this.a.getPackageName());
  }
  
  public int a(String paramString)
  {
    return a("string", paramString);
  }
  
  public int b(String paramString)
  {
    return a("drawable", paramString);
  }
  
  public int c(String paramString)
  {
    return a("layout", paramString);
  }
  
  public int d(String paramString)
  {
    return a("id", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.p
 * JD-Core Version:    0.7.0.1
 */
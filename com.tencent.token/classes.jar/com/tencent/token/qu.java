package com.tencent.token;

import android.content.Context;

public class qu
{
  private static qu b;
  public qv a;
  
  private qu(Context paramContext)
  {
    this.a = qv.a(paramContext);
  }
  
  public static qu a(Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new qu(paramContext);
        }
      }
      finally {}
    }
    return b;
  }
  
  public final k a(int paramInt)
  {
    return this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qu
 * JD-Core Version:    0.7.0.1
 */
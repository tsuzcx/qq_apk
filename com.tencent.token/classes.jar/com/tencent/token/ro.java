package com.tencent.token;

import android.content.Context;

public class ro
{
  private static ro b;
  public rp a;
  
  private ro(Context paramContext)
  {
    this.a = rp.a(paramContext);
  }
  
  public static ro a(Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new ro(paramContext);
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
 * Qualified Name:     com.tencent.token.ro
 * JD-Core Version:    0.7.0.1
 */
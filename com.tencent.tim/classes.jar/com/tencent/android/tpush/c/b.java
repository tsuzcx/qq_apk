package com.tencent.android.tpush.c;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;

public class b
{
  private static a a = null;
  private static String b = null;
  
  public static a a(Context paramContext)
  {
    if (!e.a(a))
    {
      TLogger.dd("MidHelper", "read the new one");
      a = new c(paramContext, 3).d();
    }
    if (!e.a(a))
    {
      TLogger.dd("MidHelper", "load from the old one");
      a = new c(paramContext, 0).d();
    }
    if (a != null) {
      return a;
    }
    return new a();
  }
  
  public static String b(Context paramContext)
  {
    if (!e.b(b)) {}
    try
    {
      if (!e.b(b)) {
        b = a(paramContext).b();
      }
      return b;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.c.b
 * JD-Core Version:    0.7.0.1
 */
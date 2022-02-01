package com.tencent.util.e;

import android.util.Log;

public class a
{
  private static int a(String paramString1, String paramString2, Throwable paramThrowable, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return Log.v(paramString1, paramString2, paramThrowable);
    case 1: 
      return Log.d(paramString1, paramString2, paramThrowable);
    case 2: 
      return Log.i(paramString1, paramString2, paramThrowable);
    case 3: 
      return Log.w(paramString1, paramString2, paramThrowable);
    case 4: 
      return Log.e(paramString1, paramString2, paramThrowable);
    }
    return Log.wtf(paramString1, paramString2, paramThrowable);
  }
  
  public static final int a(Throwable paramThrowable)
  {
    return a("exception", "", paramThrowable, 5);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    b.a(b.a(), paramInt, paramString1, paramString2);
  }
  
  public static void a(a parama)
  {
    b.a(b.a(), parama);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    b.a(b.a(), 4, paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    b.a(b.a(), 6, paramString1, paramString2);
  }
  
  public static abstract interface a
  {
    public abstract void print(int paramInt, String paramString1, String paramString2);
  }
  
  private static class b
  {
    private static b a = new b();
    private a.a b;
    
    private void a(int paramInt, String paramString1, String paramString2)
    {
      if (this.b != null)
      {
        this.b.print(paramInt, paramString1, paramString2);
        return;
      }
      Log.println(paramInt, paramString1, paramString2);
    }
    
    private void a(a.a parama)
    {
      this.b = parama;
    }
    
    private static b b()
    {
      return a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.util.e.a
 * JD-Core Version:    0.7.0.1
 */
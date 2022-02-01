package com.tencent.mobileqq.triton.audio;

import android.os.Handler;
import android.os.HandlerThread;

public class a
  extends HandlerThread
{
  private static volatile a a;
  private static Handler b;
  
  private a(String paramString)
  {
    super(paramString);
  }
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a locala = new a(a.class.getSimpleName());
        locala.start();
        b = new Handler(locala.getLooper());
        a = locala;
      }
      return a;
    }
    finally {}
  }
  
  public final void a(Runnable paramRunnable)
  {
    b.post(paramRunnable);
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    b.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.a
 * JD-Core Version:    0.7.0.1
 */
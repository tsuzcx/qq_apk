package com.tencent.trackrecordlib.e;

import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class c
  implements a
{
  public static final String a = c.class.getSimpleName();
  private boolean b = false;
  private int c;
  private WindowManager d;
  
  public c(Context paramContext)
  {
    this.d = ((WindowManager)paramContext.getSystemService("window"));
    this.c = c();
  }
  
  private int c()
  {
    try
    {
      int i = this.d.getDefaultDisplay().getRotation();
      return i;
    }
    catch (Throwable localThrowable)
    {
      Log.e(a, "获取屏幕旋转方向出错！");
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public void a()
  {
    new Thread(new c.1(this), "RotationMonitorThread").start();
  }
  
  public void b()
  {
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.e.c
 * JD-Core Version:    0.7.0.1
 */
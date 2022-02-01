package com.tencent.token;

import android.content.Context;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public final class aak
{
  public static int a(Context paramContext)
  {
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      if (paramContext != null)
      {
        paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
        int i = localDisplayMetrics.heightPixels;
        return i;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return aah.b;
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      if (paramContext != null)
      {
        paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
        int i = localDisplayMetrics.widthPixels;
        return i;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return aah.b;
  }
  
  public static int c(Context paramContext)
  {
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      if (paramContext != null)
      {
        paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
        int i = localDisplayMetrics.densityDpi;
        return i;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return aah.b;
  }
  
  public static String d(Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(f(paramContext));
    localStringBuffer.append(" * ");
    localStringBuffer.append(g(paramContext));
    return localStringBuffer.toString();
  }
  
  public static boolean e(Context paramContext)
  {
    try
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static int f(Context paramContext)
  {
    try
    {
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      if (paramContext != null)
      {
        int i = paramContext.getWidth();
        return i;
      }
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return aah.b;
  }
  
  private static int g(Context paramContext)
  {
    try
    {
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      if (paramContext != null)
      {
        int i = paramContext.getHeight();
        return i;
      }
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return aah.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aak
 * JD-Core Version:    0.7.0.1
 */
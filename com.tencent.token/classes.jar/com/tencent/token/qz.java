package com.tencent.token;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.token.global.RqdApplication;
import java.lang.reflect.Field;

public final class qz
{
  public static final boolean a;
  public static int b;
  public static int c = 0;
  private static final Long d;
  private static int e;
  private static int f;
  private static float g = 0.0F;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 19) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
    d = Long.valueOf(60000L);
    b = 0;
    e = 0;
    f = 0;
  }
  
  public static int a()
  {
    if (b == 0) {
      b = a(RqdApplication.n());
    }
    return b;
  }
  
  private static int a(Context paramContext)
  {
    int j = a(paramContext, 25.0F);
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject3 = localClass.newInstance();
      localObject1 = localObject4;
      try
      {
        boolean bool = Build.BRAND.toLowerCase().contains("meizu");
        localObject1 = localObject2;
        if (bool) {
          try
          {
            localObject1 = localClass.getField("status_bar_height_large");
          }
          catch (Throwable localThrowable4)
          {
            localObject1 = localObject4;
            localThrowable4.printStackTrace();
            localObject1 = localObject2;
          }
        }
        localObject2 = localObject1;
        localObject4 = localObject3;
        if (localObject1 != null) {
          break label139;
        }
        localObject2 = localClass.getField("status_bar_height");
        localObject4 = localObject3;
      }
      catch (Throwable localThrowable2)
      {
        localObject2 = localObject3;
      }
      localThrowable3.printStackTrace();
    }
    catch (Throwable localThrowable3)
    {
      localObject2 = null;
    }
    Object localObject5 = localObject2;
    localObject2 = localObject1;
    label139:
    int i = j;
    if (localObject2 != null)
    {
      i = j;
      if (localObject5 != null) {
        try
        {
          i = Integer.parseInt(((Field)localObject2).get(localObject5).toString());
          i = paramContext.getResources().getDimensionPixelSize(i);
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
          i = j;
        }
      }
    }
    String str = yd.a;
    if (TextUtils.isEmpty(str)) {
      str = "";
    } else {
      str = str.toLowerCase();
    }
    int k = 0;
    j = k;
    if (!TextUtils.isEmpty(str))
    {
      j = k;
      if (str.equals("sm-g8870")) {
        j = 1;
      }
    }
    if (i > 0)
    {
      k = i;
      if (i > a(paramContext, 50.0F))
      {
        k = i;
        if (j != 0) {}
      }
    }
    else
    {
      float f1 = paramContext.getResources().getDisplayMetrics().density;
      if (f1 == -1.0F) {
        return a(paramContext, 25.0F);
      }
      k = (int)(f1 * 25.0F + 0.5F);
    }
    return k;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int b()
  {
    return e;
  }
  
  public static int c()
  {
    return f;
  }
  
  public static boolean d()
  {
    DisplayMetrics localDisplayMetrics = RqdApplication.n().getResources().getDisplayMetrics();
    if (RqdApplication.n().getResources().getConfiguration().orientation == 2)
    {
      e = localDisplayMetrics.heightPixels;
      f = localDisplayMetrics.widthPixels;
    }
    else
    {
      e = localDisplayMetrics.widthPixels;
      f = localDisplayMetrics.heightPixels;
    }
    c = localDisplayMetrics.densityDpi;
    g = localDisplayMetrics.density;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qz
 * JD-Core Version:    0.7.0.1
 */
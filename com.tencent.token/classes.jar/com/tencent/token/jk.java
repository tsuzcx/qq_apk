package com.tencent.token;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class jk
{
  private static Method a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[] { Rect.class, Rect.class });
      a = localMethod;
      if (!localMethod.isAccessible()) {
        a.setAccessible(true);
      }
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
    return;
  }
  
  public static void a(View paramView, Rect paramRect1, Rect paramRect2)
  {
    Method localMethod = a;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramView, new Object[] { paramRect1, paramRect2 });
      return;
    }
    catch (Exception paramView) {}
    return;
  }
  
  public static boolean a(View paramView)
  {
    return ew.c(paramView) == 1;
  }
  
  public static void b(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      Method localMethod = paramView.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
      if (!localMethod.isAccessible()) {
        localMethod.setAccessible(true);
      }
      localMethod.invoke(paramView, new Object[0]);
      return;
    }
    catch (NoSuchMethodException|InvocationTargetException paramView)
    {
      return;
    }
    catch (IllegalAccessException paramView) {}
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jk
 * JD-Core Version:    0.7.0.1
 */
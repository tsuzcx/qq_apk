package com.tencent.turingfd.sdk.base;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class bf
  implements ViewTreeObserver.OnPreDrawListener
{
  public bf(Window paramWindow, String paramString, av paramav, Activity paramActivity) {}
  
  public boolean onPreDraw()
  {
    Object localObject6 = null;
    this.a.getDecorView().getViewTreeObserver().removeOnPreDrawListener(this);
    Object localObject1 = this.a;
    try
    {
      localObject4 = localObject1.getClass();
      localObject4 = ((Class)localObject4).getDeclaredMethod("getViewRootImpl", new Class[0]);
      ((Method)localObject4).setAccessible(true);
      localObject1 = ((Method)localObject4).invoke(localObject1, new Object[0]);
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        localObject2 = null;
      }
    }
    if (localObject1 == null) {}
    label173:
    do
    {
      do
      {
        do
        {
          return true;
          try
          {
            localObject4 = localObject2.getClass();
            localObject4 = ((Class)localObject4).getDeclaredMethod("getAccessibilityInteractionController", new Class[0]);
            ((Method)localObject4).setAccessible(true);
            localObject2 = ((Method)localObject4).invoke(localObject2, new Object[0]);
          }
          catch (Throwable localThrowable3)
          {
            for (;;)
            {
              Object localObject2;
              Object localObject7;
              Object localObject3 = null;
            }
          }
        } while (localObject2 == null);
        try
        {
          localObject4 = localObject2.getClass();
          localObject4 = ((Class)localObject4).getDeclaredField("mHandler");
          ((Field)localObject4).setAccessible(true);
          localObject4 = ((Field)localObject4).get(localObject2);
        }
        catch (Throwable localThrowable4)
        {
          for (;;)
          {
            Object localObject5 = null;
          }
        }
      } while ((localObject4 == null) || ((localObject4 instanceof be)));
      try
      {
        localObject7 = localObject4.getClass();
        localObject7 = ((Class)localObject7).getMethod("getLooper", new Class[0]);
        ((Method)localObject7).setAccessible(true);
        localObject7 = ((Method)localObject7).invoke(localObject4, new Object[0]);
        localObject6 = localObject7;
      }
      catch (Throwable localThrowable5)
      {
        break label173;
      }
      localObject6 = (Looper)localObject6;
    } while (localObject6 == null);
    Object localObject4 = new be((Handler)localObject4, this.a, (Looper)localObject6, this.b, this.c.getClass().getName());
    try
    {
      localObject6 = localObject2.getClass();
      localObject6 = ((Class)localObject6).getDeclaredField("mHandler");
      ((Field)localObject6).setAccessible(true);
      ((Field)localObject6).set(localObject2, localObject4);
      return true;
    }
    catch (Throwable localThrowable2)
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bf
 * JD-Core Version:    0.7.0.1
 */
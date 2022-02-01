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

public final class k
  implements ViewTreeObserver.OnPreDrawListener
{
  public k(Window paramWindow, String paramString, g paramg, Activity paramActivity) {}
  
  public boolean onPreDraw()
  {
    try
    {
      this.a.getDecorView().getViewTreeObserver().removeOnPreDrawListener(this);
      localObject1 = this.a;
      localObject3 = null;
    }
    catch (Throwable localThrowable1)
    {
      Object localObject1;
      Object localObject3;
      Object localObject2;
      label56:
      label98:
      localThrowable1.printStackTrace();
      label132:
      label190:
      return true;
    }
    try
    {
      localObject2 = localObject1.getClass();
      localObject2 = ((Class)localObject2).getDeclaredMethod("getViewRootImpl", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      localObject1 = ((Method)localObject2).invoke(localObject1, new Object[0]);
    }
    catch (Throwable localThrowable2)
    {
      break label56;
    }
    localObject1 = null;
    if (localObject1 == null) {
      return true;
    }
    try
    {
      localObject2 = localObject1.getClass();
      localObject2 = ((Class)localObject2).getDeclaredMethod("getAccessibilityInteractionController", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      localObject1 = ((Method)localObject2).invoke(localObject1, new Object[0]);
    }
    catch (Throwable localThrowable3)
    {
      break label98;
    }
    localObject1 = null;
    if (localObject1 == null) {
      return true;
    }
    try
    {
      localObject2 = localObject1.getClass();
      localObject2 = ((Class)localObject2).getDeclaredField("mHandler");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(localObject1);
    }
    catch (Throwable localThrowable5)
    {
      boolean bool;
      break label132;
    }
    localObject2 = null;
    if (localObject2 != null)
    {
      bool = localObject2 instanceof l;
      if (bool) {
        return true;
      }
    }
    try
    {
      Object localObject4 = localObject2.getClass();
      localObject4 = ((Class)localObject4).getMethod("getLooper", new Class[0]);
      ((Method)localObject4).setAccessible(true);
      localObject4 = ((Method)localObject4).invoke(localObject2, new Object[0]);
      localObject3 = localObject4;
    }
    catch (Throwable localThrowable6)
    {
      break label190;
    }
    localObject3 = (Looper)localObject3;
    if (localObject3 == null) {
      return true;
    }
    localObject2 = new l((Handler)localObject2, this.a, (Looper)localObject3, this.b, this.c.getClass().getName());
    try
    {
      localObject3 = localObject1.getClass();
      localObject3 = ((Class)localObject3).getDeclaredField("mHandler");
      ((Field)localObject3).setAccessible(true);
      ((Field)localObject3).set(localObject1, localObject2);
      return true;
    }
    catch (Throwable localThrowable4) {}
    return true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.k
 * JD-Core Version:    0.7.0.1
 */
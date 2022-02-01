package com.tencent.token;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class abw
  implements ViewTreeObserver.OnPreDrawListener
{
  public abw(Window paramWindow, abs paramabs, Activity paramActivity) {}
  
  public final boolean onPreDraw()
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
      label55:
      label97:
      localThrowable1.printStackTrace();
      label131:
      label184:
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
      break label55;
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
      break label97;
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
      break label131;
    }
    localObject2 = null;
    if ((localObject2 != null) && (!(localObject2 instanceof abx))) {}
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
      break label184;
    }
    localObject3 = (Looper)localObject3;
    if (localObject3 == null) {
      return true;
    }
    localObject2 = new abx((Handler)localObject2, this.a, (Looper)localObject3, this.b, this.c.getClass().getName());
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
 * Qualified Name:     com.tencent.token.abw
 * JD-Core Version:    0.7.0.1
 */
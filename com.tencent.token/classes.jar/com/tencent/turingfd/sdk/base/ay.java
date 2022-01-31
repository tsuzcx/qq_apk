package com.tencent.turingfd.sdk.base;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.Window.Callback;
import java.util.Set;

public final class ay
  extends bk
{
  public void a(Activity paramActivity, String paramString)
  {
    Window localWindow;
    Object localObject;
    if ((ba.g.contains(paramActivity.getClass().getName())) || (ba.f))
    {
      paramString = ba.i;
      localWindow = paramActivity.getWindow();
      localObject = localWindow.getCallback();
      if (localObject != null) {
        break label85;
      }
    }
    for (;;)
    {
      paramString = ba.j;
      localWindow = paramActivity.getWindow();
      localObject = paramActivity.getClass().getName();
      localWindow.getDecorView().getViewTreeObserver().addOnPreDrawListener(new bf(localWindow, (String)localObject, paramString, paramActivity));
      return;
      label85:
      if (!(localObject instanceof bv)) {
        localWindow.setCallback(new bv((Window.Callback)localObject, paramString, paramActivity.getClass().getName()));
      }
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    ba.e.b(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity, "onActivityResumed");
    ba.e.a(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ay
 * JD-Core Version:    0.7.0.1
 */
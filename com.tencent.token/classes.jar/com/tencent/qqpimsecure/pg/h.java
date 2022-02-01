package com.tencent.qqpimsecure.pg;

import Protocol.MGuide.MIntent;
import Protocol.MGuide.MSolution;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import taiji.bg;
import tmsdk.common.module.pgsdk.IPermissionChecker;

public class h
{
  public static void a(Context paramContext)
  {
    long l = f.c(paramContext);
    int i = g.a().a.checkPermission(5);
    MSolution localMSolution;
    if (System.currentTimeMillis() - l > 5000L)
    {
      f.b(paramContext, i);
      if (l > 0L)
      {
        f.b(paramContext, 0L);
        localMSolution = e.a(paramContext, 5);
        if (i != 0) {
          break label93;
        }
        if ((localMSolution != null) && (localMSolution.mJumpIntent != null)) {
          a.a(paramContext, 30109, 1, f.c(paramContext, 5), 0, localMSolution.mJumpIntent.mPackage);
        }
      }
    }
    label93:
    while ((localMSolution == null) || (localMSolution.mJumpIntent == null)) {
      return;
    }
    a.a(paramContext, bg.b(5), 0, f.c(paramContext, 5), 0, localMSolution.mJumpIntent.mPackage);
  }
  
  public static void b(final Context paramContext)
  {
    if (Build.VERSION.SDK_INT > 24) {
      f.a(paramContext, -1);
    }
    while ((f.d(paramContext)) || (f.a(paramContext) != 2)) {
      return;
    }
    final WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    final WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = 0;
    localLayoutParams.height = 0;
    localLayoutParams.type = 2005;
    View local1 = new View(paramContext)
    {
      public void onWindowFocusChanged(boolean paramAnonymousBoolean)
      {
        if (f.d(paramContext))
        {
          f.a(paramContext, 2);
          return;
        }
        if (paramAnonymousBoolean)
        {
          f.a(paramContext, 0);
          return;
        }
        f.a(paramContext, -1);
      }
    };
    Handler localHandler = new Handler(Looper.getMainLooper());
    localHandler.post(new Runnable()
    {
      public void run()
      {
        if (this.a.getParent() == null) {}
        try
        {
          localWindowManager.addView(this.a, localLayoutParams);
          if (!f.d(paramContext)) {
            f.a(paramContext, -1);
          }
          return;
        }
        catch (Throwable localThrowable) {}
      }
    });
    localHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        if (this.a.getParent() != null) {}
        try
        {
          localWindowManager.removeView(this.a);
          return;
        }
        catch (Throwable localThrowable) {}
      }
    }, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.h
 * JD-Core Version:    0.7.0.1
 */
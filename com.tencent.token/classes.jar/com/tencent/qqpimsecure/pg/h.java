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
    if (System.currentTimeMillis() - l > 5000L)
    {
      f.b(paramContext, i);
      if (l > 0L)
      {
        f.b(paramContext, 0L);
        MSolution localMSolution = e.a(paramContext, 5);
        int j;
        if (i == 0)
        {
          if ((localMSolution == null) || (localMSolution.mJumpIntent == null)) {
            return;
          }
          i = 30109;
          j = 1;
        }
        else
        {
          if ((localMSolution == null) || (localMSolution.mJumpIntent == null)) {
            return;
          }
          i = bg.b(5);
          j = 0;
        }
        a.a(paramContext, i, j, f.c(paramContext, 5), 0, localMSolution.mJumpIntent.mPackage);
      }
    }
  }
  
  public static void b(final Context paramContext)
  {
    if (Build.VERSION.SDK_INT > 24)
    {
      f.a(paramContext, -1);
      return;
    }
    if (f.d(paramContext)) {
      return;
    }
    if (f.a(paramContext) == 2)
    {
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
          Context localContext;
          int i;
          if (paramAnonymousBoolean)
          {
            localContext = paramContext;
            i = 0;
          }
          else
          {
            localContext = paramContext;
            i = -1;
          }
          f.a(localContext, i);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.h
 * JD-Core Version:    0.7.0.1
 */
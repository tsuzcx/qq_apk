package com.tencent.qqpimsecure.pg;

import Protocol.MGuide.MIntent;
import Protocol.MGuide.MSolution;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import taiji.ca;
import tmsdk.common.module.pgsdk.IPermissionChecker;

public class y
{
  public static void a(Context paramContext)
  {
    long l = q.c(paramContext);
    int i = r.a().a.checkPermission(5);
    MSolution localMSolution;
    if (System.currentTimeMillis() - l > 5000L)
    {
      q.b(paramContext, i);
      if (l > 0L)
      {
        q.b(paramContext, 0L);
        localMSolution = m.a(paramContext, 5);
        if (i != 0) {
          break label93;
        }
        if ((localMSolution != null) && (localMSolution.mJumpIntent != null)) {
          f.a(paramContext, 30109, 1, q.c(paramContext, 5), 0, localMSolution.mJumpIntent.mPackage);
        }
      }
    }
    label93:
    while ((localMSolution == null) || (localMSolution.mJumpIntent == null)) {
      return;
    }
    f.a(paramContext, ca.b(5), 0, q.c(paramContext, 5), 0, localMSolution.mJumpIntent.mPackage);
  }
  
  public static void b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT > 24) {
      q.a(paramContext, -1);
    }
    while ((q.d(paramContext)) || (q.a(paramContext) != 2)) {
      return;
    }
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = 0;
    localLayoutParams.height = 0;
    localLayoutParams.type = 2005;
    z localz = new z(paramContext, paramContext);
    Handler localHandler = new Handler(Looper.getMainLooper());
    localHandler.post(new aa(localz, localWindowManager, localLayoutParams, paramContext));
    localHandler.postDelayed(new ab(localz, localWindowManager), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.y
 * JD-Core Version:    0.7.0.1
 */
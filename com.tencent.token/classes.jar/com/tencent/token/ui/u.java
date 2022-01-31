package com.tencent.token.ui;

import android.os.Handler;
import android.util.Log;
import com.tencent.token.fk;
import com.tmsdk.TMSDKContext;
import tmsdk.common.module.pgsdk.PermissionGuide;

class u
  implements Runnable
{
  u(AccountPageActivity paramAccountPageActivity) {}
  
  public void run()
  {
    boolean bool5 = true;
    if (fk.a("guide_qqpimsecure_tips_main_last_show_time"))
    {
      this.a.mHandler.post(new v(this));
      fk.a("guide_qqpimsecure_tips_main_last_show_time", System.currentTimeMillis());
    }
    for (;;)
    {
      boolean bool1;
      boolean bool3;
      try
      {
        Log.i("permission_test", "开始判断存活、自启权限.");
        int[] arrayOfInt = PermissionGuide.checkPermissions(new int[] { 3, 4 });
        Log.i("permission_test", "判断结果：[存活] " + arrayOfInt[0] + " [自启] " + arrayOfInt[1]);
        long l = fk.b("permission_guide_click_time", 0L);
        if (System.currentTimeMillis() - l <= 604800000L) {
          break label422;
        }
        bool2 = true;
        Log.i("permission_test", "距离上次点击引导的时间是否超过一周: " + bool2);
        if (arrayOfInt[0] != 0)
        {
          TMSDKContext.saveActionData(1150113);
          if (arrayOfInt[0] != -1) {
            break label427;
          }
          bool1 = true;
          if (arrayOfInt[1] != 0)
          {
            TMSDKContext.saveActionData(1150111);
            if (arrayOfInt[1] != -1) {
              break label449;
            }
            bool2 = true;
            Log.i("permission_test", "从时间和结果上判断是否应引导：[存活] " + bool1 + " [自启] " + bool2);
            if (PermissionGuide.hasAdapterSolution(3) == 0) {
              continue;
            }
            bool4 = true;
            if (PermissionGuide.hasAdapterSolution(4) == 0) {
              continue;
            }
            bool3 = true;
            Log.i("permission_test", "是否有引导方案：[存活] " + bool4 + " [自启] " + bool3);
            if ((!bool1) || (!bool4)) {
              continue;
            }
            bool1 = true;
            break label407;
            Log.i("permission_test", "是否引导的最终判断（结合时间、结果以及是否有方案）：[存活] " + bool1 + " [自启] " + bool2);
            if ((!bool1) && (!bool2)) {
              break label421;
            }
            this.a.mHandler.post(new w(this, bool1, bool2));
          }
        }
        else
        {
          TMSDKContext.saveActionData(1150112);
          break label444;
        }
        TMSDKContext.saveActionData(1150110);
        bool2 = false;
        continue;
        boolean bool4 = false;
        continue;
        bool3 = false;
        continue;
        bool1 = false;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      boolean bool2 = false;
      continue;
      label407:
      if ((bool2) && (bool3))
      {
        bool2 = bool5;
        continue;
        label421:
        return;
        label422:
        bool2 = false;
        continue;
        label427:
        if ((localThrowable[0] == 2) && (bool2))
        {
          bool1 = true;
        }
        else
        {
          label444:
          bool1 = false;
          continue;
          label449:
          if ((localThrowable[1] == 2) && (bool2)) {
            bool2 = true;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.u
 * JD-Core Version:    0.7.0.1
 */
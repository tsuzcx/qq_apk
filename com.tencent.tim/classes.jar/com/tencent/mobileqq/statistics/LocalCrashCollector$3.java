package com.tencent.mobileqq.statistics;

import acfp;
import android.support.v4.app.FragmentActivity;
import anoj;
import anok;
import aqha;
import aqju;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class LocalCrashCollector$3
  implements Runnable
{
  LocalCrashCollector$3(LocalCrashCollector paramLocalCrashCollector) {}
  
  public void run()
  {
    try
    {
      SessionInfo localSessionInfo = LocalCrashCollector.a(this.this$0).a();
      FragmentActivity localFragmentActivity = LocalCrashCollector.a(this.this$0).mActivity;
      Object localObject;
      String str;
      if (LocalCrashCollector.a(this.this$0) > 0)
      {
        localObject = acfp.m(2131707889) + localSessionInfo.aTn;
        if (LocalCrashCollector.a(this.this$0) <= 0) {
          break label183;
        }
        str = "Crash count: " + LocalCrashCollector.a(this.this$0) + "\n" + "CrashInfoSummary.txt";
        label107:
        if (LocalCrashCollector.a(this.this$0) <= 0) {
          break label188;
        }
      }
      label183:
      label188:
      for (int i = 2131691441;; i = 2131721079)
      {
        localObject = aqha.a(localFragmentActivity, 230, (String)localObject, str, 2131721058, i, new anoj(this, localSessionInfo), new anok(this));
        ((aqju)localObject).adjustTitle();
        if (LocalCrashCollector.a(this.this$0).mActivity.isFinishing()) {
          return;
        }
        ((aqju)localObject).show();
        return;
        localObject = "0 Crash";
        break;
        str = null;
        break label107;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.LocalCrashCollector.3
 * JD-Core Version:    0.7.0.1
 */
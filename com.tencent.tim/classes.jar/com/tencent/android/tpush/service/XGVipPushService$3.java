package com.tencent.android.tpush.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CloudManager;

final class XGVipPushService$3
  implements Runnable
{
  XGVipPushService$3(Context paramContext) {}
  
  public void run()
  {
    try
    {
      if (CloudManager.getInstance(this.a).disableShareBugly())
      {
        TLogger.d("XGVipPushService", "initBuglyInfo | disable share bugly");
        return;
      }
      SharedPreferences.Editor localEditor = this.a.getSharedPreferences("BuglySdkInfos", 0).edit();
      localEditor.putString("42510ae4dd", "1.2.7.3");
      localEditor.apply();
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("XGVipPushService", "initBuglyInfo :", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.XGVipPushService.3
 * JD-Core Version:    0.7.0.1
 */
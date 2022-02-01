package com.tencent.mobileqq.mini.cache;

import acfp;
import android.app.Activity;
import aqha;
import aqju;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;

final class MiniCacheFreeManager$1
  implements Runnable
{
  MiniCacheFreeManager$1(Activity paramActivity, String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    if ((this.val$activity == null) || (this.val$activity.isFinishing())) {
      QLog.e("MiniCacheFreeManager", 1, "freeCacheDialog activity is null");
    }
    for (;;)
    {
      return;
      try
      {
        aqju localaqju = aqha.a(this.val$activity, 230, null, this.val$dialogContext, acfp.m(2131711635), acfp.m(2131711636), new MiniCacheFreeManager.1.1(this), new MiniCacheFreeManager.1.2(this));
        localaqju.setCanceledOnTouchOutside(false);
        if ((this.val$activity != null) && (!this.val$activity.isFinishing()))
        {
          localaqju.show();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MiniCacheFreeManager", 1, "freeCacheDialog exception ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.NativeAd.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awit;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class NativeAdUtils$4
  implements Runnable
{
  public NativeAdUtils$4(String paramString) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
    if (localObject != null)
    {
      localObject = awit.a((AppRuntime)localObject, true, false);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        if (localObject != null)
        {
          ((SharedPreferences.Editor)localObject).putString("sp_key_ad_cookie", this.Vo);
          awit.a((SharedPreferences.Editor)localObject, true);
          if (QLog.isColorLevel()) {
            QLog.d("NativeAdUtils", 2, "saveAdCookie cookie=" + this.Vo);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.4
 * JD-Core Version:    0.7.0.1
 */
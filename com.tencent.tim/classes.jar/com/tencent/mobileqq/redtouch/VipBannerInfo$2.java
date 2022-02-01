package com.tencent.mobileqq.redtouch;

import altu;
import altv;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public final class VipBannerInfo$2
  implements Runnable
{
  public VipBannerInfo$2(WeakReference paramWeakReference, SharedPreferences paramSharedPreferences, MqqHandler paramMqqHandler) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.aT.get();
    if (localQQAppInterface == null) {
      return;
    }
    altu.a(localQQAppInterface, new altv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.VipBannerInfo.2
 * JD-Core Version:    0.7.0.1
 */
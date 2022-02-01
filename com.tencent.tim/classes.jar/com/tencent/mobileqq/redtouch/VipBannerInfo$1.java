package com.tencent.mobileqq.redtouch;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class VipBannerInfo$1
  implements Runnable
{
  public void run()
  {
    this.v.edit().putBoolean("new_red_point_received", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.VipBannerInfo.1
 * JD-Core Version:    0.7.0.1
 */
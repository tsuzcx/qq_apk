package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;

class NotificationActivity$2
  implements Runnable
{
  NotificationActivity$2(NotificationActivity paramNotificationActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("SecResEntry", -1);
    if ((i == -1) || ((i ^ 0x12) != this.bIP))
    {
      localEditor.putInt("SecResEntry", this.bIP ^ 0x12);
      localEditor.putLong("SecStampEntry", System.currentTimeMillis() ^ 0x12);
      localEditor.putInt("SecCacheTime", this.bIQ);
      localEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.2
 * JD-Core Version:    0.7.0.1
 */
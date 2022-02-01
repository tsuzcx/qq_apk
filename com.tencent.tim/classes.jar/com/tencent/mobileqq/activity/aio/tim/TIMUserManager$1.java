package com.tencent.mobileqq.activity.aio.tim;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import yhv;

public class TIMUserManager$1
  implements Runnable
{
  public TIMUserManager$1(yhv paramyhv, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    if (yhv.a(this.this$0, this.zx, this.aWG) == 0) {
      if (yhv.a(this.this$0, this.aWG))
      {
        yhv.a(this.this$0);
        yhv.a(this.this$0, false);
        yhv.a(this.this$0, 2);
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.val$app.getApp()).edit();
        localEditor.putBoolean("tim_user_special_need_force_download", yhv.a(this.this$0));
        localEditor.commit();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TIMUserManager", 2, this.bjZ + " startDownLoadTimTheme TimIconsState " + yhv.a(this.this$0));
      }
      return;
      yhv.a(this.this$0, 4);
      continue;
      yhv.a(this.this$0, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tim.TIMUserManager.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.qim;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import xva;

public class QIMUserManager$1
  implements Runnable
{
  public QIMUserManager$1(xva paramxva, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    if (xva.a(this.this$0, this.zx, this.aWG) == 0) {
      if (xva.a(this.this$0, this.aWG))
      {
        xva.a(this.this$0);
        xva.a(this.this$0, false);
        xva.a(this.this$0, 2);
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.val$app.getApp()).edit();
        localEditor.putBoolean("qim_user_special_need_force_download", xva.a(this.this$0));
        localEditor.commit();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMUserManager", 2, this.bjZ + " startDownLoadQimTheme QimIconsState " + xva.a(this.this$0));
      }
      return;
      xva.a(this.this$0, 4);
      continue;
      xva.a(this.this$0, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.1
 * JD-Core Version:    0.7.0.1
 */
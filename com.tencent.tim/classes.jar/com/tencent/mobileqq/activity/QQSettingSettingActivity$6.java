package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Date;

class QQSettingSettingActivity$6
  implements Runnable
{
  QQSettingSettingActivity$6(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void run()
  {
    Object localObject = this.this$0.getSharedPreferences("sp_qs_settings", 0);
    long l1 = ((SharedPreferences)localObject).getLong("qsec_status_update_last_time" + this.this$0.app.getCurrentAccountUin(), 0L);
    long l2 = ((SharedPreferences)localObject).getLong("qsec_status_expired_time" + this.this$0.app.getCurrentAccountUin(), 3600L);
    if (new Date().getTime() - l1 <= l2 * 1000L)
    {
      localObject = ((SharedPreferences)localObject).getString("qsec_status_tip_text" + this.this$0.app.getCurrentAccountUin(), "");
      this.this$0.runOnUiThread(new QQSettingSettingActivity.6.1(this, (String)localObject));
      return;
    }
    QQSettingSettingActivity.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.6
 * JD-Core Version:    0.7.0.1
 */
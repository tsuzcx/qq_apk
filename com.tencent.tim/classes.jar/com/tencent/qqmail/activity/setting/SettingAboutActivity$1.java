package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.osslog.QMOssClient;

class SettingAboutActivity$1
  implements View.OnLongClickListener
{
  SettingAboutActivity$1(SettingAboutActivity paramSettingAboutActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (QMSettingManager.sharedInstance().getBonus())
    {
      QMSettingManager.sharedInstance().setBonus(false);
      QMOssClient.getInstance().hideSubmitLogNotification();
      Toast.makeText(this.this$0.getApplicationContext(), this.this$0.getString(2131692552), 0).show();
      return false;
    }
    QMSettingManager.sharedInstance().setBonus(true);
    if (QMSettingManager.sharedInstance().getBonusTest()) {
      QMOssClient.getInstance().showSubmitLogNotification();
    }
    Toast.makeText(this.this$0.getApplicationContext(), this.this$0.getString(2131692551), 0).show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAboutActivity.1
 * JD-Core Version:    0.7.0.1
 */
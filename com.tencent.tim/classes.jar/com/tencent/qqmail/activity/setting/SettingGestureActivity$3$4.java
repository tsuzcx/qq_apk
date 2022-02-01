package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMGesturePasswordView;

class SettingGestureActivity$3$4
  implements SettingGestureActivity.VerifyCallback
{
  SettingGestureActivity$3$4(SettingGestureActivity.3 param3) {}
  
  public void handleError(int paramInt)
  {
    SettingGestureActivity.3.access$1002(this.this$1, paramInt);
    SettingGestureActivity.access$000(this.this$1.this$0).showError(this.this$1.this$0.getString(2131719862));
  }
  
  public void handleExceedMaxTimes()
  {
    QMLog.log(4, "SettingGestureActivity", "handleExceed. modify gesture password");
    SettingGestureActivity.3.access$900(this.this$1);
  }
  
  public void handleSuccess()
  {
    QMLog.log(4, "SettingGestureActivity", "close verify success");
    Intent localIntent = SettingGestureActivity.createIntent(3);
    this.this$1.this$0.startActivity(localIntent);
    this.this$1.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingGestureActivity.3.4
 * JD-Core Version:    0.7.0.1
 */
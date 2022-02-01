package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMGesturePasswordView;

class SettingGestureActivity$3$3
  implements SettingGestureActivity.VerifyCallback
{
  SettingGestureActivity$3$3(SettingGestureActivity.3 param3) {}
  
  public void handleError(int paramInt)
  {
    SettingGestureActivity.3.access$1002(this.this$1, paramInt);
    SettingGestureActivity.access$000(this.this$1.this$0).showError(this.this$1.this$0.getString(2131719862));
  }
  
  public void handleExceedMaxTimes()
  {
    QMLog.log(4, "SettingGestureActivity", "handleExceed. close gesture password");
    SettingGestureActivity.3.access$900(this.this$1);
  }
  
  public void handleSuccess()
  {
    QMLog.log(4, "SettingGestureActivity", "close verify success");
    SettingGestureConfigActivity.disableGesturePassword();
    this.this$1.this$0.finish();
    if (QMActivityManager.shareInstance().getActivitySize() <= 0)
    {
      this.this$1.this$0.overridePendingTransition(2130772023, 2130772423);
      return;
    }
    this.this$1.this$0.overridePendingTransition(2130772423, 2130772025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingGestureActivity.3.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingAccountActivity$3$1
  implements Runnable
{
  SettingAccountActivity$3$1(SettingAccountActivity.3 param3, int paramInt) {}
  
  public void run()
  {
    this.this$1.this$0.getTips().hide();
    this.this$1.this$0.getTips().showSuccess(this.this$1.this$0.getString(2131719978));
    QMLog.log(4, "SettingAccountActivity", "setPhotoWatcher tips:" + this.val$accountId);
    if (SettingAccountActivity.access$600(this.this$1.this$0) != null)
    {
      SettingAccountActivity.access$100(this.this$1.this$0).setAvatar(SettingAccountActivity.access$600(this.this$1.this$0));
      SettingAccountActivity.access$200(this.this$1.this$0).setDetail(SettingAccountActivity.access$100(this.this$1.this$0).getBitmap());
      SettingAccountActivity.access$700(this.this$1.this$0, new SettingAccountActivity.3.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.3.1
 * JD-Core Version:    0.7.0.1
 */
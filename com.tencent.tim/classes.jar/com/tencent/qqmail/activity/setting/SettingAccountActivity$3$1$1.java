package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;

class SettingAccountActivity$3$1$1
  implements Runnable
{
  SettingAccountActivity$3$1$1(SettingAccountActivity.3.1 param1) {}
  
  public void run()
  {
    ImageUtil.cutPhotoAndSave(SettingAccountActivity.access$600(this.this$2.this$1.this$0), SettingAccountActivity.access$000(this.this$2.this$1.this$0).getEmail());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.3.1.1
 * JD-Core Version:    0.7.0.1
 */
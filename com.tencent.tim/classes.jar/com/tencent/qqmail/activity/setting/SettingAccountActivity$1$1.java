package com.tencent.qqmail.activity.setting;

import android.graphics.Bitmap;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import java.util.List;

class SettingAccountActivity$1$1
  implements Runnable
{
  SettingAccountActivity$1$1(SettingAccountActivity.1 param1, List paramList) {}
  
  public void run()
  {
    if (this.val$emails.contains(SettingAccountActivity.access$000(this.this$1.this$0).getEmail()))
    {
      Bitmap localBitmap = QMSettingManager.sharedInstance().getAccountIconLocal(SettingAccountActivity.access$000(this.this$1.this$0).getEmail(), 4);
      if (localBitmap != null)
      {
        SettingAccountActivity.access$100(this.this$1.this$0).setAvatar(localBitmap);
        SettingAccountActivity.access$200(this.this$1.this$0).setDetail(SettingAccountActivity.access$100(this.this$1.this$0).getBitmap());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.1.1
 * JD-Core Version:    0.7.0.1
 */
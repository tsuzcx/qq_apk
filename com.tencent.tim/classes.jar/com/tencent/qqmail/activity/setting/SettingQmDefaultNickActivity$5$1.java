package com.tencent.qqmail.activity.setting;

import android.widget.EditText;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingQmDefaultNickActivity$5$1
  implements Runnable
{
  SettingQmDefaultNickActivity$5$1(SettingQmDefaultNickActivity.5 param5) {}
  
  public void run()
  {
    SettingQmDefaultNickActivity.access$602(this.this$1.this$0, SettingQmDefaultNickActivity.access$300(this.this$1.this$0).getText().toString());
    SettingQmDefaultNickActivity.access$200(this.this$1.this$0, false);
    if (SettingQmDefaultNickActivity.access$600(this.this$1.this$0).length() > 32) {
      Toast.makeText(QMApplicationContext.sharedInstance(), "昵称不能超过32个字符", 0).show();
    }
    do
    {
      return;
      SettingQmDefaultNickActivity.access$100(this.this$1.this$0).setDetail(SettingQmDefaultNickActivity.access$600(this.this$1.this$0));
      SettingQmDefaultNickActivity.access$700(this.this$1.this$0);
    } while (QMSettingManager.sharedInstance().getDefaultMailAccountID() != SettingQmDefaultNickActivity.access$800(this.this$1.this$0));
    QMSyncAdapterManager.checkAccount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingQmDefaultNickActivity.5.1
 * JD-Core Version:    0.7.0.1
 */
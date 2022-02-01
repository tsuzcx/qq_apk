package com.tencent.qqmail.activity.setting;

import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.alias.QMAliasManager;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingIndependentNickActivity$2$1
  implements Runnable
{
  SettingIndependentNickActivity$2$1(SettingIndependentNickActivity.2 param2, String paramString) {}
  
  public void run()
  {
    SettingIndependentNickActivity.access$300(this.this$1.this$0).setDetail(this.val$nick);
    if (SettingIndependentNickActivity.access$200(this.this$1.this$0).getText().length() != 0) {
      SettingIndependentNickActivity.access$400(this.this$1.this$0, false);
    }
    while (this.val$nick.length() > 32)
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), "昵称不能超过32个字符", 0).show();
      return;
      SettingIndependentNickActivity.access$000(this.this$1.this$0, true);
      SettingIndependentNickActivity.access$200(this.this$1.this$0).setVisibility(8);
    }
    DataCollector.logEvent("Event_Compose_Set_Account_Nick");
    QMComposeDataManager.sharedInstance().setQMAliasNick(SettingIndependentNickActivity.access$500(this.this$1.this$0), SettingIndependentNickActivity.access$600(this.this$1.this$0), SettingIndependentNickActivity.access$200(this.this$1.this$0).getText().toString());
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new SettingIndependentNickActivity.2.1.1(this));
    localQMCallback.setOnError(new SettingIndependentNickActivity.2.1.2(this));
    QMAliasManager.shareInstance().syncQMAliasNick(SettingIndependentNickActivity.access$600(this.this$1.this$0), SettingIndependentNickActivity.access$500(this.this$1.this$0), this.val$nick, localQMCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingIndependentNickActivity.2.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.activity.setting;

import android.widget.EditText;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingCardActivity$4$1
  implements Runnable
{
  SettingCardActivity$4$1(SettingCardActivity.4 param4) {}
  
  public void run()
  {
    SettingCardActivity.access$302(this.this$1.this$0, SettingCardActivity.access$400(this.this$1.this$0).getText().toString());
    SettingCardActivity.access$500(this.this$1.this$0, false);
    if (SettingCardActivity.access$300(this.this$1.this$0).length() > 32)
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), "昵称不能超过32个字符", 0).show();
      return;
    }
    SettingCardActivity.access$600(this.this$1.this$0).setDetail(SettingCardActivity.access$300(this.this$1.this$0));
    CardUtil.setDefaultSendName(SettingCardActivity.access$300(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCardActivity.4.1
 * JD-Core Version:    0.7.0.1
 */
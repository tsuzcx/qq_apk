package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingAccountActivity$11$1
  implements Runnable
{
  SettingAccountActivity$11$1(SettingAccountActivity.11 param11, UITableItemView paramUITableItemView) {}
  
  public void run()
  {
    QMSettingManager.sharedInstance().setAggregateSubject(SettingAccountActivity.access$300(this.this$1.this$0), this.val$itemView.isChecked());
    QMMailManager.sharedInstance().setAggregateBySubject(SettingAccountActivity.access$300(this.this$1.this$0), this.val$itemView.isChecked());
    if (this.val$itemView.isChecked())
    {
      DataCollector.logDetailEvent("DetailEvent_Open_Conversation_View", SettingAccountActivity.access$300(this.this$1.this$0), 0L, "1");
      return;
    }
    DataCollector.logDetailEvent("DetailEvent_Open_Conversation_View", SettingAccountActivity.access$300(this.this$1.this$0), 0L, "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.11.1
 * JD-Core Version:    0.7.0.1
 */
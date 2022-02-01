package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingFtnActivity$2
  implements UITableView.ClickListener
{
  SettingFtnActivity$2(SettingFtnActivity paramSettingFtnActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (SettingFtnActivity.access$100(this.this$0) > 0)
    {
      boolean bool;
      if (!paramUITableItemView.isChecked())
      {
        bool = true;
        paramUITableItemView.setChecked(bool);
        SettingFtnActivity.access$202(this.this$0, paramUITableItemView.isChecked());
        QMSettingManager.sharedInstance().setFtnDisplay(paramUITableItemView.isChecked());
        if (!SettingFtnActivity.access$200(this.this$0)) {
          break label75;
        }
        DataCollector.logEvent("Event_Turn_On_Ftn");
      }
      for (;;)
      {
        this.this$0.refreshData();
        return;
        bool = false;
        break;
        label75:
        DataCollector.logEvent("Event_Turn_Off_Ftn");
      }
    }
    paramUITableItemView = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0).setTitle(2131719847)).setMessage(2131719846).addAction(2131691246, new SettingFtnActivity.2.2(this))).addAction(2131719650, new SettingFtnActivity.2.1(this))).create();
    paramUITableItemView.setCanceledOnTouchOutside(false);
    paramUITableItemView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingFtnActivity.2
 * JD-Core Version:    0.7.0.1
 */
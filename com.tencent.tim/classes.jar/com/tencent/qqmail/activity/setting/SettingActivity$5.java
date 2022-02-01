package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.download.activity.DownloadActivity;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingActivity$5
  implements UITableView.ClickListener
{
  SettingActivity$5(SettingActivity paramSettingActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    if (paramUITableItemView == SettingActivity.access$300(this.this$0))
    {
      if (!paramUITableItemView.isChecked())
      {
        bool1 = true;
        paramUITableItemView.setChecked(bool1);
        QMSettingManager.sharedInstance().setShowMailListAvatar(paramUITableItemView.isChecked());
        QMSettingManager.sharedInstance().setMailListHeadClicked();
        QMMailManager.sharedInstance().setMailListAvatar(paramUITableItemView.isChecked());
        paramUITableItemView = SettingActivity.access$300(this.this$0);
        if (QMSettingManager.sharedInstance().getMailListHeadClicked()) {
          break label91;
        }
      }
      label91:
      for (bool1 = bool2;; bool1 = false)
      {
        paramUITableItemView.showNew(bool1);
        return;
        bool1 = false;
        break;
      }
    }
    if (paramUITableItemView == SettingActivity.access$400(this.this$0))
    {
      if (!paramUITableItemView.isChecked()) {}
      for (;;)
      {
        paramUITableItemView.setChecked(bool1);
        SettingActivity.access$500(this.this$0, new SettingActivity.5.1(this, paramUITableItemView));
        return;
        bool1 = false;
      }
    }
    if (paramUITableItemView == SettingActivity.access$600(this.this$0))
    {
      if (!paramUITableItemView.isChecked()) {}
      for (bool1 = bool3;; bool1 = false)
      {
        paramUITableItemView.setChecked(bool1);
        SettingActivity.access$700(this.this$0, new SettingActivity.5.2(this, paramUITableItemView));
        return;
      }
    }
    if (paramUITableItemView == SettingActivity.access$800(this.this$0))
    {
      paramUITableItemView = SettingMailImageActivity.createIntent();
      this.this$0.startActivity(paramUITableItemView);
      return;
    }
    if (paramUITableItemView == SettingActivity.access$900(this.this$0))
    {
      paramUITableItemView = DownloadActivity.createIntent();
      this.this$0.startActivity(paramUITableItemView);
      DataCollector.logEvent("Event_Enter_DownloadManager");
      return;
    }
    QMLog.log(6, "SettingActivity", "mailOptionListOnClickListener error index" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingActivity.5
 * JD-Core Version:    0.7.0.1
 */
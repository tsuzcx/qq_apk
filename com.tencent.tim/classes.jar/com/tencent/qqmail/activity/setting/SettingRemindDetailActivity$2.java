package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingRemindDetailActivity$2
  implements UITableView.ClickListener
{
  SettingRemindDetailActivity$2(SettingRemindDetailActivity paramSettingRemindDetailActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    if (paramUITableItemView == null) {
      QMLog.log(5, "SettingRemindDetailActivity", SettingRemindDetailActivity.class.getSimpleName() + " detailTableClick itemview is null:" + paramInt);
    }
    do
    {
      return;
      if (((SettingRemindDetailActivity.access$500(this.this$0) != null) && (paramUITableItemView == SettingRemindDetailActivity.access$500(this.this$0))) || ((SettingRemindDetailActivity.access$600(this.this$0) != null) && (paramUITableItemView == SettingRemindDetailActivity.access$600(this.this$0))))
      {
        if (!paramUITableItemView.isChecked()) {}
        for (;;)
        {
          paramUITableItemView.setChecked(bool1);
          if (!SettingRemindDetailActivity.access$000(this.this$0).isQQMail()) {
            break;
          }
          paramInt = QMFolderManager.sharedInstance().getInboxFolderId(SettingRemindDetailActivity.access$100(this.this$0));
          SettingRemindDetailActivity.access$700(this.this$0, paramInt, paramUITableItemView.isChecked());
          return;
          bool1 = false;
        }
        QMSettingManager.sharedInstance().setPushInboxOnly(SettingRemindDetailActivity.access$100(this.this$0), paramUITableItemView.isChecked());
        QMPrivateProtocolManager.sharedInstance().setOnlyNotifyInbox(SettingRemindDetailActivity.access$100(this.this$0), paramUITableItemView.isChecked());
        return;
      }
      if ((SettingRemindDetailActivity.access$800(this.this$0) != null) && (paramUITableItemView == SettingRemindDetailActivity.access$800(this.this$0)))
      {
        if (!paramUITableItemView.isChecked()) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramUITableItemView.setChecked(bool1);
          paramInt = QMFolderManager.sharedInstance().getQQMailGroupFolderId(SettingRemindDetailActivity.access$100(this.this$0));
          SettingRemindDetailActivity.access$700(this.this$0, paramInt, paramUITableItemView.isChecked());
          return;
        }
      }
      if ((SettingRemindDetailActivity.access$900(this.this$0) != null) && (paramUITableItemView == SettingRemindDetailActivity.access$900(this.this$0)))
      {
        if (!paramUITableItemView.isChecked()) {}
        for (bool1 = bool3;; bool1 = false)
        {
          paramUITableItemView.setChecked(bool1);
          paramInt = QMFolderManager.sharedInstance().getQQMailSubFolderId(SettingRemindDetailActivity.access$100(this.this$0));
          SettingRemindDetailActivity.access$700(this.this$0, paramInt, paramUITableItemView.isChecked());
          return;
        }
      }
      if ((SettingRemindDetailActivity.access$1000(this.this$0) != null) && (paramUITableItemView == SettingRemindDetailActivity.access$1000(this.this$0)))
      {
        paramUITableItemView = SettingRemindFoldersActivity.createIntent(SettingRemindDetailActivity.access$100(this.this$0));
        this.this$0.startActivity(paramUITableItemView);
        return;
      }
    } while ((SettingRemindDetailActivity.access$1100(this.this$0) == null) || (paramUITableItemView != SettingRemindDetailActivity.access$1100(this.this$0)));
    paramUITableItemView = SettingRemindSubAccountActivity.createIntent(SettingRemindDetailActivity.access$100(this.this$0));
    this.this$0.startActivity(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingRemindDetailActivity.2
 * JD-Core Version:    0.7.0.1
 */
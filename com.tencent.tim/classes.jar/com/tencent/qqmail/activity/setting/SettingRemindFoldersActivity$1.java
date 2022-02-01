package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.List;

class SettingRemindFoldersActivity$1
  implements UITableView.ClickListener
{
  SettingRemindFoldersActivity$1(SettingRemindFoldersActivity paramSettingRemindFoldersActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramInt = 0;
    boolean bool;
    if (!paramUITableItemView.isChecked())
    {
      bool = true;
      paramUITableItemView.setChecked(bool);
      if (!paramUITableItemView.isChecked()) {
        break label236;
      }
      SettingRemindFoldersActivity.access$002(this.this$0, SettingRemindFoldersActivity.access$100(this.this$0).size());
      if (SettingRemindFoldersActivity.access$200(this.this$0) != null) {
        break label195;
      }
      SettingRemindFoldersActivity.access$300(this.this$0);
    }
    for (;;)
    {
      SettingRemindFoldersActivity.access$400(this.this$0, true);
      paramUITableItemView = new int[SettingRemindFoldersActivity.access$100(this.this$0).size()];
      arrayOfString = new String[SettingRemindFoldersActivity.access$100(this.this$0).size()];
      arrayOfBoolean = new boolean[SettingRemindFoldersActivity.access$100(this.this$0).size()];
      while (paramInt < SettingRemindFoldersActivity.access$100(this.this$0).size())
      {
        paramUITableItemView[paramInt] = ((QMFolder)SettingRemindFoldersActivity.access$100(this.this$0).get(paramInt)).getId();
        arrayOfString[paramInt] = ((QMFolder)SettingRemindFoldersActivity.access$100(this.this$0).get(paramInt)).getRemoteId();
        arrayOfBoolean[paramInt] = true;
        paramInt += 1;
      }
      bool = false;
      break;
      label195:
      SettingRemindFoldersActivity.access$200(this.this$0).setVisibility(0);
    }
    QMFolderManager.sharedInstance().updateFolderPushStatus(paramUITableItemView, arrayOfBoolean);
    QMMailManager.sharedInstance().updateFolderPushStatus(SettingRemindFoldersActivity.access$500(this.this$0), arrayOfString, arrayOfBoolean);
    return;
    label236:
    SettingRemindFoldersActivity.access$002(this.this$0, 0);
    if (SettingRemindFoldersActivity.access$200(this.this$0) != null) {
      SettingRemindFoldersActivity.access$200(this.this$0).setVisibility(8);
    }
    paramUITableItemView = new int[SettingRemindFoldersActivity.access$100(this.this$0).size()];
    String[] arrayOfString = new String[SettingRemindFoldersActivity.access$100(this.this$0).size()];
    boolean[] arrayOfBoolean = new boolean[SettingRemindFoldersActivity.access$100(this.this$0).size()];
    paramInt = 0;
    while (paramInt < SettingRemindFoldersActivity.access$100(this.this$0).size())
    {
      paramUITableItemView[paramInt] = ((QMFolder)SettingRemindFoldersActivity.access$100(this.this$0).get(paramInt)).getId();
      arrayOfString[paramInt] = ((QMFolder)SettingRemindFoldersActivity.access$100(this.this$0).get(paramInt)).getRemoteId();
      arrayOfBoolean[paramInt] = false;
      paramInt += 1;
    }
    QMFolderManager.sharedInstance().updateFolderPushStatus(paramUITableItemView, arrayOfBoolean);
    QMMailManager.sharedInstance().updateFolderPushStatus(SettingRemindFoldersActivity.access$500(this.this$0), arrayOfString, arrayOfBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingRemindFoldersActivity.1
 * JD-Core Version:    0.7.0.1
 */
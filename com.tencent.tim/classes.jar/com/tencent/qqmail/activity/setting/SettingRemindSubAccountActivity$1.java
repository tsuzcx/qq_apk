package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.ArrayList;
import java.util.List;

class SettingRemindSubAccountActivity$1
  implements UITableView.ClickListener
{
  SettingRemindSubAccountActivity$1(SettingRemindSubAccountActivity paramSettingRemindSubAccountActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (!paramUITableItemView.isChecked()) {}
    ArrayList localArrayList;
    int[] arrayOfInt;
    String[] arrayOfString;
    for (boolean bool = true;; bool = false)
    {
      paramUITableItemView.setChecked(bool);
      localArrayList = QMFolderManager.sharedInstance().getFoldersByAccountAndType(SettingRemindSubAccountActivity.access$000(this.this$0), 13);
      if (!paramUITableItemView.isChecked()) {
        break label222;
      }
      paramUITableItemView = new boolean[localArrayList.size()];
      arrayOfInt = new int[localArrayList.size()];
      arrayOfString = new String[localArrayList.size()];
      paramInt = 0;
      while (paramInt < localArrayList.size())
      {
        arrayOfInt[paramInt] = ((QMFolder)localArrayList.get(paramInt)).getId();
        arrayOfString[paramInt] = ((QMFolder)localArrayList.get(paramInt)).getRemoteId();
        paramUITableItemView[paramInt] = 1;
        paramInt += 1;
      }
    }
    QMFolderManager.sharedInstance().updateFolderPushStatus(arrayOfInt, paramUITableItemView);
    QMMailManager.sharedInstance().updateFolderPushStatus(SettingRemindSubAccountActivity.access$000(this.this$0), arrayOfString, paramUITableItemView);
    if (SettingRemindSubAccountActivity.access$100(this.this$0) == null)
    {
      SettingRemindSubAccountActivity.access$200(this.this$0);
      SettingRemindSubAccountActivity.access$300(this.this$0, true);
      SettingRemindSubAccountActivity.access$402(this.this$0, SettingRemindSubAccountActivity.access$500(this.this$0).size());
    }
    label222:
    do
    {
      return;
      SettingRemindSubAccountActivity.access$100(this.this$0).setVisibility(0);
      break;
      SettingRemindSubAccountActivity.access$402(this.this$0, 0);
      paramUITableItemView = new boolean[localArrayList.size()];
      arrayOfInt = new int[localArrayList.size()];
      arrayOfString = new String[localArrayList.size()];
      paramInt = 0;
      while (paramInt < localArrayList.size())
      {
        arrayOfInt[paramInt] = ((QMFolder)localArrayList.get(paramInt)).getId();
        arrayOfString[paramInt] = ((QMFolder)localArrayList.get(paramInt)).getRemoteId();
        paramUITableItemView[paramInt] = 0;
        paramInt += 1;
      }
      QMFolderManager.sharedInstance().updateFolderPushStatus(arrayOfInt, paramUITableItemView);
      QMMailManager.sharedInstance().updateFolderPushStatus(SettingRemindSubAccountActivity.access$000(this.this$0), arrayOfString, paramUITableItemView);
    } while (SettingRemindSubAccountActivity.access$100(this.this$0) == null);
    SettingRemindSubAccountActivity.access$100(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingRemindSubAccountActivity.1
 * JD-Core Version:    0.7.0.1
 */
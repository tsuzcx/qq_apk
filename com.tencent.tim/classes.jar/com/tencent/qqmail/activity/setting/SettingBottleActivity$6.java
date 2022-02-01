package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingBottleActivity$6
  implements UITableView.ClickListener
{
  SettingBottleActivity$6(SettingBottleActivity paramSettingBottleActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (SettingBottleActivity.access$1300(this.this$0) > 0)
    {
      if (!paramUITableItemView.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramUITableItemView.setChecked(bool);
        SettingBottleActivity.access$1402(this.this$0, paramUITableItemView.isChecked());
        QMSettingManager.sharedInstance().setBottleDisplay(paramUITableItemView.isChecked());
        this.this$0.refreshData();
        return;
      }
    }
    paramUITableItemView = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0).setTitle(2131719665)).setMessage(2131719664).addAction(2131691246, new SettingBottleActivity.6.2(this))).addAction(2131719650, new SettingBottleActivity.6.1(this))).create();
    paramUITableItemView.setCanceledOnTouchOutside(false);
    paramUITableItemView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingBottleActivity.6
 * JD-Core Version:    0.7.0.1
 */
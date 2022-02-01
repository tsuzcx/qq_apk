package com.tencent.qqmail.movemail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

class ManageFolderActivity$7
  implements View.OnClickListener
{
  ManageFolderActivity$7(ManageFolderActivity paramManageFolderActivity, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    QMUIDialog.MessageDialogBuilder localMessageDialogBuilder = (QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0).setTitle(ManageFolderActivity.access$1600(this.this$0))).setMessage(this.this$0.getString(this.val$hint)).addAction(2131691246, new ManageFolderActivity.7.1(this));
    if ((!ManageFolderActivity.access$600(this.this$0)) && (!ManageFolderActivity.access$1700(this.this$0)) && (ManageFolderActivity.access$1800(this.this$0).isQQMail())) {
      localMessageDialogBuilder.addAction(2131692474, new ManageFolderActivity.7.2(this));
    }
    localMessageDialogBuilder.addAction(0, this.this$0.getString(this.val$confirm), 2, new ManageFolderActivity.7.3(this));
    localMessageDialogBuilder.create().show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.7
 * JD-Core Version:    0.7.0.1
 */
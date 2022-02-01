package com.tencent.qqmail.download.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

class DownloadActivity$6
  implements View.OnClickListener
{
  DownloadActivity$6(DownloadActivity paramDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0).setTitle(2131692967)).setMessage(2131692951).addAction(2131691246, new DownloadActivity.6.2(this))).addAction(0, 2131691840, 2, new DownloadActivity.6.1(this))).create().show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.6
 * JD-Core Version:    0.7.0.1
 */
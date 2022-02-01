package com.tencent.qqmail;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;

class BaseActivityImpl$5$2
  implements Runnable
{
  BaseActivityImpl$5$2(BaseActivityImpl.5 param5, String paramString) {}
  
  public void run()
  {
    this.this$1.this$0.getTips().hide();
    if (QMActivityManager.shareInstance().getVisibleActivity() != null)
    {
      QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(BaseActivityImpl.access$000(this.this$1.this$0).getActivity()).setTitle(2131696424)).setMessage(String.format(QMApplicationContext.sharedInstance().getString(2131692639), new Object[] { this.val$email })).addAction(2131696547, new BaseActivityImpl.5.2.1(this))).create();
      localQMUIDialog.setOnDismissListener(new BaseActivityImpl.5.2.2(this));
      localQMUIDialog.setCancelable(false);
      localQMUIDialog.show();
      QMLog.log(4, "BaseActivityImpl", "show account wiped:" + this.val$email);
      return;
    }
    QMLog.log(6, "BaseActivityImpl", "visible activity not exist.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.5.2
 * JD-Core Version:    0.7.0.1
 */
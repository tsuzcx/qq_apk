package com.tencent.qqmail;

import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

class BaseActivityImpl$3$1
  implements Runnable
{
  BaseActivityImpl$3$1(BaseActivityImpl.3 param3, ComposeMailUI paramComposeMailUI) {}
  
  public void run()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(QMApplicationContext.sharedInstance().getString(2131690700));
    StringBuilder localStringBuilder2 = new StringBuilder(QMApplicationContext.sharedInstance().getString(2131690413));
    localStringBuilder1.append(this.val$composeMailUI.getFromAppName());
    localStringBuilder2.append(this.val$composeMailUI.getFromAppName());
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(BaseActivityImpl.access$000(this.this$1.this$0).getActivity()).setTitle(2131696424)).setMessage(QMApplicationContext.sharedInstance().getString(2131719537)).addAction(localStringBuilder1.toString(), new BaseActivityImpl.3.1.2(this, localStringBuilder2))).addAction(2131719538, new BaseActivityImpl.3.1.1(this))).create().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.3.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.activity.webviewexplorer.SimpleWebViewExplorer;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class ReadMailFragment$121
  implements QMUIDialogAction.ActionListener
{
  ReadMailFragment$121(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog = SimpleWebViewExplorer.createIntent(QMSettingManager.sharedInstance().getMiscCheckLink() + StringExtention.encodeURI("https://app.mail.qq.com/app/app_apple_id_verify_android_help.html"), SimpleWebViewExplorer.TOPBAR_LEFT_BUTTON);
    this.this$0.startActivity(paramQMUIDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.121
 * JD-Core Version:    0.7.0.1
 */
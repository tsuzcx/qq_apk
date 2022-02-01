package com.tencent.qqmail.account.helper;

import android.content.Context;
import com.tencent.qqmail.activity.webviewexplorer.SimpleWebViewExplorer;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

final class LoginUIHelper$17
  implements QMUIDialogAction.ActionListener
{
  LoginUIHelper$17(Context paramContext) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    DataCollector.logEvent("Event_Login_Click_Forget_Second_Password");
    paramQMUIDialog = SimpleWebViewExplorer.createIntent(QMSettingManager.sharedInstance().getMiscCheckLink() + StringExtention.encodeURI("https://aq.qq.com/cn2/findpsw/mobile_v2/mobile_web_find_input_account?find_type=2&source_id=3194&from=qq"), SimpleWebViewExplorer.TOPBAR_LEFT_BUTTON);
    this.val$context.startActivity(paramQMUIDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper.17
 * JD-Core Version:    0.7.0.1
 */
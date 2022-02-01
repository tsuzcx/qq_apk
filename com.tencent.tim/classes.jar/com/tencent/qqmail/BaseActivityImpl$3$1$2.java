package com.tencent.qqmail;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.log.QMLog;

class BaseActivityImpl$3$1$2
  implements QMUIDialogAction.ActionListener
{
  BaseActivityImpl$3$1$2(BaseActivityImpl.3.1 param1, StringBuilder paramStringBuilder) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    Intent localIntent;
    String str;
    if (DeviceUtil.isWeWorkInstalled())
    {
      localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setPackage("com.tencent.wework");
      str = this.this$2.val$composeMailUI.getCallback().replace("$result$", "1");
      paramQMUIDialog = this.this$2.val$composeMailUI.getInformation().getSendContact();
      if (paramQMUIDialog == null) {
        break label188;
      }
      if (paramQMUIDialog.getAddress() == null) {
        paramQMUIDialog = "";
      }
    }
    label188:
    for (paramQMUIDialog = str.replace("$email$", paramQMUIDialog);; paramQMUIDialog = str)
    {
      QMLog.log(4, "BaseActivityImpl", "send mail success return rtx callback:" + paramQMUIDialog);
      localIntent.setData(Uri.parse(paramQMUIDialog));
      try
      {
        this.this$2.this$1.this$0.startActivity(localIntent);
        return;
      }
      catch (Exception paramQMUIDialog)
      {
        Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131696561), 0).show();
        return;
      }
      paramQMUIDialog = paramQMUIDialog.getAddress();
      break;
      Toast.makeText(QMApplicationContext.sharedInstance(), this.val$notInstall.toString(), 0).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.3.1.2
 * JD-Core Version:    0.7.0.1
 */
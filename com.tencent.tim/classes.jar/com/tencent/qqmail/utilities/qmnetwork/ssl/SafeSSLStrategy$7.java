package com.tencent.qqmail.utilities.qmnetwork.ssl;

import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import moai.oss.KvHelper;
import rx.Subscriber;

final class SafeSSLStrategy$7
  implements QMUIDialogAction.ActionListener
{
  SafeSSLStrategy$7(int paramInt, String paramString, Subscriber paramSubscriber) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    KvHelper.confirmTrustSslCertificate(new double[0]);
    paramQMUIDialog.dismiss();
    SPManager.getEditor("trusted_certificate").putBoolean(this.val$id + "", true).apply();
    QMLog.log(4, "SafeSSLStrategy", "trust id:" + this.val$id + ", " + this.val$host);
    if (this.val$subscriber != null) {
      this.val$subscriber.onCompleted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.ssl.SafeSSLStrategy.7
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.utilities.qmnetwork.ssl;

import android.app.Activity;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import moai.oss.KvHelper;

final class SafeSSLStrategy$6
  implements QMUIDialogAction.ActionListener
{
  SafeSSLStrategy$6(Activity paramActivity, String paramString) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    KvHelper.checkSslDetail(new double[0]);
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.val$activity).setTitle("证书详情")).setMessage(this.val$certificateDetail).addAction(2131696547, new SafeSSLStrategy.6.1(this))).create().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.ssl.SafeSSLStrategy.6
 * JD-Core Version:    0.7.0.1
 */
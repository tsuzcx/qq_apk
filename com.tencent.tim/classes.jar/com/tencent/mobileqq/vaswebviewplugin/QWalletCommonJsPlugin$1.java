package com.tencent.mobileqq.vaswebviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class QWalletCommonJsPlugin$1
  extends BroadcastReceiver
{
  QWalletCommonJsPlugin$1(QWalletCommonJsPlugin paramQWalletCommonJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletCommonJsPlugin", 2, "onReceive:" + paramIntent.getAction());
    }
    if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction())) {
      this.this$0.mVideoJsPlugin.resumeOrPause(true, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
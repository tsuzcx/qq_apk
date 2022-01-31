package com.tencent.token.ui.qqpim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tmsdk.TMSDKContext;

public class QQPimNewActivity$InstallBroadcastReceiver
  extends BroadcastReceiver
{
  public QQPimNewActivity$InstallBroadcastReceiver(QQPimNewActivity paramQQPimNewActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED")) && (QQPimNewActivity.access$500(this.a)))
    {
      TMSDKContext.saveActionData(170024);
      QQPimNewActivity.access$502(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.QQPimNewActivity.InstallBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
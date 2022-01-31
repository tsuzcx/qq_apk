package com.tencent.token.ui.qqpim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tmsdk.TMSDKContext;

public class QQPimActivity$InstallBroadcastReceiver
  extends BroadcastReceiver
{
  public QQPimActivity$InstallBroadcastReceiver(QQPimActivity paramQQPimActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED")) && (QQPimActivity.access$200(this.a)))
    {
      TMSDKContext.saveActionData(170012);
      QQPimActivity.access$202(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.QQPimActivity.InstallBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
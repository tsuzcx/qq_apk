package com.tencent.androidqqmail.tim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class QMAppInterface$2
  extends BroadcastReceiver
{
  QMAppInterface$2(QMAppInterface paramQMAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      Log.d("QMAppInterface", "qqExitBroadcastReceiver");
    } while ((!"mqq.intent.action.LOGOUT".equals(paramIntent.getAction())) && (!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction())));
    QMAppInterface.access$102(this.this$0, paramIntent.getStringExtra("account"));
    Log.i("QMAppInterface", "Changed uin " + QMAppInterface.access$100(this.this$0));
    System.exit(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.QMAppInterface.2
 * JD-Core Version:    0.7.0.1
 */
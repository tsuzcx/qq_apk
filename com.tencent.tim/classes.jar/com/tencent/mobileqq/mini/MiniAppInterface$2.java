package com.tencent.mobileqq.mini;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class MiniAppInterface$2
  extends BroadcastReceiver
{
  MiniAppInterface$2(MiniAppInterface paramMiniAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.w("MiniAppInterface", 2, "accountReceiver.onReceive broacast action=" + paramContext);
      }
      if ("com.tencent.process.exit".equals(paramContext))
      {
        QLog.w("MiniAppInterface", 2, "accountReceiver.onReceive no exit!");
        return;
      }
      if (("mqq.intent.action.ACCOUNT_CHANGED".equals(paramContext)) || ("mqq.intent.action.ACCOUNT_KICKED".equals(paramContext)) || ("mqq.intent.action.ACCOUNT_EXPIRED".equals(paramContext)) || ("mqq.intent.action.LOGOUT".equals(paramContext)) || (("mqq.intent.action.EXIT_" + MiniAppInterface.access$100(this.this$0).getPackageName()).equals(paramContext)))
      {
        this.this$0.exitProcess();
        return;
      }
    } while (!"com.tencent.mobile.mini.process.exit".equals(paramContext));
    QLog.w("MiniAppInterface", 2, "ACTION_MINI_PROCESS_EXIT.onReceive exit!");
    this.this$0.exitProcess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.MiniAppInterface.2
 * JD-Core Version:    0.7.0.1
 */
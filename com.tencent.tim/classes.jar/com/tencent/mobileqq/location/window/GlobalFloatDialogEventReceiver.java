package com.tencent.mobileqq.location.window;

import aiut;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GlobalFloatDialogEventReceiver
  extends BroadcastReceiver
{
  private aiut b;
  
  private void asY()
  {
    if (this.b != null) {
      this.b.dismiss();
    }
  }
  
  private void duK()
  {
    if (this.b != null) {
      this.b.resume();
    }
  }
  
  private void duL()
  {
    if (this.b != null) {
      this.b.pause();
    }
  }
  
  public void a(aiut paramaiut)
  {
    this.b = paramaiut;
    paramaiut = new IntentFilter();
    paramaiut.addAction("tencent.mobileqq.floatingscreen.statuschange");
    paramaiut.addAction("mqq.intent.action.QQ_BACKGROUND");
    paramaiut.addAction("mqq.intent.action.QQ_FOREGROUND");
    paramaiut.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    paramaiut.addAction("mqq.intent.action.ACCOUNT_KICKED");
    paramaiut.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    paramaiut.addAction("mqq.intent.action.FORCE_LOGOUT");
    paramaiut.addAction("mqq.intent.action.LOGOUT");
    paramaiut.addAction("android.intent.action.SCREEN_OFF");
    BaseApplicationImpl.context.registerReceiver(this, paramaiut);
  }
  
  public void lq()
  {
    BaseApplicationImpl.context.unregisterReceiver(this);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("GlobalFloatDialogEventReceiver", 4, new Object[] { "action: ", paramIntent.getAction() });
      }
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
      {
        duL();
        return;
      }
      if ("mqq.intent.action.QQ_BACKGROUND".equals(paramIntent.getAction()))
      {
        duL();
        return;
      }
      if ("mqq.intent.action.QQ_FOREGROUND".equals(paramIntent.getAction()))
      {
        duK();
        return;
      }
    } while ((!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction())) && (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramIntent.getAction())) && (!"mqq.intent.action.ACCOUNT_EXPIRED".equals(paramIntent.getAction())) && (!"mqq.intent.action.FORCE_LOGOUT".equals(paramIntent.getAction())) && (!"mqq.intent.action.LOGOUT".equals(paramIntent.getAction())));
    asY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.GlobalFloatDialogEventReceiver
 * JD-Core Version:    0.7.0.1
 */
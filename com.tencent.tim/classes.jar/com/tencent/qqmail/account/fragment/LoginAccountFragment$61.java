package com.tencent.qqmail.account.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.qqmail.utilities.log.QMLog;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

class LoginAccountFragment$61
  extends BroadcastReceiver
{
  LoginAccountFragment$61(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QMLog.log(4, "LoginAccountFragment", "mDevLockBroadcastReceiver#onReceive");
    int i = paramIntent.getIntExtra("seq", 0);
    paramContext = (DevlockInfo)paramIntent.getParcelableExtra("DevlockInfo");
    if (paramContext == null)
    {
      QMLog.log(6, "LoginAccountFragment", "E_ACCOUNT_NEED_SMS. info is null");
      return;
    }
    paramIntent = paramIntent.getStringExtra("uin");
    QMLog.log(4, "LoginAccountFragment", "handleNeedSms seq:" + i + ", info.Mobile:" + paramContext.Mobile + ", uin:" + paramIntent);
    this.this$0.startFragment(new LoginLockFragment(paramContext.Mobile, i));
    LoginAccountFragment.access$900(this.this$0).setEnabled(true);
    LoginAccountFragment.access$1000(this.this$0).setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.61
 * JD-Core Version:    0.7.0.1
 */
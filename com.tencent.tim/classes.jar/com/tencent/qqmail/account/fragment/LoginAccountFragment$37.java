package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.androidqqmail.tim.TimMailLoginManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.BaseActivityImpl;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import mqq.app.AppRuntime;

class LoginAccountFragment$37
  implements View.OnClickListener
{
  LoginAccountFragment$37(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onClick(View paramView)
  {
    try
    {
      DataCollector.logEvent("Event_Do_Quick_Login");
      LoginAccountFragment.access$2600(this.this$0).setFadeBackground();
      QMLog.log(4, "LoginAccountFragment", "quickLogin Button click time:" + System.currentTimeMillis());
      LoginAccountFragment.access$900(this.this$0).setEnabled(false);
      LoginAccountFragment.access$1000(this.this$0).setEnabled(false);
      TimMailLoginManager.requestA2AndSkey(QMAppInterface.getRuntime().getAccount(), null, new LoginAccountFragment.37.1(this));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "LoginAccountFragment", "quick login startActivity error", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.37
 * JD-Core Version:    0.7.0.1
 */
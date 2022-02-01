package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.VerifyDevLockManager;

class LoginVerifyFragment$3
  implements View.OnClickListener
{
  LoginVerifyFragment$3(LoginVerifyFragment paramLoginVerifyFragment) {}
  
  public void onClick(View paramView)
  {
    LoginVerifyFragment.access$000(this.this$0);
    ((VerifyDevLockManager)QMAppInterface.sharedInstance().getManager(7)).refreshDevLockSms(LoginVerifyFragment.access$100(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginVerifyFragment.3
 * JD-Core Version:    0.7.0.1
 */
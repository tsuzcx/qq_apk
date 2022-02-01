package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginVerifyFragment$2
  implements View.OnClickListener
{
  LoginVerifyFragment$2(LoginVerifyFragment paramLoginVerifyFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.backToLoginAccountFragment();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginVerifyFragment.2
 * JD-Core Version:    0.7.0.1
 */
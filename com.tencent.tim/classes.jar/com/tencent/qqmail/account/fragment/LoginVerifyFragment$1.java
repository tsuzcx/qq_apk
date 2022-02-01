package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginVerifyFragment$1
  implements View.OnClickListener
{
  LoginVerifyFragment$1(LoginVerifyFragment paramLoginVerifyFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.hideKeyBoard();
    this.this$0.popBackStack();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginVerifyFragment.1
 * JD-Core Version:    0.7.0.1
 */
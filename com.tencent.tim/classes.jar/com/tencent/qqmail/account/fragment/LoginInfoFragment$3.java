package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginInfoFragment$3
  implements View.OnClickListener
{
  LoginInfoFragment$3(LoginInfoFragment paramLoginInfoFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginInfoFragment.3
 * JD-Core Version:    0.7.0.1
 */
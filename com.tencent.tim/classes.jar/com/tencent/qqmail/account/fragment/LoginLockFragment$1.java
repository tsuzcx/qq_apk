package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginLockFragment$1
  implements View.OnClickListener
{
  LoginLockFragment$1(LoginLockFragment paramLoginLockFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.backToLoginAccountFragment();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginLockFragment.1
 * JD-Core Version:    0.7.0.1
 */
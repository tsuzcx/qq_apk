package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginLockFragment$2
  implements View.OnClickListener
{
  LoginLockFragment$2(LoginLockFragment paramLoginLockFragment) {}
  
  public void onClick(View paramView)
  {
    LoginVerifyFragment localLoginVerifyFragment = new LoginVerifyFragment(LoginLockFragment.access$000(this.this$0), LoginLockFragment.access$100(this.this$0), 60);
    this.this$0.startFragment(localLoginVerifyFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginLockFragment.2
 * JD-Core Version:    0.7.0.1
 */
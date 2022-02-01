package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.helper.LoginUIHelper;

class LoginAccountFragment$36
  implements View.OnClickListener
{
  LoginAccountFragment$36(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onClick(View paramView)
  {
    LoginUIHelper.showGesPwdAccountPicker(this.this$0.getActivity(), LoginAccountFragment.access$2400(this.this$0), new LoginAccountFragment.36.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.36
 * JD-Core Version:    0.7.0.1
 */
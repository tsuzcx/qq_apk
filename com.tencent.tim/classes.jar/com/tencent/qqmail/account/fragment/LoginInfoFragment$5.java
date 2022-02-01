package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.setting.AvatarSelector;

class LoginInfoFragment$5
  implements View.OnClickListener
{
  LoginInfoFragment$5(LoginInfoFragment paramLoginInfoFragment) {}
  
  public void onClick(View paramView)
  {
    LoginInfoFragment.access$600(this.this$0).findViewById(2131372384).requestFocus();
    LoginInfoFragment.access$700(this.this$0).selectAvatar(false, LoginInfoFragment.access$200(this.this$0).getProfile(), LoginInfoFragment.access$200(this.this$0).getEmail());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginInfoFragment.5
 * JD-Core Version:    0.7.0.1
 */
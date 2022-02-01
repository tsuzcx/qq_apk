package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.view.ProtocolSettingView;

class LoginProtocolFragment$2
  implements View.OnClickListener
{
  LoginProtocolFragment$2(LoginProtocolFragment paramLoginProtocolFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    int j = 0;
    if (this.this$0.isLogining)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    label49:
    Object localObject;
    boolean bool1;
    if (paramView.getId() == 2131368955)
    {
      LoginProtocolFragment.access$202(this.this$0, 4);
      this.this$0.hideKeyBoard();
      localObject = LoginProtocolFragment.access$300(this.this$0);
      if (4 != LoginProtocolFragment.access$200(this.this$0)) {
        break label448;
      }
      bool1 = true;
      label72:
      ((Button)localObject).setSelected(bool1);
      localObject = LoginProtocolFragment.access$400(this.this$0);
      if (5 != LoginProtocolFragment.access$200(this.this$0)) {
        break label454;
      }
      bool1 = true;
      label102:
      ((Button)localObject).setSelected(bool1);
      localObject = LoginProtocolFragment.access$500(this.this$0);
      if (6 != LoginProtocolFragment.access$200(this.this$0)) {
        break label460;
      }
      bool1 = bool2;
      label134:
      ((Button)localObject).setSelected(bool1);
      this.this$0.userInputEmail = LoginProtocolFragment.access$600(this.this$0);
      this.this$0.userInputPwd = LoginProtocolFragment.access$700(this.this$0);
      localObject = LoginProtocolFragment.access$800(this.this$0);
      if (4 != LoginProtocolFragment.access$200(this.this$0)) {
        break label466;
      }
      i = 0;
      label191:
      ((ProtocolSettingView)localObject).setVisibility(i);
      localObject = LoginProtocolFragment.access$900(this.this$0);
      if (5 != LoginProtocolFragment.access$200(this.this$0)) {
        break label472;
      }
      i = 0;
      label219:
      ((ProtocolSettingView)localObject).setVisibility(i);
      localObject = LoginProtocolFragment.access$1000(this.this$0);
      if (6 != LoginProtocolFragment.access$200(this.this$0)) {
        break label478;
      }
      i = 8;
      label249:
      ((ProtocolSettingView)localObject).setVisibility(i);
      localObject = LoginProtocolFragment.access$1100(this.this$0);
      if (6 != LoginProtocolFragment.access$200(this.this$0)) {
        break label483;
      }
    }
    label448:
    label454:
    label460:
    label466:
    label472:
    label478:
    label483:
    for (int i = j;; i = 8)
    {
      ((ProtocolSettingView)localObject).setVisibility(i);
      LoginProtocolFragment.access$800(this.this$0).setUserName(this.this$0.userInputEmail);
      LoginProtocolFragment.access$800(this.this$0).setPassword(this.this$0.userInputPwd);
      LoginProtocolFragment.access$900(this.this$0).setUserName(this.this$0.userInputEmail);
      LoginProtocolFragment.access$900(this.this$0).setPassword(this.this$0.userInputPwd);
      LoginProtocolFragment.access$1100(this.this$0).setUserName(this.this$0.userInputEmail);
      LoginProtocolFragment.access$1100(this.this$0).setPassword(this.this$0.userInputPwd);
      break;
      if (paramView.getId() == 2131373502)
      {
        LoginProtocolFragment.access$202(this.this$0, 5);
        this.this$0.hideKeyBoard();
        break label49;
      }
      if (paramView.getId() != 2131366567) {
        break label49;
      }
      LoginProtocolFragment.access$202(this.this$0, 6);
      this.this$0.hideKeyBoard();
      break label49;
      bool1 = false;
      break label72;
      bool1 = false;
      break label102;
      bool1 = false;
      break label134;
      i = 8;
      break label191;
      i = 8;
      break label219;
      i = 0;
      break label249;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginProtocolFragment.2
 * JD-Core Version:    0.7.0.1
 */
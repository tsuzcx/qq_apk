package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import moai.fragment.app.FragmentActivity;

class LoginProtocolFragment$7
  implements View.OnClickListener
{
  LoginProtocolFragment$7(LoginProtocolFragment paramLoginProtocolFragment) {}
  
  public void onClick(View paramView)
  {
    if ((!this.this$0.fromPwdErrVerify) && (this.this$0.fromSettingAccount) && (!LoginProtocolFragment.access$100(this.this$0)) && (!LoginProtocolFragment.access$1200(this.this$0))) {
      this.this$0.getActivity().finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.isLogining)
      {
        this.this$0.abortLogin();
        this.this$0.refreshTopBar(false);
      }
      else if (!QMNetworkUtils.isNetworkConnected())
      {
        LoginProtocolFragment.access$1300(this.this$0);
      }
      else
      {
        this.this$0.hideKeyBoard();
        LoginProtocolFragment.access$1400(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginProtocolFragment.7
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.view.QMTopBar;
import mqq.manager.VerifyDevLockManager;

class LoginVerifyFragment$4
  implements View.OnClickListener
{
  LoginVerifyFragment$4(LoginVerifyFragment paramLoginVerifyFragment) {}
  
  public void onClick(View paramView)
  {
    String str = LoginVerifyFragment.access$200(this.this$0).getText().toString();
    if (str.equals("")) {
      this.this$0.getTips().showInfo(2131689626);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      LoginVerifyFragment.access$300(this.this$0).showLoading(true);
      LoginVerifyFragment.access$400(this.this$0).setEnabled(false);
      ((VerifyDevLockManager)QMAppInterface.sharedInstance().getManager(7)).submitSms(LoginVerifyFragment.access$100(this.this$0), str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginVerifyFragment.4
 * JD-Core Version:    0.7.0.1
 */
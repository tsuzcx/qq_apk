package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.model.AccountType;
import moai.oss.OssHelper;

class LoginGmailAuthFragment$5
  implements View.OnClickListener
{
  LoginGmailAuthFragment$5(LoginGmailAuthFragment paramLoginGmailAuthFragment) {}
  
  public void onClick(View paramView)
  {
    long l;
    if (this.this$0.currentLoginId != 0L)
    {
      l = System.currentTimeMillis() - this.this$0.currentLoginId;
      if (l > 5000L) {
        if (this.this$0.userInputEmail == null) {
          break label93;
        }
      }
    }
    label93:
    for (String str = AccountType.splitDomain(this.this$0.userInputEmail);; str = this.this$0.mAccountType.getDomain())
    {
      OssHelper.mailLogin(new Object[] { str, "ABORT", Long.valueOf(l) });
      this.this$0.popBackStack();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailAuthFragment.5
 * JD-Core Version:    0.7.0.1
 */
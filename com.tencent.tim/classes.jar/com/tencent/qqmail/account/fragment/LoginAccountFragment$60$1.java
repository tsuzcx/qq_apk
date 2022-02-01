package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.utilities.ui.QMTips;
import oicq.wlogin_sdk.tools.ErrMsg;

class LoginAccountFragment$60$1
  implements Runnable
{
  LoginAccountFragment$60$1(LoginAccountFragment.60 param60, ErrMsg paramErrMsg) {}
  
  public void run()
  {
    if (this.val$errMsg != null)
    {
      this.this$1.this$0.getTips().showError(this.val$errMsg.getMessage());
      return;
    }
    this.this$1.this$0.getTips().showError(2131689624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.60.1
 * JD-Core Version:    0.7.0.1
 */
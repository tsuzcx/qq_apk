package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.helper.LoginUIHelper;

class LoginProtocolFragment$5
  implements Runnable
{
  LoginProtocolFragment$5(LoginProtocolFragment paramLoginProtocolFragment, String paramString) {}
  
  public void run()
  {
    this.this$0.refreshTopBar(false);
    LoginUIHelper.processCustomError(this.this$0.getActivity(), this.val$errorMsg, true, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginProtocolFragment.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.helper.LoginUIHelper;

class LoginProtocolFragment$8
  implements Runnable
{
  LoginProtocolFragment$8(LoginProtocolFragment paramLoginProtocolFragment) {}
  
  public void run()
  {
    LoginUIHelper.processCustomError(this.this$0.getActivity(), "帐号已存在，无需重复登录", true, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginProtocolFragment.8
 * JD-Core Version:    0.7.0.1
 */
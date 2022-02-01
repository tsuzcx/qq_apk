package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.utilities.thread.Threads;

class LoginInfoFragment$9
  implements MailManagerDelegate.DataCallback
{
  LoginInfoFragment$9(LoginInfoFragment paramLoginInfoFragment) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    Threads.runOnMainThread(new LoginInfoFragment.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginInfoFragment.9
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.account.fragment;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class LoginAccountFragment$57
  implements View.OnKeyListener
{
  LoginAccountFragment$57(LoginAccountFragment paramLoginAccountFragment) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (paramKeyEvent.getAction() == 0))
    {
      this.this$0.hideKeyBoard();
      LoginAccountFragment.access$3900(this.this$0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.57
 * JD-Core Version:    0.7.0.1
 */
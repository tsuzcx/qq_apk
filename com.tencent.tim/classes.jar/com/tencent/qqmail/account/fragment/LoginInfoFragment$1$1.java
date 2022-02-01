package com.tencent.qqmail.account.fragment;

import android.widget.EditText;

class LoginInfoFragment$1$1
  implements Runnable
{
  LoginInfoFragment$1$1(LoginInfoFragment.1 param1, String paramString) {}
  
  public void run()
  {
    if ((this.val$nickname == null) || ("".equals(this.val$nickname)))
    {
      LoginInfoFragment.access$002(this.this$1.this$0, "");
      return;
    }
    LoginInfoFragment.access$002(this.this$1.this$0, this.val$nickname);
    LoginInfoFragment.access$100(this.this$1.this$0).setText(LoginInfoFragment.access$000(this.this$1.this$0));
    LoginInfoFragment.access$100(this.this$1.this$0).setSelection(LoginInfoFragment.access$000(this.this$1.this$0).length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginInfoFragment.1.1
 * JD-Core Version:    0.7.0.1
 */
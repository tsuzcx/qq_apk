package com.tencent.qqmail.account.fragment;

import android.widget.Button;
import com.tencent.qqmail.account.helper.VerifyCountDownTimer.CountDownAction;

class LoginVerifyFragment$5
  implements VerifyCountDownTimer.CountDownAction
{
  LoginVerifyFragment$5(LoginVerifyFragment paramLoginVerifyFragment) {}
  
  public void onFinish()
  {
    if ((this.this$0.isAttachedToActivity()) && (LoginVerifyFragment.access$400(this.this$0) != null))
    {
      LoginVerifyFragment.access$400(this.this$0).setEnabled(true);
      LoginVerifyFragment.access$400(this.this$0).setText(this.this$0.getString(2131689629));
    }
  }
  
  public void onTick(long paramLong)
  {
    if ((this.this$0.isAttachedToActivity()) && (LoginVerifyFragment.access$400(this.this$0) != null))
    {
      LoginVerifyFragment.access$400(this.this$0).setEnabled(false);
      LoginVerifyFragment.access$400(this.this$0).setText(this.this$0.getString(2131689629) + "(" + paramLong / 1000L + ")");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginVerifyFragment.5
 * JD-Core Version:    0.7.0.1
 */
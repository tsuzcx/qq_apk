package com.tencent.mobileqq.activity;

import android.widget.Button;
import aqft;
import com.tencent.mobileqq.widget.ClearableEditText;

class AuthDevVerifyCodeActivity$8
  implements Runnable
{
  AuthDevVerifyCodeActivity$8(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = aqft.bW(this.aLt, this.aLu);
    if ((str != null) && (str.length() > 0) && (AuthDevVerifyCodeActivity.a(this.this$0) != null))
    {
      AuthDevVerifyCodeActivity.a(this.this$0).setText(str);
      AuthDevVerifyCodeActivity.a(this.this$0).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.8
 * JD-Core Version:    0.7.0.1
 */
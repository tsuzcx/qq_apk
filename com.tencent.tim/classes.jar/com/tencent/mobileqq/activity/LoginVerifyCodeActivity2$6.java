package com.tencent.mobileqq.activity;

import android.widget.Button;
import android.widget.EditText;
import aqft;

class LoginVerifyCodeActivity2$6
  implements Runnable
{
  LoginVerifyCodeActivity2$6(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = aqft.bV(this.aLt, this.aLu);
    if ((str != null) && (str.length() > 0) && (LoginVerifyCodeActivity2.a(this.this$0) != null))
    {
      LoginVerifyCodeActivity2.a(this.this$0).setText(str);
      LoginVerifyCodeActivity2.a(this.this$0).setSelection(str.length());
      LoginVerifyCodeActivity2.a(this.this$0).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity2.6
 * JD-Core Version:    0.7.0.1
 */
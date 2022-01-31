package com.tencent.token.ui.base;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.token.cp;
import com.tencent.token.ui.aax;

class dp
  implements View.OnClickListener
{
  dp(WtloginCaptchaDialog paramWtloginCaptchaDialog) {}
  
  public void onClick(View paramView)
  {
    if (WtloginCaptchaDialog.a(this.a) == null) {
      return;
    }
    if (WtloginCaptchaDialog.d(this.a) != null) {
      WtloginCaptchaDialog.d(this.a).clearFocus();
    }
    paramView = WtloginCaptchaDialog.d(this.a).getText().toString();
    if ((paramView == null) || (paramView.length() == 0))
    {
      this.a.a(2131230889);
      return;
    }
    ((InputMethodManager)WtloginCaptchaDialog.a(this.a).getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindow().peekDecorView().getWindowToken(), 0);
    paramView = paramView.trim();
    ((aax)WtloginCaptchaDialog.a(this.a)).showProDialog(WtloginCaptchaDialog.a(this.a), 2131230843, null);
    this.a.a.a(WtloginCaptchaDialog.b(this.a), paramView.getBytes(), this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.dp
 * JD-Core Version:    0.7.0.1
 */
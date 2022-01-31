package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

class aez
  implements View.OnClickListener
{
  aez(VerifyMobilePhoneActivity paramVerifyMobilePhoneActivity) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindow().peekDecorView().getWindowToken(), 0);
    paramView = abi.a().a(this.a);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aez
 * JD-Core Version:    0.7.0.1
 */
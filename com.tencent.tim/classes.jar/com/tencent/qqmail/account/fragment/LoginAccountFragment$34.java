package com.tencent.qqmail.account.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.qqmail.view.EmailEditText;
import com.tencent.qqmail.view.QMTopBar;

class LoginAccountFragment$34
  implements TextWatcher
{
  LoginAccountFragment$34(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = LoginAccountFragment.access$300(this.this$0).getButtonRight();
    if ((LoginAccountFragment.access$1900(this.this$0).getText().length() > 0) && (LoginAccountFragment.access$2200(this.this$0).getText().length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      paramCharSequence.setEnabled(bool);
      this.this$0.verifySuccess = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.34
 * JD-Core Version:    0.7.0.1
 */
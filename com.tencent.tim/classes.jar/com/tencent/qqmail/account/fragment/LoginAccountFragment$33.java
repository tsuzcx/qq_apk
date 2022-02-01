package com.tencent.qqmail.account.fragment;

import android.content.res.Resources;
import android.widget.EditText;
import com.tencent.qqmail.account.helper.HelperTextChange;
import com.tencent.qqmail.view.EmailEditText;

class LoginAccountFragment$33
  implements HelperTextChange
{
  LoginAccountFragment$33(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onChange(EditText paramEditText)
  {
    if ((paramEditText != null) && (paramEditText.getText() != null) && (LoginAccountFragment.access$1900(this.this$0) != null) && (LoginAccountFragment.access$1900(this.this$0).isEnabled())) {
      LoginAccountFragment.access$1900(this.this$0).setTextColor(this.this$0.getResources().getColor(2131167519));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.33
 * JD-Core Version:    0.7.0.1
 */
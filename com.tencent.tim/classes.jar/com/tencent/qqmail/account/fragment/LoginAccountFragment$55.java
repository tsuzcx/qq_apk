package com.tencent.qqmail.account.fragment;

import android.widget.EditText;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.view.LoginVerifyCodeView;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;

class LoginAccountFragment$55
  implements Runnable
{
  LoginAccountFragment$55(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void run()
  {
    LoginAccountFragment.access$3700(this.this$0).getEditTextVerifyCodeInput().setText("");
    Toast.makeText(QMApplicationContext.sharedInstance(), 2131695571, 0).show();
    DataCollector.logException(7, 16, "Event_Error", this.this$0.getString(2131695571), true);
    KeyBoardHelper.showKeyBoard(LoginAccountFragment.access$3700(this.this$0).getEditTextVerifyCodeInput(), 0, 0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.55
 * JD-Core Version:    0.7.0.1
 */
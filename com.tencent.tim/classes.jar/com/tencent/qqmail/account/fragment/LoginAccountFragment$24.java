package com.tencent.qqmail.account.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;

class LoginAccountFragment$24
  implements DialogInterface.OnClickListener
{
  LoginAccountFragment$24(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditText localEditText = (EditText)((QMUIDialog)paramDialogInterface).findViewById(2131365884);
    LoginAccountFragment.access$1500(this.this$0, localEditText.getText().toString().trim());
    paramDialogInterface.dismiss();
    LoginAccountFragment.access$900(this.this$0).setEnabled(false);
    LoginAccountFragment.access$1000(this.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.24
 * JD-Core Version:    0.7.0.1
 */
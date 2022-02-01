package com.tencent.qqmail.account.helper;

import android.content.DialogInterface.OnDismissListener;
import android.widget.EditText;

final class Helper$7
  implements Runnable
{
  Helper$7(EditText paramEditText, String paramString, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void run()
  {
    LoginUIHelper.processCustomError(this.val$editText.getContext(), this.val$msg, true, null, this.val$dismiss);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.Helper.7
 * JD-Core Version:    0.7.0.1
 */
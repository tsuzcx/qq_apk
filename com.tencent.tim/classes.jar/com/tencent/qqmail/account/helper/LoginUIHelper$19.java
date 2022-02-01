package com.tencent.qqmail.account.helper;

import android.content.DialogInterface.OnClickListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;

final class LoginUIHelper$19
  implements View.OnKeyListener
{
  LoginUIHelper$19(DialogInterface.OnClickListener paramOnClickListener, QMUIDialog paramQMUIDialog) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (paramKeyEvent.getAction() == 0)) {
      this.val$okListener.onClick(this.val$dialog, 1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper.19
 * JD-Core Version:    0.7.0.1
 */
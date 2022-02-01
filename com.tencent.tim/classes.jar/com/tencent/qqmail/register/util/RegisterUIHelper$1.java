package com.tencent.qqmail.register.util;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

final class RegisterUIHelper$1
  implements Runnable
{
  RegisterUIHelper$1(Context paramContext, String paramString, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void run()
  {
    RegisterUIHelper.access$000();
    QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.val$context).setTitle(2131718695)).setMessage(this.val$errorMsg).addAction(2131696547, new RegisterUIHelper.1.1(this))).create();
    localQMUIDialog.setCanceledOnTouchOutside(false);
    localQMUIDialog.setOnDismissListener(new RegisterUIHelper.1.2(this));
    localQMUIDialog.show();
    RegisterUIHelper.access$100(localQMUIDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.util.RegisterUIHelper.1
 * JD-Core Version:    0.7.0.1
 */
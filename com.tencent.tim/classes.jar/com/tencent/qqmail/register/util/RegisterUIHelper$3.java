package com.tencent.qqmail.register.util;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

final class RegisterUIHelper$3
  implements Runnable
{
  RegisterUIHelper$3(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void run()
  {
    RegisterUIHelper.access$000();
    QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.val$context).setTitle(this.val$title)).setMessage(this.val$message).addAction(this.val$negativeMessage, new RegisterUIHelper.3.2(this))).addAction(this.val$positiveMessage, new RegisterUIHelper.3.1(this))).create();
    localQMUIDialog.setCanceledOnTouchOutside(false);
    localQMUIDialog.setOnDismissListener(new RegisterUIHelper.3.3(this));
    localQMUIDialog.show();
    RegisterUIHelper.access$100(localQMUIDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.util.RegisterUIHelper.3
 * JD-Core Version:    0.7.0.1
 */
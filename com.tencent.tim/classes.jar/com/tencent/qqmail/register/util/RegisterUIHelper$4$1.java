package com.tencent.qqmail.register.util;

import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class RegisterUIHelper$4$1
  implements QMUIDialogAction.ActionListener
{
  RegisterUIHelper$4$1(RegisterUIHelper.4 param4) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (this.this$0.val$positiveButtonListener != null) {
      this.this$0.val$positiveButtonListener.onClick(paramQMUIDialog, paramInt);
    }
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.util.RegisterUIHelper.4.1
 * JD-Core Version:    0.7.0.1
 */
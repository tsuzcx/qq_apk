package com.tencent.qqmail.register.util;

import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class RegisterUIHelper$3$2
  implements QMUIDialogAction.ActionListener
{
  RegisterUIHelper$3$2(RegisterUIHelper.3 param3) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (this.this$0.val$negativeButtonListener != null) {
      this.this$0.val$negativeButtonListener.onClick(paramQMUIDialog, paramInt);
    }
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.util.RegisterUIHelper.3.2
 * JD-Core Version:    0.7.0.1
 */
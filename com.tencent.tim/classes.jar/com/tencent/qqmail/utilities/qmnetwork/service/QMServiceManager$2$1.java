package com.tencent.qqmail.utilities.qmnetwork.service;

import android.app.Activity;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class QMServiceManager$2$1
  implements QMUIDialogAction.ActionListener
{
  QMServiceManager$2$1(QMServiceManager.2 param2, Activity paramActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    paramQMUIDialog = CalendarFragmentActivity.createIntentForCreditCardBill(this.this$1.val$creditCardBill);
    this.val$context.startActivity(paramQMUIDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager.2.1
 * JD-Core Version:    0.7.0.1
 */
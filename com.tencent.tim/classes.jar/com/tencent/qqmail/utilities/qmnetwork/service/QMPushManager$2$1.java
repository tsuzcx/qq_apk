package com.tencent.qqmail.utilities.qmnetwork.service;

import android.app.Activity;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class QMPushManager$2$1
  implements QMUIDialogAction.ActionListener
{
  QMPushManager$2$1(QMPushManager.2 param2, Activity paramActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    paramQMUIDialog = CalendarFragmentActivity.createIntentForCreditCardBill(this.this$0.val$creditCardBill);
    this.val$context.startActivity(paramQMUIDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager.2.1
 * JD-Core Version:    0.7.0.1
 */
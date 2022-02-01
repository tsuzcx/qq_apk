package com.tencent.qqmail.utilities.qmnetwork.service;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.calendar.data.CreditCardBill;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import moai.oss.KvHelper;

class QMServiceManager$2
  implements Runnable
{
  QMServiceManager$2(QMServiceManager paramQMServiceManager, CreditCardBill paramCreditCardBill) {}
  
  public void run()
  {
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if ((TextUtils.isEmpty(this.val$creditCardBill.num)) || (this.val$creditCardBill.num.endsWith("****")) || (this.val$creditCardBill.num.length() < 4)) {}
    for (Object localObject = String.format(localActivity.getString(2131718768), new Object[] { this.val$creditCardBill.bank });; localObject = String.format(localActivity.getString(2131718767), new Object[] { this.val$creditCardBill.bank, this.val$creditCardBill.num.substring(this.val$creditCardBill.num.length() - 4) }))
    {
      localObject = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(localActivity).setTitle(2131718776)).setMessage((CharSequence)localObject).addAction(2131691552, new QMServiceManager.2.2(this))).addAction(0, 2131694372, 0, new QMServiceManager.2.1(this, localActivity))).create();
      ((QMUIDialog)localObject).setCancelable(false);
      ((QMUIDialog)localObject).show();
      KvHelper.creditCardBillRemingdForegroundDialog(new double[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager.2
 * JD-Core Version:    0.7.0.1
 */
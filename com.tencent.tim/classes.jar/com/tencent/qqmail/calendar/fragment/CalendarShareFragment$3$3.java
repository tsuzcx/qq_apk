package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.CalendarShareError;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.ArrayList;

class CalendarShareFragment$3$3
  implements Runnable
{
  CalendarShareFragment$3$3(CalendarShareFragment.3 param3, CalendarShareError paramCalendarShareError) {}
  
  public void run()
  {
    if (this.val$error.getErrorCode() == -2)
    {
      CalendarShareFragment.access$308(this.this$1.this$0);
      QMCalendarManager.getInstance().getVerifyImage(CalendarShareFragment.access$100(this.this$1.this$0).getAccountId(), CalendarShareFragment.access$100(this.this$1.this$0).getId(), this.val$error.getShareVerify().getVerifyKey());
      return;
    }
    if (this.val$error.getErrorCode() == -141)
    {
      CalendarShareFragment.access$308(this.this$1.this$0);
      QMCalendarManager.getInstance().getVerifyImage(CalendarShareFragment.access$100(this.this$1.this$0).getAccountId(), CalendarShareFragment.access$100(this.this$1.this$0).getId(), this.val$error.getShareVerify().getVerifyKey());
      return;
    }
    this.this$1.this$0.getTips().hide();
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$1.this$0.getActivity()).setTitle(2131721116)).setMessage(this.val$error.getErrorMsg()).addAction(2131696547, new CalendarShareFragment.3.3.1(this))).create().show();
    ArrayList localArrayList = new ArrayList();
    if ((this.val$error.getErrorEmails() != null) && (this.val$error.getErrorEmails().length > 0))
    {
      String[] arrayOfString = this.val$error.getErrorEmails();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(arrayOfString[i]);
        i += 1;
      }
    }
    QMNotification.postNotification("update_error_addr", localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarShareFragment.3.3
 * JD-Core Version:    0.7.0.1
 */
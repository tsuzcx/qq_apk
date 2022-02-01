package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.model.verify.QMVerifyImageDialog.SendVeifyCallBack;
import java.util.ArrayList;

class CalendarShareFragment$2$1$1
  implements QMVerifyImageDialog.SendVeifyCallBack
{
  CalendarShareFragment$2$1$1(CalendarShareFragment.2.1 param1) {}
  
  public void sendWithVerify(QMVerify paramQMVerify)
  {
    ArrayList localArrayList = CalendarShareFragment.access$400(this.this$2.this$1.this$0);
    if (!localArrayList.isEmpty()) {
      QMCalendarManager.getInstance().shareCalendarFolder(CalendarShareFragment.access$100(this.this$2.this$1.this$0), (String[])localArrayList.toArray(new String[localArrayList.size()]), paramQMVerify);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarShareFragment.2.1.1
 * JD-Core Version:    0.7.0.1
 */
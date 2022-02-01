package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.model.verify.QMVerifyImageDialog;

class CalendarShareFragment$2$1
  implements Runnable
{
  CalendarShareFragment$2$1(CalendarShareFragment.2 param2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    QMVerify localQMVerify = new QMVerify();
    localQMVerify.setImageUrl(this.val$imgUrl);
    localQMVerify.setVerifyKey(this.val$verifyKey);
    localQMVerify.setVerifySession(this.val$verifySession);
    localQMVerify.setAuthImagesId(this.val$authImagesId);
    if (CalendarShareFragment.access$200(this.this$1.this$0) == null) {
      CalendarShareFragment.access$202(this.this$1.this$0, new QMVerifyImageDialog(this.this$1.this$0.getActivity(), CalendarShareFragment.access$100(this.this$1.this$0).getAccountId(), CalendarShareFragment.access$100(this.this$1.this$0).getId()));
    }
    CalendarShareFragment.access$200(this.this$1.this$0).fetchVerifyImage(CalendarShareFragment.access$100(this.this$1.this$0).getAccountId(), localQMVerify, CalendarShareFragment.access$300(this.this$1.this$0), new CalendarShareFragment.2.1.1(this), new CalendarShareFragment.2.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarShareFragment.2.1
 * JD-Core Version:    0.7.0.1
 */
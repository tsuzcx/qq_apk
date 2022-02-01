package com.tencent.qqmail.inquirymail.cursor;

import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.utilities.log.QMLog;

class InquiryMailListCursor$4$1
  implements Runnable
{
  InquiryMailListCursor$4$1(InquiryMailListCursor.4 param4) {}
  
  public void run()
  {
    InquiryMailListCursor.access$302(this.this$1.this$0, InquiryMailListCursor.access$400(this.this$1.this$0));
    if (InquiryMailListCursor.access$200(this.this$1.this$0) != null)
    {
      short[] arrayOfShort = this.this$1.val$step;
      int i = (short)(arrayOfShort[0] + 1);
      arrayOfShort[0] = i;
      if (i == 2)
      {
        QMLog.log(4, "InquiryMailListCursor", "onRefresh#run() nextCursor step = " + this.this$1.val$step[0]);
        InquiryMailListCursor.access$200(this.this$1.this$0).run();
        this.this$1.val$step[0] = 0;
      }
    }
    QMCursorCollector.release(this.this$1.val$originalCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor.4.1
 * JD-Core Version:    0.7.0.1
 */
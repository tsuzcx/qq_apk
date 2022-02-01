package com.tencent.qqmail.inquirymail.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.utilities.log.QMLog;

class InquiryMailListCursor$3
  implements Runnable
{
  InquiryMailListCursor$3(InquiryMailListCursor paramInquiryMailListCursor, Cursor paramCursor) {}
  
  public void run()
  {
    QMLog.log(4, "InquiryMailListCursor", "no data and onRefresh");
    if (InquiryMailListCursor.access$200(this.this$0) != null)
    {
      QMLog.log(4, "InquiryMailListCursor", "onRefresh#run noData");
      InquiryMailListCursor.access$200(this.this$0).run();
    }
    QMCursorCollector.release(this.val$originalCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor.3
 * JD-Core Version:    0.7.0.1
 */
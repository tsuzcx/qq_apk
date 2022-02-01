package com.tencent.qqmail.inquirymail.cursor;

import android.database.Cursor;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.Callable;

class InquiryMailListCursor$1
  implements Callable<Cursor>
{
  InquiryMailListCursor$1(InquiryMailListCursor paramInquiryMailListCursor) {}
  
  public Cursor call()
  {
    Cursor localCursor = InquiryMailListCursor.access$000(this.this$0);
    if (localCursor != null) {
      localCursor.getCount();
    }
    QMLog.log(4, "InquiryMailListCursor", "queryRawCursor");
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor.1
 * JD-Core Version:    0.7.0.1
 */
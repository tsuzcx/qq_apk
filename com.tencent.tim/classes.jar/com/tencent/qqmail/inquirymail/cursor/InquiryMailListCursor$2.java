package com.tencent.qqmail.inquirymail.cursor;

import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.Callable;

class InquiryMailListCursor$2
  implements Callable<Boolean>
{
  InquiryMailListCursor$2(InquiryMailListCursor paramInquiryMailListCursor) {}
  
  public Boolean call()
  {
    QMLog.log(4, "InquiryMailListCursor", "queryCanLoadMore");
    return Boolean.valueOf(InquiryMailListCursor.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor.2
 * JD-Core Version:    0.7.0.1
 */
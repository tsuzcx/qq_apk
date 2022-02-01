package com.tencent.qqmail.inquirymail.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class InquiryMailListCursor$7
  implements Runnable
{
  InquiryMailListCursor$7(InquiryMailListCursor paramInquiryMailListCursor, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void run()
  {
    this.val$refreshCallback.onRefreshComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor.7
 * JD-Core Version:    0.7.0.1
 */
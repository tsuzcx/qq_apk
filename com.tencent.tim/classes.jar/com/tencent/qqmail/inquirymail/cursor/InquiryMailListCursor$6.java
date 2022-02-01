package com.tencent.qqmail.inquirymail.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class InquiryMailListCursor$6
  implements Runnable
{
  InquiryMailListCursor$6(InquiryMailListCursor paramInquiryMailListCursor, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void run()
  {
    this.val$refreshCallback.onBeforeRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor.6
 * JD-Core Version:    0.7.0.1
 */
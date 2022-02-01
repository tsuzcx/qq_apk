package com.tencent.qqmail.inquirymail.cursor;

import java.util.concurrent.Callable;

class InquiryMailListCursor$5
  implements Callable<Boolean>
{
  InquiryMailListCursor$5(InquiryMailListCursor paramInquiryMailListCursor, short[] paramArrayOfShort) {}
  
  public Boolean call()
  {
    boolean bool = InquiryMailListCursor.access$100(this.this$0);
    InquiryMailListCursor.access$500(this.this$0).runOnMainThreadWithContext(new InquiryMailListCursor.5.1(this));
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.inquirymail.cursor;

import android.database.Cursor;
import java.util.concurrent.Callable;

class InquiryMailListCursor$4
  implements Callable<Cursor>
{
  InquiryMailListCursor$4(InquiryMailListCursor paramInquiryMailListCursor, short[] paramArrayOfShort, Cursor paramCursor) {}
  
  public Cursor call()
  {
    Cursor localCursor = InquiryMailListCursor.access$000(this.this$0);
    if (localCursor != null) {
      localCursor.getCount();
    }
    InquiryMailListCursor.access$500(this.this$0).runOnMainThreadWithContext(new InquiryMailListCursor.4.1(this));
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor.4
 * JD-Core Version:    0.7.0.1
 */
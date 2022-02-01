package com.tencent.qqmail.inquirymail.cursor;

import com.tencent.qqmail.utilities.log.QMLog;

class InquiryMailListCursor$5$1
  implements Runnable
{
  InquiryMailListCursor$5$1(InquiryMailListCursor.5 param5) {}
  
  public void run()
  {
    InquiryMailListCursor.access$602(this.this$1.this$0, InquiryMailListCursor.access$700(this.this$1.this$0));
    if (InquiryMailListCursor.access$200(this.this$1.this$0) != null)
    {
      short[] arrayOfShort = this.this$1.val$step;
      int i = (short)(arrayOfShort[0] + 1);
      arrayOfShort[0] = i;
      if (i == 2)
      {
        QMLog.log(4, "InquiryMailListCursor", "onRefresh#run() nextCanLoadMore step = " + this.this$1.val$step[0]);
        InquiryMailListCursor.access$200(this.this$1.this$0).run();
        this.this$1.val$step[0] = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor.5.1
 * JD-Core Version:    0.7.0.1
 */
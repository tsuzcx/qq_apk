package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.cursor.QMAdMailCursor;
import com.tencent.qqmail.model.qmdomain.Mail;

class AggregateMailListFragment$13
  implements Runnable
{
  AggregateMailListFragment$13(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void run()
  {
    if ((AggregateMailListFragment.access$500(this.this$0) != null) && (Mail.isAdConv(AggregateMailListFragment.access$2200(this.this$0)))) {
      ((QMAdMailCursor)AggregateMailListFragment.access$500(this.this$0)).markAdConvAsRead();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.13
 * JD-Core Version:    0.7.0.1
 */
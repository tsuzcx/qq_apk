package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.cursor.IMailListCursor;

class AggregateMailListFragment$5$1
  implements Runnable
{
  AggregateMailListFragment$5$1(AggregateMailListFragment.5 param5) {}
  
  public void run()
  {
    if (AggregateMailListFragment.access$500(this.this$1.this$0).getCount() <= 1) {
      AggregateMailListFragment.access$600(this.this$1.this$0);
    }
    AggregateMailListFragment.access$000(this.this$1.this$0);
    AggregateMailListFragment.access$400(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;

class AggregateMailListFragment$4$1
  extends QMRefreshCallback
{
  AggregateMailListFragment$4$1(AggregateMailListFragment.4 param4) {}
  
  public void onRefreshComplete()
  {
    AggregateMailListFragment.access$802(this.this$1.this$0, false);
    if ((AggregateMailListFragment.access$500(this.this$1.this$0) == null) || (AggregateMailListFragment.access$500(this.this$1.this$0).getCount() < 1))
    {
      AggregateMailListFragment.access$600(this.this$1.this$0);
      return;
    }
    AggregateMailListFragment.access$900(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.4.1
 * JD-Core Version:    0.7.0.1
 */
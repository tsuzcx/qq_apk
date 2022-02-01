package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.utilities.ui.QMTips;

class AggregateMailListFragment$2$1
  extends QMRefreshCallback
{
  AggregateMailListFragment$2$1(AggregateMailListFragment.2 param2) {}
  
  public void onRefreshComplete()
  {
    this.this$1.this$0.getTips().showSuccess(2131718730);
    AggregateMailListFragment.access$000(this.this$1.this$0);
    AggregateMailListFragment.access$400(this.this$1.this$0);
    if (AggregateMailListFragment.access$500(this.this$1.this$0).getCount() < 1) {
      AggregateMailListFragment.access$600(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.2.1
 * JD-Core Version:    0.7.0.1
 */
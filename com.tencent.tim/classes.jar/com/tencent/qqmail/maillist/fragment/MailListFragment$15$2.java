package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.QMTips;

class MailListFragment$15$2
  implements Runnable
{
  MailListFragment$15$2(MailListFragment.15 param15, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    if ((MailListFragment.access$200(this.this$1.this$0) == null) || (MailListFragment.access$200(this.this$1.this$0).getCount() <= 0)) {
      MailListFragment.access$5100(this.this$1.this$0, this.val$error);
    }
    for (;;)
    {
      MailListFragment.access$6400(this.this$1.this$0, false);
      MailListFragment.access$000(this.this$1.this$0).onRefreshComplete();
      return;
      this.this$1.this$0.getTips().showError(2131695613);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.15.2
 * JD-Core Version:    0.7.0.1
 */
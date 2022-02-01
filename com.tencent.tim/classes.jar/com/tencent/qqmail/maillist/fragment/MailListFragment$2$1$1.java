package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

class MailListFragment$2$1$1
  extends QMRefreshCallback
{
  MailListFragment$2$1$1(MailListFragment.2.1 param1) {}
  
  public void onBeforeRefresh()
  {
    if (!this.this$2.val$eagain)
    {
      MailListFragment.access$000(this.this$2.this$1.this$0).onRefreshComplete();
      MailListFragment.access$4000(this.this$2.this$1.this$0);
    }
  }
  
  public void onRefreshComplete()
  {
    MailListFragment.access$4100(this.this$2.this$1.this$0);
    if ((MailListFragment.access$4200(this.this$2.this$1.this$0)) && (!this.this$2.val$eagain)) {
      MailListFragment.access$4300(this.this$2.this$1.this$0);
    }
    MailListFragment.access$4400(this.this$2.this$1.this$0, true);
    MailListFragment.access$200(this.this$2.this$1.this$0).popIn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.2.1.1
 * JD-Core Version:    0.7.0.1
 */
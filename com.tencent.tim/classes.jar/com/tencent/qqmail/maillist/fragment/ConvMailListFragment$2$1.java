package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.utilities.ui.QMTips;

class ConvMailListFragment$2$1
  extends QMRefreshCallback
{
  ConvMailListFragment$2$1(ConvMailListFragment.2 param2) {}
  
  public void onRefreshComplete()
  {
    this.this$1.this$0.getTips().showSuccess(2131718730);
    ConvMailListFragment.access$000(this.this$1.this$0);
    ConvMailListFragment.access$400(this.this$1.this$0);
    if (ConvMailListFragment.access$500(this.this$1.this$0).getCount() < 1) {
      ConvMailListFragment.access$600(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.2.1
 * JD-Core Version:    0.7.0.1
 */
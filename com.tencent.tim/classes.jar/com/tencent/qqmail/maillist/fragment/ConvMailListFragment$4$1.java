package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;

class ConvMailListFragment$4$1
  extends QMRefreshCallback
{
  ConvMailListFragment$4$1(ConvMailListFragment.4 param4) {}
  
  public void onRefreshComplete()
  {
    ConvMailListFragment.access$902(this.this$1.this$0, false);
    int i = ConvMailListFragment.access$500(this.this$1.this$0).getCount();
    if ((ConvMailListFragment.access$500(this.this$1.this$0) == null) || (i < 1))
    {
      ConvMailListFragment.access$600(this.this$1.this$0);
      return;
    }
    ConvMailListFragment.access$1000(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.4.1
 * JD-Core Version:    0.7.0.1
 */
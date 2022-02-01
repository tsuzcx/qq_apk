package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.maillist.adapter.QMMailListAdapter;

class MailListFragment$2$4
  implements Runnable
{
  MailListFragment$2$4(MailListFragment.2 param2) {}
  
  public void run()
  {
    MailListFragment.access$100(this.this$1.this$0).setMoreLoadingNormal(false);
    MailListFragment.access$100(this.this$1.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.2.4
 * JD-Core Version:    0.7.0.1
 */
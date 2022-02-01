package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.maillist.adapter.QMMailListAdapter;

class ConvMailListFragment$1$2
  implements Runnable
{
  ConvMailListFragment$1$2(ConvMailListFragment.1 param1, long paramLong, String paramString) {}
  
  public void run()
  {
    if (ConvMailListFragment.access$200(this.this$1.this$0) != null) {
      ConvMailListFragment.access$200(this.this$1.this$0).setMailAbsCache(Long.valueOf(this.val$popMailId), this.val$popMailAbs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.1.2
 * JD-Core Version:    0.7.0.1
 */
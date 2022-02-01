package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.maillist.adapter.AggregateMailListAdapter;

class AggregateMailListFragment$12$1
  implements Runnable
{
  AggregateMailListFragment$12$1(AggregateMailListFragment.12 param12) {}
  
  public void run()
  {
    if (AggregateMailListFragment.access$200(this.this$1.this$0) != null) {
      AggregateMailListFragment.access$200(this.this$1.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.12.1
 * JD-Core Version:    0.7.0.1
 */
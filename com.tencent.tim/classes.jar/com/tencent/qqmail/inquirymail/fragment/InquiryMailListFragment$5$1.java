package com.tencent.qqmail.inquirymail.fragment;

import com.tencent.qqmail.inquirymail.adapter.InquiryMailListAdapter;

class InquiryMailListFragment$5$1
  implements Runnable
{
  InquiryMailListFragment$5$1(InquiryMailListFragment.5 param5) {}
  
  public void run()
  {
    if (InquiryMailListFragment.access$400(this.this$1.this$0) != null) {
      InquiryMailListFragment.access$400(this.this$1.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.fragment.InquiryMailListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */
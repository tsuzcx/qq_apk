package com.tencent.qqmail.inquirymail.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class InquiryMailListFragment$7
  implements View.OnClickListener
{
  InquiryMailListFragment$7(InquiryMailListFragment paramInquiryMailListFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.popBackStack();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.fragment.InquiryMailListFragment.7
 * JD-Core Version:    0.7.0.1
 */
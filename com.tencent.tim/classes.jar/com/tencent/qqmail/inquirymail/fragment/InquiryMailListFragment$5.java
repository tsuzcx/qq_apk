package com.tencent.qqmail.inquirymail.fragment;

import com.tencent.qqmail.inquirymail.InquiryMailManager;
import com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor;
import java.util.concurrent.Callable;

class InquiryMailListFragment$5
  implements Callable<InquiryMailListCursor>
{
  InquiryMailListFragment$5(InquiryMailListFragment paramInquiryMailListFragment) {}
  
  public InquiryMailListCursor call()
  {
    InquiryMailListCursor localInquiryMailListCursor = InquiryMailManager.sharedInstance().getInquiryMailListCursor(InquiryMailListFragment.access$000(this.this$0));
    localInquiryMailListCursor.setOnRefresh(new InquiryMailListFragment.5.1(this));
    localInquiryMailListCursor.setThreadWrapper(new InquiryMailListFragment.5.2(this));
    localInquiryMailListCursor.refresh(true, null);
    return localInquiryMailListCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.fragment.InquiryMailListFragment.5
 * JD-Core Version:    0.7.0.1
 */
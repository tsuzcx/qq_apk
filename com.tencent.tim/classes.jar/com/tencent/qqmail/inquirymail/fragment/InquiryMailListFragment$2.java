package com.tencent.qqmail.inquirymail.fragment;

import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.inquirymail.watcher.RetrieveMailWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class InquiryMailListFragment$2
  implements RetrieveMailWatcher
{
  InquiryMailListFragment$2(InquiryMailListFragment paramInquiryMailListFragment) {}
  
  public void onBefore(int paramInt, InquiryMail paramInquiryMail) {}
  
  public void onError(int paramInt, InquiryMail paramInquiryMail, QMNetworkError paramQMNetworkError)
  {
    if (paramInt == InquiryMailListFragment.access$000(this.this$0)) {
      InquiryMailListFragment.access$300(this.this$0, 2131695022);
    }
  }
  
  public void onSuccess(int paramInt, InquiryMail paramInquiryMail)
  {
    if (paramInt == InquiryMailListFragment.access$000(this.this$0))
    {
      InquiryMailListFragment.access$200(this.this$0, 2131695024);
      InquiryMailListFragment.access$100(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.fragment.InquiryMailListFragment.2
 * JD-Core Version:    0.7.0.1
 */
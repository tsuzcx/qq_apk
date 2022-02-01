package com.tencent.qqmail.inquirymail.fragment;

import com.tencent.qqmail.inquirymail.watcher.AddToWhiteListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class InquiryMailListFragment$3
  implements AddToWhiteListWatcher
{
  InquiryMailListFragment$3(InquiryMailListFragment paramInquiryMailListFragment) {}
  
  public void onBefore(int paramInt, String paramString) {}
  
  public void onError(int paramInt, String paramString, QMNetworkError paramQMNetworkError)
  {
    if (paramInt == InquiryMailListFragment.access$000(this.this$0)) {
      InquiryMailListFragment.access$300(this.this$0, 2131694979);
    }
  }
  
  public void onSuccess(int paramInt, String paramString)
  {
    if (paramInt == InquiryMailListFragment.access$000(this.this$0))
    {
      InquiryMailListFragment.access$200(this.this$0, 2131694981);
      InquiryMailListFragment.access$100(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.fragment.InquiryMailListFragment.3
 * JD-Core Version:    0.7.0.1
 */
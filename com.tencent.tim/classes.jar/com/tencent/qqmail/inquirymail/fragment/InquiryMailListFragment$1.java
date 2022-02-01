package com.tencent.qqmail.inquirymail.fragment;

import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.inquirymail.watcher.LoadInquiryMailWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class InquiryMailListFragment$1
  implements LoadInquiryMailWatcher
{
  InquiryMailListFragment$1(InquiryMailListFragment paramInquiryMailListFragment) {}
  
  public void onBefore(int paramInt) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    if (paramInt == InquiryMailListFragment.access$000(this.this$0)) {
      InquiryMailListFragment.access$100(this.this$0, true);
    }
  }
  
  public void onSuccess(int paramInt, ArrayList<InquiryMail> paramArrayList)
  {
    if (paramInt == InquiryMailListFragment.access$000(this.this$0)) {
      InquiryMailListFragment.access$100(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.fragment.InquiryMailListFragment.1
 * JD-Core Version:    0.7.0.1
 */
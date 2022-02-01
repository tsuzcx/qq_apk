package com.tencent.qqmail.inquirymail.watcher;

import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface RetrieveMailWatcher
  extends Watchers.Watcher
{
  public abstract void onBefore(int paramInt, InquiryMail paramInquiryMail);
  
  public abstract void onError(int paramInt, InquiryMail paramInquiryMail, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(int paramInt, InquiryMail paramInquiryMail);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.watcher.RetrieveMailWatcher
 * JD-Core Version:    0.7.0.1
 */
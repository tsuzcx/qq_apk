package com.tencent.qqmail.inquirymail.watcher;

import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;
import moai.core.watcher.Watchers.Watcher;

public abstract interface LoadInquiryMailWatcher
  extends Watchers.Watcher
{
  public abstract void onBefore(int paramInt);
  
  public abstract void onError(int paramInt, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(int paramInt, ArrayList<InquiryMail> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.watcher.LoadInquiryMailWatcher
 * JD-Core Version:    0.7.0.1
 */
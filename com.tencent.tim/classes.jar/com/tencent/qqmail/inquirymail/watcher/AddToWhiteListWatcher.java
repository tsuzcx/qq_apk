package com.tencent.qqmail.inquirymail.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface AddToWhiteListWatcher
  extends Watchers.Watcher
{
  public abstract void onBefore(int paramInt, String paramString);
  
  public abstract void onError(int paramInt, String paramString, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.watcher.AddToWhiteListWatcher
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.register;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface CheckPhoneWatcher
  extends Watchers.Watcher
{
  public abstract void onError(String paramString1, String paramString2, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.CheckPhoneWatcher
 * JD-Core Version:    0.7.0.1
 */
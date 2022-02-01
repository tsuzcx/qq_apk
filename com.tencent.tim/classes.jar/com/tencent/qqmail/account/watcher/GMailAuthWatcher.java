package com.tencent.qqmail.account.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface GMailAuthWatcher
  extends Watchers.Watcher
{
  public abstract void onGetTokenError(String paramString, QMNetworkError paramQMNetworkError);
  
  public abstract void onGetTokenSuccess(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5);
  
  public abstract void onGetUserInfoError(String paramString, QMNetworkError paramQMNetworkError);
  
  public abstract void onGetUserInfoSuccess(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.watcher.GMailAuthWatcher
 * JD-Core Version:    0.7.0.1
 */
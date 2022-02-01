package com.tencent.qqmail.model.verify;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface QMGetVerifyImageWatcher
  extends Watchers.Watcher
{
  public abstract void onError(int paramInt, String paramString, QMNetworkError paramQMNetworkError);
  
  public abstract void onProcess(int paramInt, String paramString);
  
  public abstract void onSuccess(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.verify.QMGetVerifyImageWatcher
 * JD-Core Version:    0.7.0.1
 */
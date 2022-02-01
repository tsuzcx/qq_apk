package com.tencent.qqmail.namelist.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface DeleteNameListWatcher
  extends Watchers.Watcher
{
  public abstract void onBefore(int paramInt1, int paramInt2, String[] paramArrayOfString);
  
  public abstract void onError(int paramInt1, int paramInt2, String[] paramArrayOfString, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(int paramInt1, int paramInt2, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.watcher.DeleteNameListWatcher
 * JD-Core Version:    0.7.0.1
 */
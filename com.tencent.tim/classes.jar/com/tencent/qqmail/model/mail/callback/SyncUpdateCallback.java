package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

public abstract interface SyncUpdateCallback
{
  public abstract void onError(QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.SyncUpdateCallback
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

public abstract interface IListStatusCallback
{
  public abstract void error(QMNetworkError paramQMNetworkError);
  
  public abstract void process();
  
  public abstract void success(boolean paramBoolean, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.IListStatusCallback
 * JD-Core Version:    0.7.0.1
 */
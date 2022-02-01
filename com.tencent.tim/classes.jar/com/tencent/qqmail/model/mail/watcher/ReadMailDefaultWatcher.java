package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

public abstract interface ReadMailDefaultWatcher
  extends LoadMailWatcher
{
  public abstract void onConvChildSuccess(long paramLong1, long paramLong2);
  
  public abstract void onError(long paramLong, QMNetworkError paramQMNetworkError);
  
  public abstract void onLocalSuccess(Mail paramMail);
  
  public abstract void onProcess(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void onSuccess(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.ReadMailDefaultWatcher
 * JD-Core Version:    0.7.0.1
 */
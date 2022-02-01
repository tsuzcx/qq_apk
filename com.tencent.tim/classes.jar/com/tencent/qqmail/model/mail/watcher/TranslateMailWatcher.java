package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.model.qmdomain.MailTranslate;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface TranslateMailWatcher
  extends Watchers.Watcher
{
  public abstract void onError(long paramLong, QMNetworkError paramQMNetworkError);
  
  public abstract void onLocalSuccess(MailTranslate paramMailTranslate);
  
  public abstract void onSuccess(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.TranslateMailWatcher
 * JD-Core Version:    0.7.0.1
 */
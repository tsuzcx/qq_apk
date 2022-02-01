package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import moai.core.watcher.Watchers.Watcher;

public abstract interface UpdateFtnExpireTimeWatcher
  extends Watchers.Watcher
{
  public abstract void onSuccess(int paramInt1, MailBigAttach paramMailBigAttach, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.UpdateFtnExpireTimeWatcher
 * JD-Core Version:    0.7.0.1
 */
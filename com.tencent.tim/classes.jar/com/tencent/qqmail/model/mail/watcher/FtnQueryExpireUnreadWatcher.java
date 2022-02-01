package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.ftn.model.FtnExpireInfo;

public abstract interface FtnQueryExpireUnreadWatcher
{
  public abstract void onSuccess(long paramLong, FtnExpireInfo paramFtnExpireInfo, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.FtnQueryExpireUnreadWatcher
 * JD-Core Version:    0.7.0.1
 */
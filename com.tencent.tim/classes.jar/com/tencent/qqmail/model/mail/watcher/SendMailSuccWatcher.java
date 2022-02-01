package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import moai.core.watcher.Watchers.Watcher;

public abstract interface SendMailSuccWatcher
  extends Watchers.Watcher
{
  public abstract void onSuccess(ComposeMailUI paramComposeMailUI);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.SendMailSuccWatcher
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface PhoneWatcher
  extends Watchers.Watcher
{
  public abstract void complete();
  
  public abstract void connected();
  
  public abstract void disconnected();
  
  public abstract void error();
  
  public abstract void starting();
  
  public abstract void startingError();
  
  public abstract void waiting();
  
  public abstract void waitingError();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.PhoneWatcher
 * JD-Core Version:    0.7.0.1
 */
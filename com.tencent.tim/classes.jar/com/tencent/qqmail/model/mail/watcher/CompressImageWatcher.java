package com.tencent.qqmail.model.mail.watcher;

public abstract interface CompressImageWatcher
{
  public abstract void onError(String paramString1, String paramString2);
  
  public abstract void onSuccess(String paramString1, String paramString2);
  
  public abstract void onWait(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.CompressImageWatcher
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.model.mail.loader;

public abstract interface MailContentLoaderCallback
{
  public abstract void onError(String paramString1, String paramString2);
  
  public abstract void onSuccess(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.loader.MailContentLoaderCallback
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.model.qmdomain.Mail;

public abstract interface LoadEmlCallback
{
  public abstract void loadFail();
  
  public abstract void loadSuccess(Mail paramMail);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.LoadEmlCallback
 * JD-Core Version:    0.7.0.1
 */
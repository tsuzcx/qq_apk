package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

public abstract interface MailListCallback
{
  public abstract void onRetrieveError(QMProtocolError paramQMProtocolError);
  
  public abstract void onRetrieveMail(Mail paramMail);
  
  public abstract void onRetrieveStatus(Mail[] paramArrayOfMail);
  
  public abstract void onRetrieveSuccess(int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3);
  
  public abstract void process();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.MailListCallback
 * JD-Core Version:    0.7.0.1
 */
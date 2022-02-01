package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

public abstract interface LoadMailCallback
{
  public abstract void loadMailError(QMProtocolError paramQMProtocolError);
  
  public abstract void loadMailProcess();
  
  public abstract void loadMailSuccess(long paramLong, Mail paramMail);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.LoadMailCallback
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

public abstract interface LoadMailAbstractCallback
{
  public abstract void loadAbstractError(long paramLong, QMProtocolError paramQMProtocolError);
  
  public abstract void loadAbstractProcess();
  
  public abstract void loadAbstractSuccess(long paramLong1, long paramLong2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.LoadMailAbstractCallback
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

public abstract interface LoadMailAttachCallBack
{
  public abstract void onError(QMProtocolError paramQMProtocolError);
  
  public abstract boolean onProgress(long paramLong1, long paramLong2);
  
  public abstract void onSuccess(String paramString, Attach paramAttach);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.LoadMailAttachCallBack
 * JD-Core Version:    0.7.0.1
 */
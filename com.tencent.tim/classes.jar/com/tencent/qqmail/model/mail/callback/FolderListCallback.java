package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

public abstract interface FolderListCallback
{
  public abstract void onError(QMProtocolError paramQMProtocolError);
  
  public abstract void onSuccess(QMFolder[] paramArrayOfQMFolder1, QMFolder[] paramArrayOfQMFolder2, QMFolder[] paramArrayOfQMFolder3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.FolderListCallback
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.model.qmdomain.QMFolder;

public abstract interface CheckMailCallback
{
  public abstract void notSync();
  
  public abstract void onSync(QMFolder[] paramArrayOfQMFolder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.CheckMailCallback
 * JD-Core Version:    0.7.0.1
 */
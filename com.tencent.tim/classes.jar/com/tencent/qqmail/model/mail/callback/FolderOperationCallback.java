package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

public abstract class FolderOperationCallback
{
  public void onComplete(QMFolder paramQMFolder, QMNetworkError paramQMNetworkError) {}
  
  public void onError(QMFolder paramQMFolder, QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(QMFolder paramQMFolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.FolderOperationCallback
 * JD-Core Version:    0.7.0.1
 */
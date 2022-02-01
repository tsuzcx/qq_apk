package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

public class FolderListCompleteCallback
  implements FolderListCallback
{
  private FolderListCallback callback = null;
  private Runnable onComplete = null;
  
  public FolderListCompleteCallback(FolderListCallback paramFolderListCallback, Runnable paramRunnable)
  {
    this.callback = paramFolderListCallback;
    this.onComplete = paramRunnable;
  }
  
  public void onError(QMProtocolError paramQMProtocolError)
  {
    if (this.callback != null) {
      this.callback.onError(paramQMProtocolError);
    }
    if (this.onComplete != null) {
      this.onComplete.run();
    }
  }
  
  public void onSuccess(QMFolder[] paramArrayOfQMFolder1, QMFolder[] paramArrayOfQMFolder2, QMFolder[] paramArrayOfQMFolder3)
  {
    if (this.callback != null) {
      this.callback.onSuccess(paramArrayOfQMFolder1, paramArrayOfQMFolder2, paramArrayOfQMFolder3);
    }
    if (this.onComplete != null) {
      this.onComplete.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.FolderListCompleteCallback
 * JD-Core Version:    0.7.0.1
 */
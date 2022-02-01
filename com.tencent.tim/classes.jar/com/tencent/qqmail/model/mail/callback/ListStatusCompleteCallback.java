package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

public class ListStatusCompleteCallback
  implements IListStatusCallback
{
  private IListStatusCallback callback = null;
  private Runnable onComplete = null;
  
  public ListStatusCompleteCallback(IListStatusCallback paramIListStatusCallback, Runnable paramRunnable)
  {
    this.callback = paramIListStatusCallback;
    this.onComplete = paramRunnable;
  }
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    if (this.callback != null) {
      this.callback.error(paramQMNetworkError);
    }
    if (this.onComplete != null) {
      this.onComplete.run();
    }
  }
  
  public void process()
  {
    if (this.callback != null) {
      this.callback.process();
    }
  }
  
  public void success(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.callback != null) {
      this.callback.success(paramBoolean, paramInt1, paramInt2);
    }
    if (this.onComplete != null) {
      this.onComplete.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.ListStatusCompleteCallback
 * JD-Core Version:    0.7.0.1
 */
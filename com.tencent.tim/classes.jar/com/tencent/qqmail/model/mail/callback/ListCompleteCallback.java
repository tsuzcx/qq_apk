package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

public class ListCompleteCallback
  implements IListCallback
{
  private IListCallback callback = null;
  private Runnable onComplete = null;
  
  public ListCompleteCallback(IListCallback paramIListCallback, Runnable paramRunnable)
  {
    this.callback = paramIListCallback;
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
  
  public void success(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (this.callback != null) {
      this.callback.success(paramArrayOfLong, paramBoolean);
    }
    if (this.onComplete != null) {
      this.onComplete.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.ListCompleteCallback
 * JD-Core Version:    0.7.0.1
 */
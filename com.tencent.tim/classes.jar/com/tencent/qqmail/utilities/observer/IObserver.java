package com.tencent.qqmail.utilities.observer;

import java.util.Observable;
import java.util.Observer;

public class IObserver
  implements Observer
{
  private ICallBack callback = null;
  
  public IObserver(ICallBack paramICallBack)
  {
    this.callback = paramICallBack;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.callback != null) {
      this.callback.callback(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.observer.IObserver
 * JD-Core Version:    0.7.0.1
 */
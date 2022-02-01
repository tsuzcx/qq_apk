package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.HashMap;
import java.util.Observable;

class FtnListActivity$4
  extends IObserver
{
  FtnListActivity$4(FtnListActivity paramFtnListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (HashMap)paramObject;
    if (paramObservable != null) {}
    for (int i = ((Integer)paramObservable.get("paramerrorcgiexceptioncode")).intValue();; i = 0)
    {
      Threads.runOnMainThread(new FtnListActivity.4.1(this, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.4
 * JD-Core Version:    0.7.0.1
 */
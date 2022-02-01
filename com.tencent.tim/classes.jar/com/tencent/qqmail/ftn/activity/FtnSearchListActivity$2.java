package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Observable;

class FtnSearchListActivity$2
  extends IObserver
{
  FtnSearchListActivity$2(FtnSearchListActivity paramFtnSearchListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Threads.runOnMainThread(new FtnSearchListActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnSearchListActivity.2
 * JD-Core Version:    0.7.0.1
 */
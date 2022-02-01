package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Observable;

class FtnListActivity$8
  extends IObserver
{
  FtnListActivity$8(FtnListActivity paramFtnListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    FtnListActivity.access$1502(this.this$0, false);
    Threads.runOnMainThread(new FtnListActivity.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.8
 * JD-Core Version:    0.7.0.1
 */
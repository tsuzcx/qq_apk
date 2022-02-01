package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Observable;

class FtnListActivity$3
  extends IObserver
{
  FtnListActivity$3(FtnListActivity paramFtnListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Threads.runOnMainThread(new FtnListActivity.3.1(this, FtnListActivity.access$500(this.this$0).getFtnList()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.3
 * JD-Core Version:    0.7.0.1
 */
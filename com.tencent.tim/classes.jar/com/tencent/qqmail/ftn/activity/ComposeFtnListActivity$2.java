package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Observable;

class ComposeFtnListActivity$2
  extends IObserver
{
  ComposeFtnListActivity$2(ComposeFtnListActivity paramComposeFtnListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    ComposeFtnListActivity.access$002(this.this$0, FtnManager.sharedInstance().getFtnList());
    Threads.runOnMainThread(new ComposeFtnListActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.ComposeFtnListActivity.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Observable;

class FtnSearchListActivity$3
  extends IObserver
{
  FtnSearchListActivity$3(FtnSearchListActivity paramFtnSearchListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (FtnSearchListActivity.access$000(this.this$0).equals("")) {
      FtnSearchListActivity.access$102(this.this$0, FtnManager.sharedInstance().searchFtnList());
    }
    for (;;)
    {
      Threads.runOnMainThread(new FtnSearchListActivity.3.1(this));
      return;
      FtnSearchListActivity.access$102(this.this$0, FtnManager.sharedInstance().searchFtnList(FtnSearchListActivity.access$000(this.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnSearchListActivity.3
 * JD-Core Version:    0.7.0.1
 */
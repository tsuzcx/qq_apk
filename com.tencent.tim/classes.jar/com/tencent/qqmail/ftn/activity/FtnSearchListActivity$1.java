package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Observable;

class FtnSearchListActivity$1
  extends IObserver
{
  FtnSearchListActivity$1(FtnSearchListActivity paramFtnSearchListActivity, ICallBack paramICallBack)
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
      FtnSearchListActivity.access$200(this.this$0);
      Threads.runOnMainThread(new FtnSearchListActivity.1.1(this));
      return;
      FtnSearchListActivity.access$102(this.this$0, FtnManager.sharedInstance().searchFtnList(FtnSearchListActivity.access$000(this.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnSearchListActivity.1
 * JD-Core Version:    0.7.0.1
 */
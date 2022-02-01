package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.Observable;

class FtnListActivity$9
  extends IObserver
{
  FtnListActivity$9(FtnListActivity paramFtnListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable arg1, Object paramObject)
  {
    synchronized (FtnListActivity.access$1800(this.this$0))
    {
      if ((FtnListActivity.access$1500(this.this$0)) || (FtnListActivity.access$1900(this.this$0) > 1)) {
        FtnListActivity.access$1906(this.this$0);
      }
      while (!FtnListActivity.access$2000(this.this$0)) {
        return;
      }
      FtnListActivity.access$500(this.this$0).getList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.9
 * JD-Core Version:    0.7.0.1
 */
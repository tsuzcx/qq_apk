package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;

class FtnListActivity$14
  extends IObserver
{
  FtnListActivity$14(FtnListActivity paramFtnListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable arg1, Object paramObject)
  {
    ??? = (HashMap)paramObject;
    int i = ((Integer)???.get("paramerrorcgiexceptioncode")).intValue();
    ??? = (FtnUploadInfo)???.get("paramerrordata");
    FtnListActivity.access$3700(this.this$0, new FtnListActivity.14.1(this, i, ???));
    FtnListActivity.access$1502(this.this$0, false);
    synchronized (FtnListActivity.access$3100(this.this$0))
    {
      FtnListActivity.access$3208(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.14
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;

class FtnListActivity$16
  extends IObserver
{
  FtnListActivity$16(FtnListActivity paramFtnListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (HashMap)paramObject;
    paramObject = (FtnUploadInfo)paramObservable.get("paramerrordata");
    FtnListActivity.access$3800(this.this$0, new FtnListActivity.16.1(this, paramObject, paramObservable));
    FtnListActivity.access$3208(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.16
 * JD-Core Version:    0.7.0.1
 */
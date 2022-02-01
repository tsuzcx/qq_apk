package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;

class FtnListActivity$15
  extends IObserver
{
  FtnListActivity$15(FtnListActivity paramFtnListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (FtnUploadInfo)((HashMap)paramObject).get("actioncreatefileuploaditemdata");
    FtnListActivity.access$900(this.this$0).initResetViewState(paramObservable.getFid());
    this.this$0.updateRealPause(paramObservable.getFid(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.15
 * JD-Core Version:    0.7.0.1
 */
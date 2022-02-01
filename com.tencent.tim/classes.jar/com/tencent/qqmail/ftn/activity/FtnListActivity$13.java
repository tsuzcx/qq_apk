package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;

class FtnListActivity$13
  extends IObserver
{
  FtnListActivity$13(FtnListActivity paramFtnListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (FtnUploadInfo)((HashMap)paramObject).get("prarmuploadfileprogressuploaditemdata");
    FtnListActivity.access$3300(this.this$0, paramObservable);
    QMLog.log(4, "FtnListActivity", "uploadSuccess, fid:" + paramObservable.getFid() + "," + paramObservable.getProgress());
    FtnListActivity.access$3600(this.this$0, new FtnListActivity.13.1(this, paramObservable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.13
 * JD-Core Version:    0.7.0.1
 */
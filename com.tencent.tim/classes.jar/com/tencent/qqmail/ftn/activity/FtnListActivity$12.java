package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;

class FtnListActivity$12
  extends IObserver
{
  FtnListActivity$12(FtnListActivity paramFtnListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (FtnUploadInfo)((HashMap)paramObject).get("prarmuploadfileprogressuploaditemdata");
    int i = FtnCommonUtils.calcProgress(paramObservable.getUploadedSize(), paramObservable.getFileSize(), 1.0D);
    QMLog.log(3, "FtnListActivity", "observerUploadFileProgress:" + paramObservable.getUploadedSize() + "," + paramObservable.getFileSize() + "," + i);
    if (i == 100) {
      FtnListActivity.access$3300(this.this$0, paramObservable);
    }
    FtnListActivity.access$3500(this.this$0, new FtnListActivity.12.1(this, paramObservable, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.12
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

class FtnListActivity$10
  extends IObserver
{
  FtnListActivity$10(FtnListActivity paramFtnListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable arg1, Object paramObject)
  {
    paramObject = (FtnUploadInfo)((HashMap)paramObject).get("paramsignfileuploadeditemdata");
    QMLog.log(4, "FtnListActivity", "SignFileSuccessObserver update, file: " + paramObject.getAbsolutePath() + ", size: " + paramObject.getFileSize());
    QMLog.log(3, "FtnListActivity", "SignFileSuccessObserver update, isCompressProcess: " + FtnListActivity.access$2100(this.this$0) + ", waitCompressImages: " + FtnListActivity.access$2200(this.this$0) + ", waitCompressCount: " + FtnListActivity.access$2300(this.this$0) + ", waitUploadFiles: " + FtnListActivity.access$2400(this.this$0));
    if (FtnListActivity.access$2100(this.this$0)) {}
    synchronized (FtnListActivity.access$2500(this.this$0))
    {
      if (FtnListActivity.access$2100(this.this$0))
      {
        paramObject.setOriginalPath(paramObject.getAbsolutePath());
        if (FtnListActivity.access$2200(this.this$0).indexOf(paramObject) != -1) {
          FtnListActivity.access$2306(this.this$0);
        }
        if (FtnListActivity.access$2300(this.this$0) == 0)
        {
          FtnListActivity.access$2102(this.this$0, false);
          FtnListActivity.access$2700(this.this$0, FtnListActivity.access$2600(this.this$0));
        }
        return;
      }
      if (!FtnListActivity.access$2800(this.this$0)) {
        break label297;
      }
      if (FtnListActivity.access$2200(this.this$0).indexOf(paramObject) != -1)
      {
        FtnListActivity.access$500(this.this$0).createFile(paramObject);
        return;
      }
    }
    if (FtnListActivity.access$2400(this.this$0).indexOf(paramObject) != -1)
    {
      FtnListActivity.access$500(this.this$0).createFile(paramObject);
      return;
      label297:
      FtnListActivity.access$2900(this.this$0, new FtnListActivity.10.1(this, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.10
 * JD-Core Version:    0.7.0.1
 */
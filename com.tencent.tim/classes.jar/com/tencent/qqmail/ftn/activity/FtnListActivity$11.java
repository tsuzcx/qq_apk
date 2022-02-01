package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

class FtnListActivity$11
  extends IObserver
{
  FtnListActivity$11(FtnListActivity paramFtnListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable arg1, Object paramObject)
  {
    paramObject = (FtnUploadInfo)((HashMap)paramObject).get("paramsignfileuploadeditemdata");
    if (FtnListActivity.access$2100(this.this$0)) {}
    synchronized (FtnListActivity.access$2500(this.this$0))
    {
      if (FtnListActivity.access$2100(this.this$0))
      {
        if (FtnListActivity.access$2200(this.this$0).indexOf(paramObject) != -1)
        {
          FtnListActivity.access$2306(this.this$0);
          FtnListActivity.access$2200(this.this$0).remove(paramObject);
        }
        if (FtnListActivity.access$2300(this.this$0) == 0)
        {
          FtnListActivity.access$2102(this.this$0, false);
          FtnListActivity.access$2700(this.this$0, FtnListActivity.access$2600(this.this$0));
        }
        return;
      }
      FtnListActivity.access$3000(this.this$0, new FtnListActivity.11.1(this, paramObject));
      synchronized (FtnListActivity.access$3100(this.this$0))
      {
        FtnListActivity.access$3208(this.this$0);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.11
 * JD-Core Version:    0.7.0.1
 */
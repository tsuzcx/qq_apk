package com.tencent.qqmail.download.activity;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;

class DownloadActivity$4
  extends IObserver
{
  DownloadActivity$4(DownloadActivity paramDownloadActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObject = (HashMap)paramObject;
    paramObservable = (String)paramObject.get("paramfid");
    paramObject = (String)paramObject.get("paramfilename");
    DownloadActivity.access$400(this.this$0, new DownloadActivity.4.1(this, paramObservable, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.download.activity;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;

class DownloadActivity$5
  extends IObserver
{
  DownloadActivity$5(DownloadActivity paramDownloadActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (String)((HashMap)paramObject).get("paramfilename");
    DownloadActivity.access$500(this.this$0, new DownloadActivity.5.1(this, paramObservable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.5
 * JD-Core Version:    0.7.0.1
 */
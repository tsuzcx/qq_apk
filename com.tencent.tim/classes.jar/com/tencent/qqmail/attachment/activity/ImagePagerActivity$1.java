package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.model.ImageData;
import com.tencent.qqmail.ftn.util.SharedUrlUtil;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.HashMap;
import java.util.Observable;

class ImagePagerActivity$1
  extends IObserver
{
  ImagePagerActivity$1(ImagePagerActivity paramImagePagerActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (String)((HashMap)paramObject).get("paramfid");
    ImagePagerActivity.access$200(this.this$0);
    paramObservable = SharedUrlUtil.getUrl(paramObservable);
    if (ImagePagerActivity.access$300(this.this$0) != null) {
      ImagePagerActivity.access$300(this.this$0).setShareUrl(paramObservable);
    }
    Threads.runOnMainThread(new ImagePagerActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.1
 * JD-Core Version:    0.7.0.1
 */
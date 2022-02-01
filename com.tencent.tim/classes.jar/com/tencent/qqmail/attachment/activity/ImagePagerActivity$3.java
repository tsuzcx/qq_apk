package com.tencent.qqmail.attachment.activity;

import android.os.Handler;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.Observable;

class ImagePagerActivity$3
  extends IObserver
{
  ImagePagerActivity$3(ImagePagerActivity paramImagePagerActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    ImagePagerActivity.access$900(this.this$0).post(new ImagePagerActivity.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.3
 * JD-Core Version:    0.7.0.1
 */
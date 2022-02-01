package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.view.CustomViewPager;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.Observable;

class ImagePagerActivity$6
  extends IObserver
{
  ImagePagerActivity$6(ImagePagerActivity paramImagePagerActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    ImagePagerActivity.access$1400(this.this$0);
    ImagePagerActivity.access$1200(this.this$0, false);
    ImagePagerActivity.access$1300(this.this$0).setPagingEnable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.6
 * JD-Core Version:    0.7.0.1
 */
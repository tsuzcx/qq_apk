package com.tencent.qqmail.activity.media;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.Observable;

class ImageAttachBucketSelectActivity$3
  extends IObserver
{
  ImageAttachBucketSelectActivity$3(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.this$0.getTips().showError(this.this$0.getString(2131718938));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.3
 * JD-Core Version:    0.7.0.1
 */
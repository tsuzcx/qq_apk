package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import java.util.Observable;

class ImagePagerActivity$2
  extends IObserver
{
  ImagePagerActivity$2(ImagePagerActivity paramImagePagerActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    ImagePagerActivity.access$200(this.this$0);
    QMUIHelper.showToast(this.this$0, 2131694337, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.2
 * JD-Core Version:    0.7.0.1
 */
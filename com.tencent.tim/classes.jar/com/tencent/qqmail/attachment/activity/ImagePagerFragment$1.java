package com.tencent.qqmail.attachment.activity;

import android.os.Handler;
import com.tencent.qqmail.attachment.model.ImageData;
import com.tencent.qqmail.attachment.util.ImagePagerCache;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;

class ImagePagerFragment$1
  extends IObserver
{
  ImagePagerFragment$1(ImagePagerFragment paramImagePagerFragment, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (HashMap)paramObject;
    if ((ImagePagerCache.imageFtnUIs.getCount() == 0) || (ImagePagerFragment.access$000(this.this$0) >= ImagePagerCache.imageFtnUIs.getCount())) {}
    do
    {
      return;
      ImagePagerFragment.access$102(this.this$0, ImagePagerCache.getImageData(ImagePagerActivity.mUin, ImagePagerFragment.access$000(this.this$0)));
    } while (!((String)paramObservable.get("paramfid")).equals(ImagePagerFragment.access$100(this.this$0).getFid()));
    paramObservable = (ImagePagerActivity)this.this$0.getActivity();
    ImagePagerFragment.access$800(this.this$0).post(new ImagePagerFragment.1.1(this, paramObservable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerFragment.1
 * JD-Core Version:    0.7.0.1
 */
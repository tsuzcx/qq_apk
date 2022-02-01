package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;

class ImagePagerFragment$2
  extends IObserver
{
  ImagePagerFragment$2(ImagePagerFragment paramImagePagerFragment, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (HashMap)paramObject;
    QMLog.log(6, "ImagePagerFragment", "getDownloadUrl error : " + paramObservable.get("paramerrorcgiexceptioncode") + "; " + paramObservable.get("paramerrorlogiccode") + "; " + paramObservable.get("paramerrortype") + "; " + paramObservable.get("paramerrordescription"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerFragment.2
 * JD-Core Version:    0.7.0.1
 */
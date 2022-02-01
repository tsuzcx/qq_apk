package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

class ImagePagerActivity$5
  extends IObserver
{
  ImagePagerActivity$5(ImagePagerActivity paramImagePagerActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Threads.runOnMainThread(new ImagePagerActivity.5.1(this, (ArrayList)((HashMap)paramObject).get("paramdelfilesuccfids")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.5
 * JD-Core Version:    0.7.0.1
 */
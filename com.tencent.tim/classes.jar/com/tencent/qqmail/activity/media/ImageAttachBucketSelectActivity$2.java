package com.tencent.qqmail.activity.media;

import android.os.Handler;
import com.tencent.qqmail.ftn.Ftn.ItemOutputStoreFile;
import com.tencent.qqmail.ftn.Ftn.StoreFileOutput;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Timer;

class ImageAttachBucketSelectActivity$2
  extends IObserver
{
  ImageAttachBucketSelectActivity$2(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int j;
    int i;
    int k;
    if (paramObject != null)
    {
      paramObservable = (StoreFileOutput)((HashMap)paramObject).get("paramsavefileinfo");
      if ((paramObservable == null) || (paramObservable.itemlist == null)) {
        break label223;
      }
      int m = paramObservable.itemlist.size();
      paramObservable = paramObservable.itemlist.iterator();
      j = 0;
      i = 0;
      if (paramObservable.hasNext())
      {
        paramObject = (ItemOutputStoreFile)paramObservable.next();
        if ((paramObject.ret == -106) || (paramObject.ret == -109))
        {
          k = j + 1;
          j = i;
          i = k;
        }
        for (;;)
        {
          k = j;
          j = i;
          i = k;
          break;
          k = i + 1;
          i = j;
          j = k;
        }
      }
      k = m;
    }
    for (;;)
    {
      if (k == i)
      {
        ImageAttachBucketSelectActivity.access$600(this.this$0).sendEmptyMessage(0);
        return;
      }
      if (k == j)
      {
        new Timer().schedule(new ImageAttachBucketSelectActivity.2.1(this), 200L);
        return;
      }
      if (k == 0)
      {
        ImageAttachBucketSelectActivity.access$600(this.this$0).sendEmptyMessage(3);
        return;
      }
      ImageAttachBucketSelectActivity.access$600(this.this$0).sendEmptyMessage(2);
      return;
      ImageAttachBucketSelectActivity.access$600(this.this$0).sendEmptyMessage(4);
      return;
      label223:
      k = 0;
      j = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.2
 * JD-Core Version:    0.7.0.1
 */
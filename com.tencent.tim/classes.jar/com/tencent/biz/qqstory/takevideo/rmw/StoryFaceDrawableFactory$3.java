package com.tencent.biz.qqstory.takevideo.rmw;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import ram;
import rln;
import rrk;

public class StoryFaceDrawableFactory$3
  implements Runnable
{
  public void run()
  {
    Bitmap localBitmap = this.this$0.t(this.val$localPath);
    if (localBitmap != null)
    {
      rrk localrrk = (rrk)this.this$0.h.get(this.val$uin);
      if (localrrk != null)
      {
        localrrk.x(localBitmap);
        this.this$0.mUIHandler.obtainMessage(1002).sendToTarget();
        return;
      }
      ram.w("Q.qqstory.record.StoryFaceDrawableFactory", "Find faceDrawable is not in cache after decoding bitmap!");
      localrrk = new rrk(this.this$0.bte, this.this$0.btf);
      localrrk.x(localBitmap);
      this.this$0.h.put(this.val$uin, localrrk);
      return;
    }
    ram.e("Q.qqstory.record.StoryFaceDrawableFactory", "getFaceBitmapByPath return null!.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.StoryFaceDrawableFactory.3
 * JD-Core Version:    0.7.0.1
 */
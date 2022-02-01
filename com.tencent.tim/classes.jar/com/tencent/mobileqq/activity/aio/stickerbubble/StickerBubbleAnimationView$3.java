package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import yfv;

class StickerBubbleAnimationView$3
  implements Runnable
{
  StickerBubbleAnimationView$3(StickerBubbleAnimationView paramStickerBubbleAnimationView, String paramString) {}
  
  public void run()
  {
    Object localObject = new File(this.aXC);
    if (((File)localObject).exists()) {
      try
      {
        yfv localyfv = new yfv((File)localObject, false);
        StickerBubbleAnimationView.c(this.this$0).put(this.aXC, Integer.valueOf(localyfv.getFrameDelay()));
        BitmapDrawable[] arrayOfBitmapDrawable = new BitmapDrawable[localyfv.getFrameCount()];
        localObject = StickerBubbleAnimationView.a(this.this$0, localyfv.an(), 0.7D);
        Resources localResources = this.this$0.getResources();
        if (localObject != null) {}
        for (;;)
        {
          arrayOfBitmapDrawable[0] = new BitmapDrawable(localResources, (Bitmap)localObject);
          StickerBubbleAnimationView.a(this.this$0, localyfv, arrayOfBitmapDrawable, this.aXC, localyfv.getFrameDelay());
          StickerBubbleAnimationView.d(this.this$0).put(this.aXC, arrayOfBitmapDrawable);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("StickerBubbleAnimationView", 2, "decoded first frame of gif: " + this.aXC);
          return;
          localObject = localyfv.an();
        }
        QLog.e("StickerBubbleAnimationView", 1, "gifFile " + this.aXC + " is not exist");
      }
      catch (IOException localIOException)
      {
        QLog.e("StickerBubbleAnimationView", 1, "decode gif fail: " + localIOException);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("StickerBubbleAnimationView", 1, "oom when decode gif or scale first frame, " + localOutOfMemoryError);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.3
 * JD-Core Version:    0.7.0.1
 */
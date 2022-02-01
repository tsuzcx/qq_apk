package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import yfv;
import yfy;

class StickerBubbleAnimationView$2
  implements Runnable
{
  StickerBubbleAnimationView$2(StickerBubbleAnimationView paramStickerBubbleAnimationView, BitmapDrawable[] paramArrayOfBitmapDrawable, yfv paramyfv, String paramString, int paramInt) {}
  
  public void run()
  {
    int j = 0;
    int i = 1;
    if (i < this.d.length)
    {
      this.a.chU();
      Object localObject = StickerBubbleAnimationView.a(this.this$0, this.a.an(), 0.7D);
      BitmapDrawable[] arrayOfBitmapDrawable = this.d;
      if (localObject != null) {}
      for (localObject = new BitmapDrawable(this.this$0.getResources(), (Bitmap)localObject);; localObject = null)
      {
        arrayOfBitmapDrawable[i] = localObject;
        QLog.d("StickerBubbleAnimationView", 2, "decode gif: " + i + " / " + this.a.getCurrentFrameIndex() + " / " + this.val$path);
        if (i != this.a.getCurrentFrameIndex())
        {
          if (QLog.isColorLevel()) {
            QLog.e("StickerBubbleAnimationView", 2, "index is not matched, " + i + " / " + this.d.length + " / " + this.val$path);
          }
          j = 1;
        }
        i += 1;
        break;
      }
    }
    if (j == 0) {
      yfy.a(this.val$path, this.d, this.bYQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.2
 * JD-Core Version:    0.7.0.1
 */
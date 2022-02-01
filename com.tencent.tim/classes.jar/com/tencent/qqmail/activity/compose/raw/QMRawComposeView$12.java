package com.tencent.qqmail.activity.compose.raw;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.style.ImageSpan;

class QMRawComposeView$12
  implements Runnable
{
  QMRawComposeView$12(QMRawComposeView paramQMRawComposeView, ImageSpan[] paramArrayOfImageSpan) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.val$imageSpans.length)
      {
        ImageSpan localImageSpan = this.val$imageSpans[i];
        Object localObject = null;
        if ((localImageSpan.getDrawable() instanceof BitmapDrawable)) {
          localObject = (BitmapDrawable)localImageSpan.getDrawable();
        }
        if ((localObject != null) && (((BitmapDrawable)localObject).getBitmap() != null))
        {
          localObject = ((BitmapDrawable)localObject).getBitmap();
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
            ((Bitmap)localObject).recycle();
          }
        }
        try
        {
          Thread.sleep(500L);
          i += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.raw.QMRawComposeView.12
 * JD-Core Version:    0.7.0.1
 */
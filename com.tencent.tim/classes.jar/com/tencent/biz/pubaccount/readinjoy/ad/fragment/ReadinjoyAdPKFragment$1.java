package com.tencent.biz.pubaccount.readinjoy.ad.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyAdPKFragment$1
  implements Runnable
{
  ReadinjoyAdPKFragment$1(ReadinjoyAdPKFragment paramReadinjoyAdPKFragment) {}
  
  public void run()
  {
    if (ReadinjoyAdPKFragment.a(this.this$0) != null) {
      try
      {
        Bitmap localBitmap1 = Bitmap.createScaledBitmap(ReadinjoyAdPKFragment.a(this.this$0), (int)(ReadinjoyAdPKFragment.a(this.this$0).getWidth() * 0.0625F), (int)(ReadinjoyAdPKFragment.a(this.this$0).getHeight() * 0.0625F), false);
        if (localBitmap1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReadinjoyAdPKFragment", 1, "run: scaledBitmap == null");
          }
        }
        else
        {
          localBitmap2 = new StackBlurManager(localBitmap1).process(4);
          if (localBitmap2 == null)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e("ReadinjoyAdPKFragment", 1, "run: blured bitmap is null");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Bitmap localBitmap2;
        if (QLog.isColorLevel())
        {
          QLog.e("ReadinjoyAdPKFragment", 2, "mDecodeRunnable error message = " + localThrowable.getMessage());
          return;
          Canvas localCanvas = new Canvas(localThrowable);
          localCanvas.drawColor(0);
          localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, null);
          localCanvas.drawColor(Color.parseColor("#7F03081A"));
          localCanvas.setBitmap(null);
          ReadinjoyAdPKFragment.a(this.this$0).post(new ReadinjoyAdPKFragment.1.1(this, localThrowable));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.fragment.ReadinjoyAdPKFragment.1
 * JD-Core Version:    0.7.0.1
 */
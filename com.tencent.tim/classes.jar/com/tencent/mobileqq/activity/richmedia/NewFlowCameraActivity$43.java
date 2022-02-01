package com.tencent.mobileqq.activity.richmedia;

import android.graphics.Bitmap;
import android.os.Handler;
import ankt;
import qwh;
import ram;
import rop;
import wja;

class NewFlowCameraActivity$43
  implements Runnable
{
  NewFlowCameraActivity$43(NewFlowCameraActivity paramNewFlowCameraActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    int i = wja.dp2px(47.0F, this.this$0.getResources());
    int j = wja.dp2px(75.0F, this.this$0.getResources());
    Bitmap localBitmap1 = rop.b(this.es, i, j, false);
    if (localBitmap1 == null) {
      ram.e("PTV.NewFlowCameraActivity", "resizeThumb = null.");
    }
    Bitmap localBitmap2;
    do
    {
      return;
      localBitmap2 = new qwh(wja.dp2px(3.0F, this.this$0.getResources()), 0, j * 1.0F / i, null, null).z(localBitmap1);
      if (localBitmap2 == null)
      {
        ram.e("PTV.NewFlowCameraActivity", "roundThumb = null.");
        return;
      }
      i = this.es.getWidth();
      j = this.es.getHeight();
      float f1 = ankt.SCREEN_WIDTH;
      float f2 = ankt.aC(this.this$0.getApplicationContext());
      if (i / j > f1 / f2) {}
      for (localBitmap1 = rop.b(this.es, (int)(f1 / f2 * j), j, true); localBitmap1 == null; localBitmap1 = rop.b(this.es, i, (int)(f2 / f1 * i), true))
      {
        ram.e("PTV.NewFlowCameraActivity", "animBitmap = null.");
        return;
      }
    } while (this.this$0.mUIHandler == null);
    this.this$0.mUIHandler.post(new NewFlowCameraActivity.RunnableUpdateThumb(this.this$0, localBitmap1, localBitmap2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.43
 * JD-Core Version:    0.7.0.1
 */
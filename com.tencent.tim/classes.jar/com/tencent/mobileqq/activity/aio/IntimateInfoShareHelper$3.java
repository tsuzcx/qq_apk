package com.tencent.mobileqq.activity.aio;

import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import wlh;

public class IntimateInfoShareHelper$3
  implements Runnable
{
  public IntimateInfoShareHelper$3(wlh paramwlh, Bitmap paramBitmap, int paramInt) {}
  
  public void run()
  {
    if ((this.dz == null) || (this.dz.isRecycled())) {}
    Bitmap localBitmap2;
    for (Bitmap localBitmap1 = this.this$0.a(wlh.a(this.this$0));; localBitmap1 = this.dz)
    {
      if (this.bPe != 3)
      {
        localBitmap2 = localBitmap1;
        if (this.bPe != 4) {}
      }
      else
      {
        localBitmap2 = this.this$0.D(localBitmap1);
      }
      if ((localBitmap2 != null) && (!localBitmap2.isRecycled()) && (wlh.a(this.this$0) != null) && (!wlh.a(this.this$0).isFinishing())) {
        break;
      }
      wlh.a(this.this$0, 1, 2131695096);
      return;
    }
    switch (this.bPe)
    {
    }
    for (;;)
    {
      wlh.a(this.this$0);
      return;
      wlh.a(this.this$0, localBitmap2);
      continue;
      wlh.b(this.this$0, localBitmap2);
      continue;
      wlh.c(this.this$0, localBitmap2);
      continue;
      wlh.a(this.this$0, localBitmap2, this.bPe);
      continue;
      wlh.a(this.this$0, localBitmap2, this.bPe);
      continue;
      wlh.d(this.this$0, localBitmap2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.3
 * JD-Core Version:    0.7.0.1
 */
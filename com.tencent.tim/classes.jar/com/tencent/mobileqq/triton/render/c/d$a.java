package com.tencent.mobileqq.triton.render.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mobileqq.triton.sdk.callback.ScreenShotCallback;

class d$a
  implements Runnable
{
  d$a(d paramd, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void run()
  {
    Object localObject = new int[this.a * this.b];
    int i = 0;
    int k;
    for (;;)
    {
      k = this.b;
      if (i >= k) {
        break;
      }
      int m = this.a;
      int j = 0;
      while (j < this.a)
      {
        int n = this.c[(i * m + j)];
        localObject[(m * (k - i - 1) + j)] = (n & 0xFF00FF00 | n << 16 & 0xFF0000 | n >> 16 & 0xFF);
        j += 1;
      }
      i += 1;
    }
    localObject = Bitmap.createBitmap((int[])localObject, this.a, k, Bitmap.Config.ARGB_8888);
    if (d.a(this.d) != null) {
      d.a(this.d).onScreenShotCallback((Bitmap)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.c.d.a
 * JD-Core Version:    0.7.0.1
 */
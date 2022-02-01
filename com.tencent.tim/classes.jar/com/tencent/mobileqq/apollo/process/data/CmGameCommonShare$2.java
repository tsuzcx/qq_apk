package com.tencent.mobileqq.apollo.process.data;

import aboo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import aqgz;
import aqhu;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import lk;
import rwt;

public class CmGameCommonShare$2
  implements Runnable
{
  public CmGameCommonShare$2(aboo paramaboo, int paramInt, Bitmap paramBitmap, File paramFile) {}
  
  public void run()
  {
    int n;
    Object localObject1;
    int i;
    int j;
    int k;
    try
    {
      m = (int)aqgz.hK() / 4;
      localBitmap = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      localObject2 = rwt.a("https://cmshow.qq.com/apollo/html/game-platform/scan-game.html?gameId=" + this.val$gameId, -1);
      n = ((lk)localObject2).getWidth();
      localObject1 = new int[n * n];
      i = 0;
    }
    catch (Exception localException)
    {
      int m;
      Bitmap localBitmap;
      Canvas localCanvas;
      Object localObject2;
      QLog.e("apollo_cmGame_CmGameCommonShare", 1, "drawQRBitmap e:", localException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      return;
    }
    if (j < n) {
      if (((lk)localObject2).get(j, i)) {
        k = -16777216;
      }
    }
    label355:
    for (;;)
    {
      localObject2 = Bitmap.createBitmap(n, n, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject2).setPixels((int[])localObject1, 0, n, 0, 0, n, n);
      localObject1 = new Rect(0, 0, m, m);
      localCanvas.drawBitmap((Bitmap)localObject2, new Rect(0, 0, n, n), (Rect)localObject1, null);
      if ((this.val$bitmap != null) && (!this.val$bitmap.isRecycled()))
      {
        i = m * 8 / 41;
        j = (m - i) / 2;
        k = (m - i) / 2;
        localCanvas.save();
        localCanvas.translate(j, k);
        localCanvas.drawBitmap(this.val$bitmap, new Rect(0, 0, this.val$bitmap.getWidth(), this.val$bitmap.getHeight()), new Rect(0, 0, i, i), null);
        localCanvas.restore();
      }
      ((Bitmap)localObject2).recycle();
      aqhu.saveBitmapToFile(localBitmap, this.val$file);
      QLog.d("apollo_cmGame_CmGameCommonShare", 2, "checkDefaultQRSharePic end");
      return;
      for (;;)
      {
        if (i >= n) {
          break label355;
        }
        j = 0;
        break;
        for (;;)
        {
          localObject1[(i * n + j)] = k;
          j += 1;
          break;
          k = -1;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.2
 * JD-Core Version:    0.7.0.1
 */
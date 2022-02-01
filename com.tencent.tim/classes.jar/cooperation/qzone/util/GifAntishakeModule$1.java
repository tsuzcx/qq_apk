package cooperation.qzone.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import aqhu;
import awcg;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.pfc.opencv.QzoneVision;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class GifAntishakeModule$1
  implements Runnable
{
  public GifAntishakeModule$1(awcg paramawcg, int paramInt1, int paramInt2, int paramInt3, ArrayList paramArrayList, Bitmap paramBitmap, int paramInt4, int paramInt5, String[] paramArrayOfString, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "frame: " + this.val$frame + ", startAntishake at " + System.currentTimeMillis());
      }
      Bitmap localBitmap1 = Bitmap.createBitmap(this.val$width, this.val$height, Bitmap.Config.RGB_565);
      Bitmap localBitmap2 = (Bitmap)this.Fl.get(this.val$frame);
      if ((this.hf != null) && (localBitmap2 != null) && (localBitmap1 != null))
      {
        QzoneVision.getAntiShakeBitmap(this.hf, localBitmap2, localBitmap1);
        localBitmap2 = Bitmap.createBitmap(localBitmap1, this.ezW, this.ezX, localBitmap1.getWidth() - this.ezW * 2, localBitmap1.getHeight() - this.ezX * 2);
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVision", 2, "frame: " + this.val$frame + ", endAntishake and startSave at " + System.currentTimeMillis());
        }
        String str = PhotoUtils.v(awcg.a(this.this$0), ".IMG" + this.val$frame, ".jpg");
        aqhu.saveBitmapToFile(localBitmap2, new File(str));
        if (!localBitmap1.isRecycled()) {
          localBitmap1.recycle();
        }
        if (!localBitmap2.isRecycled()) {
          localBitmap2.recycle();
        }
        this.ja[this.val$frame] = str;
        awcg.access$108();
        awcg.a(this.this$0, awcg.access$100());
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVision", 2, "frame: " + this.val$frame + ", endSave at " + System.currentTimeMillis());
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    this.val$countDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.util.GifAntishakeModule.1
 * JD-Core Version:    0.7.0.1
 */
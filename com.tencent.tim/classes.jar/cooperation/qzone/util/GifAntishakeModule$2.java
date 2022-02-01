package cooperation.qzone.util;

import android.graphics.Bitmap;
import awcg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class GifAntishakeModule$2
  implements Runnable
{
  public GifAntishakeModule$2(awcg paramawcg, ArrayList paramArrayList, int paramInt1, CountDownLatch paramCountDownLatch, Bitmap paramBitmap, int paramInt2, boolean[] paramArrayOfBoolean) {}
  
  public void run()
  {
    Bitmap localBitmap = (Bitmap)this.Fm.get(this.val$num);
    if (localBitmap == null)
    {
      this.val$countDownLatch.countDown();
      return;
    }
    if (this.val$num != 0)
    {
      long l = System.currentTimeMillis();
      int i = awcg.am(awcg.j(this.hg), awcg.j(localBitmap));
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "DHash: 第一帧与第" + (this.val$num + 1) + "帧的相似度为 dif=" + i + " now:" + (System.currentTimeMillis() - l));
      }
      if ((localBitmap.getWidth() == this.hg.getWidth()) && (localBitmap.getHeight() == this.hg.getHeight()) && (awcg.a(this.this$0, this.ezY, i))) {
        this.D[this.val$num] = true;
      }
    }
    this.val$countDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.util.GifAntishakeModule.2
 * JD-Core Version:    0.7.0.1
 */
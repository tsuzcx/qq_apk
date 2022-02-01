package dov.com.qq.im.cropvideo;

import pog.e;
import ram;

final class CropVideoActivity$CropUtils$1
  implements Runnable
{
  CropVideoActivity$CropUtils$1(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, pog.e parame) {}
  
  public void run()
  {
    try
    {
      try
      {
        int i = CropVideoActivity.a.b(this.val$inputFilePath, this.val$outputFilePath, this.eIR, this.eIS, this.eIT, this.eIU, this.eIV, this.val$targetHeight, this.val$startTime, this.aP);
        if (this.a != null) {
          this.a.g(i, "", this.val$outputFilePath);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      ram.e("CropVideoActivity", "do composite exception", localException);
      if (this.a != null) {
        this.a.g(940001, localException.getMessage(), "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.cropvideo.CropVideoActivity.CropUtils.1
 * JD-Core Version:    0.7.0.1
 */
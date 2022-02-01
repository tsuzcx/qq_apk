package dov.com.qq.im.ae.play;

import android.graphics.Bitmap;
import axic;
import axic.d;

public final class FaceChangeUtils$5
  implements Runnable
{
  public FaceChangeUtils$5(Bitmap paramBitmap, axic.d paramd) {}
  
  public void run()
  {
    try
    {
      axic.c(this.gb, this.a);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.onFail(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.FaceChangeUtils.5
 * JD-Core Version:    0.7.0.1
 */
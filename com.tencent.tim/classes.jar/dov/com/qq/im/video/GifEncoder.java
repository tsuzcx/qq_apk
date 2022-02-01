package dov.com.qq.im.video;

import android.graphics.Bitmap;
import awtj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;

public class GifEncoder
{
  private static final int CPU_COUNT;
  private static int eJU;
  private static int eJV;
  private static int eJW;
  private long Kf;
  private int bvF = Math.max(2, Math.min(CPU_COUNT - 1, 4));
  private int height;
  private int width;
  
  static
  {
    try
    {
      awtj.init();
      System.load(new File(FeatureManager.getSoDir(), "libgiftools.so").getPath());
      eJU = 1;
      eJV = 2;
      eJW = 3;
      CPU_COUNT = Runtime.getRuntime().availableProcessors();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("GifEncoder", 4, "load libgiftools.so fail, msg = " + localException.getMessage());
      }
    }
  }
  
  private native void nativeClose(long paramLong);
  
  private native boolean nativeEncodeFrame(long paramLong, Bitmap paramBitmap, int paramInt);
  
  private native long nativeInit(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4);
  
  private native void nativeSetDither(long paramLong, boolean paramBoolean);
  
  private native void nativeSetThreadCount(long paramLong, int paramInt);
  
  public void U(int paramInt1, int paramInt2, String paramString)
    throws FileNotFoundException
  {
    f(paramInt1, paramInt2, paramString, eJU);
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt)
  {
    if (0L == this.Kf) {
      return false;
    }
    if ((paramBitmap.getWidth() != this.width) || (paramBitmap.getHeight() != this.height)) {
      throw new RuntimeException(String.format(Locale.ENGLISH, "The size specified at initialization differs from the size of the image.\n expected:(%d, %d) actual:(%d,%d)", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height), Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) }));
    }
    nativeEncodeFrame(this.Kf, paramBitmap, paramInt);
    return true;
  }
  
  public void close()
  {
    nativeClose(this.Kf);
    this.Kf = 0L;
  }
  
  public void f(int paramInt1, int paramInt2, String paramString, int paramInt3)
    throws FileNotFoundException
  {
    if (0L != this.Kf) {
      close();
    }
    this.width = paramInt1;
    this.height = paramInt2;
    QLog.d("GifEncoder", 4, new Object[] { "GifEncoder init, with = ", Integer.valueOf(paramInt1), ", height = ", Integer.valueOf(paramInt2), ", path = ", paramString, ", encodingType = ", Integer.valueOf(paramInt3), ", threadCount = ", Integer.valueOf(this.bvF) });
    this.Kf = nativeInit(paramInt1, paramInt2, paramString, paramInt3, this.bvF);
    if (0L == this.Kf) {
      throw new FileNotFoundException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.video.GifEncoder
 * JD-Core Version:    0.7.0.1
 */
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class xjn
{
  public Handler a;
  public HandlerThread a;
  public xjo a;
  
  public xjn()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("MediaCodecThumbnailGenerator");
  }
  
  private float a(Bitmap paramBitmap)
  {
    int i1 = paramBitmap.getHeight() / 16;
    int i2 = paramBitmap.getWidth() / 9;
    int k = 0;
    int i = 0;
    int j = 0;
    while (k < paramBitmap.getHeight())
    {
      int m = 0;
      if (m < paramBitmap.getWidth())
      {
        int n = paramBitmap.getPixel(m, k);
        if (((n >> 16 & 0xFF) < 10) && ((n >> 8 & 0xFF) < 10) && ((n & 0xFF) < 10))
        {
          n = j + 1;
          j = i;
        }
        for (i = n;; i = n)
        {
          n = m + i2;
          m = i;
          i = j;
          j = m;
          m = n;
          break;
          n = j;
          j = i + 1;
        }
      }
      k += i1;
    }
    float f = j / (i + j);
    wxe.c("MediaCodecThumbnailGen", "whitePixelCount = " + i + " blackPixelCount = " + j);
    return f;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Xjo = new xjo(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.myLooper());
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, xjl<Boolean, xjr> paramxjl, xjl<Boolean, xjq> paramxjl1)
  {
    xjp localxjp = new xjp();
    localxjp.jdField_a_of_type_JavaLangString = paramString1;
    localxjp.jdField_b_of_type_JavaLangString = paramString2;
    localxjp.jdField_a_of_type_Boolean = paramBoolean1;
    localxjp.jdField_a_of_type_Int = paramInt1;
    localxjp.jdField_b_of_type_Int = paramInt2;
    localxjp.c = paramInt3;
    localxjp.d = paramInt4;
    localxjp.jdField_b_of_type_Boolean = paramBoolean2;
    localxjp.jdField_b_of_type_Xjl = paramxjl;
    localxjp.jdField_a_of_type_Xjl = paramxjl1;
    Message.obtain(this.jdField_a_of_type_Xjo, 1, localxjp).sendToTarget();
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjn
 * JD-Core Version:    0.7.0.1
 */
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class vqm
{
  public Handler a;
  public HandlerThread a;
  public vqn a;
  
  public vqm()
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
    ved.c("MediaCodecThumbnailGen", "whitePixelCount = " + i + " blackPixelCount = " + j);
    return f;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Vqn = new vqn(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.myLooper());
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, vqk<Boolean, vqq> paramvqk, vqk<Boolean, vqp> paramvqk1)
  {
    vqo localvqo = new vqo();
    localvqo.jdField_a_of_type_JavaLangString = paramString1;
    localvqo.jdField_b_of_type_JavaLangString = paramString2;
    localvqo.jdField_a_of_type_Boolean = paramBoolean1;
    localvqo.jdField_a_of_type_Int = paramInt1;
    localvqo.jdField_b_of_type_Int = paramInt2;
    localvqo.c = paramInt3;
    localvqo.d = paramInt4;
    localvqo.jdField_b_of_type_Boolean = paramBoolean2;
    localvqo.jdField_b_of_type_Vqk = paramvqk;
    localvqo.jdField_a_of_type_Vqk = paramvqk1;
    Message.obtain(this.jdField_a_of_type_Vqn, 1, localvqo).sendToTarget();
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqm
 * JD-Core Version:    0.7.0.1
 */
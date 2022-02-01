import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class zxz
  implements bagj
{
  public long a;
  
  zxz(zxy paramzxy, List paramList, zxs paramzxs, zxt paramzxt) {}
  
  private boolean a()
  {
    boolean bool2 = false;
    int i;
    if (zxy.a(this.jdField_a_of_type_Zxy).size() == 1) {
      i = 0;
    }
    int j;
    do
    {
      long l = 1000000 * zxy.c(this.jdField_a_of_type_Zxy);
      boolean bool1 = bool2;
      if (zxy.a(this.jdField_a_of_type_Zxy) != null)
      {
        bool1 = bool2;
        if (((Integer)zxy.a(this.jdField_a_of_type_Zxy).get(i)).intValue() > 0)
        {
          bool1 = bool2;
          if (zxy.a(this.jdField_a_of_type_Zxy) < zxy.b(this.jdField_a_of_type_Zxy) * 1000000L)
          {
            zxy.a(this.jdField_a_of_type_Zxy).a(3553, ((Integer)zxy.a(this.jdField_a_of_type_Zxy).get(0)).intValue(), null, null, zxy.a(this.jdField_a_of_type_Zxy));
            zxy.a(this.jdField_a_of_type_Zxy, zxy.a(this.jdField_a_of_type_Zxy) + l);
            bool1 = true;
          }
        }
      }
      return bool1;
      j = (int)(zxy.a(this.jdField_a_of_type_Zxy) / (Long.valueOf("2").longValue() * 1000L * 1000000L));
      i = j;
    } while (j < zxy.a(this.jdField_a_of_type_Zxy).size());
    return false;
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MuiltiImageToVideo", 2, "onEncodeError, code:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_Zxy)
    {
      this.jdField_a_of_type_Zxy.notifyAll();
      if (this.jdField_a_of_type_Zxs != null)
      {
        this.jdField_a_of_type_Zxt.a(paramThrowable.getMessage());
        this.jdField_a_of_type_Zxt.a(943001);
        this.jdField_a_of_type_Zxs.failed(this.jdField_a_of_type_Zxt);
      }
      return;
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart encode cost: " + (l - this.jdField_a_of_type_Long) + " ms mGpuBlur:" + zxy.a(this.jdField_a_of_type_Zxy));
    }
    if (this.jdField_a_of_type_Zxs != null) {
      this.jdField_a_of_type_Zxs.success(this.jdField_a_of_type_Zxt);
    }
    if (zxy.a(this.jdField_a_of_type_Zxy) != null)
    {
      zxy.a(this.jdField_a_of_type_Zxy).surfaceDestroyed();
      zxy.a(this.jdField_a_of_type_Zxy, null);
    }
    if (zxy.a(this.jdField_a_of_type_Zxy) != null)
    {
      zxy.a(this.jdField_a_of_type_Zxy).c();
      zxy.a(this.jdField_a_of_type_Zxy, null);
    }
    if (zxy.a(this.jdField_a_of_type_Zxy) != null) {
      zxy.a(this.jdField_a_of_type_Zxy).clear();
    }
    synchronized (this.jdField_a_of_type_Zxy)
    {
      this.jdField_a_of_type_Zxy.notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
    if ((!a()) && (zxy.a(this.jdField_a_of_type_Zxy) != null)) {
      zxy.a(this.jdField_a_of_type_Zxy).b();
    }
  }
  
  public void onEncodeStart()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (!zxy.a(this.jdField_a_of_type_Zxy)) {}
      for (int i = zxy.a(this.jdField_a_of_type_Zxy, localBitmap, zxy.a(this.jdField_a_of_type_Zxy), zxy.b(this.jdField_a_of_type_Zxy));; i = zxy.b(this.jdField_a_of_type_Zxy, localBitmap, zxy.a(this.jdField_a_of_type_Zxy), zxy.b(this.jdField_a_of_type_Zxy)))
      {
        zxy.a(this.jdField_a_of_type_Zxy).add(Integer.valueOf(i));
        break;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + zxy.a(this.jdField_a_of_type_Zxy));
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxz
 * JD-Core Version:    0.7.0.1
 */
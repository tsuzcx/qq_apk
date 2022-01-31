import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class xho
  implements avzk
{
  public long a;
  
  xho(xhn paramxhn, List paramList, xhh paramxhh, xhi paramxhi) {}
  
  private boolean a()
  {
    boolean bool2 = false;
    int i;
    if (xhn.a(this.jdField_a_of_type_Xhn).size() == 1) {
      i = 0;
    }
    int j;
    do
    {
      long l = 1000000 * xhn.c(this.jdField_a_of_type_Xhn);
      boolean bool1 = bool2;
      if (xhn.a(this.jdField_a_of_type_Xhn) != null)
      {
        bool1 = bool2;
        if (((Integer)xhn.a(this.jdField_a_of_type_Xhn).get(i)).intValue() > 0)
        {
          bool1 = bool2;
          if (xhn.a(this.jdField_a_of_type_Xhn) < xhn.b(this.jdField_a_of_type_Xhn) * 1000000L)
          {
            xhn.a(this.jdField_a_of_type_Xhn).a(3553, ((Integer)xhn.a(this.jdField_a_of_type_Xhn).get(0)).intValue(), null, null, xhn.a(this.jdField_a_of_type_Xhn));
            xhn.a(this.jdField_a_of_type_Xhn, xhn.a(this.jdField_a_of_type_Xhn) + l);
            bool1 = true;
          }
        }
      }
      return bool1;
      j = (int)(xhn.a(this.jdField_a_of_type_Xhn) / (Long.valueOf("2").longValue() * 1000L * 1000000L));
      i = j;
    } while (j < xhn.a(this.jdField_a_of_type_Xhn).size());
    return false;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (!xhn.a(this.jdField_a_of_type_Xhn)) {}
      for (int i = xhn.a(this.jdField_a_of_type_Xhn, localBitmap, xhn.a(this.jdField_a_of_type_Xhn), xhn.b(this.jdField_a_of_type_Xhn));; i = xhn.b(this.jdField_a_of_type_Xhn, localBitmap, xhn.a(this.jdField_a_of_type_Xhn), xhn.b(this.jdField_a_of_type_Xhn)))
      {
        xhn.a(this.jdField_a_of_type_Xhn).add(Integer.valueOf(i));
        break;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + xhn.a(this.jdField_a_of_type_Xhn));
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
  }
  
  public void a(String arg1)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart encode cost: " + (l - this.jdField_a_of_type_Long) + " ms mGpuBlur:" + xhn.a(this.jdField_a_of_type_Xhn));
    }
    if (this.jdField_a_of_type_Xhh != null) {
      this.jdField_a_of_type_Xhh.a(this.jdField_a_of_type_Xhi);
    }
    if (xhn.a(this.jdField_a_of_type_Xhn) != null)
    {
      xhn.a(this.jdField_a_of_type_Xhn).surfaceDestroyed();
      xhn.a(this.jdField_a_of_type_Xhn, null);
    }
    if (xhn.a(this.jdField_a_of_type_Xhn) != null)
    {
      xhn.a(this.jdField_a_of_type_Xhn).c();
      xhn.a(this.jdField_a_of_type_Xhn, null);
    }
    if (xhn.a(this.jdField_a_of_type_Xhn) != null) {
      xhn.a(this.jdField_a_of_type_Xhn).clear();
    }
    synchronized (this.jdField_a_of_type_Xhn)
    {
      this.jdField_a_of_type_Xhn.notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MuiltiImageToVideo", 2, "onEncodeError, code:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_Xhn)
    {
      this.jdField_a_of_type_Xhn.notifyAll();
      if (this.jdField_a_of_type_Xhh != null)
      {
        this.jdField_a_of_type_Xhi.a(paramThrowable.getMessage());
        this.jdField_a_of_type_Xhi.a(943001);
        this.jdField_a_of_type_Xhh.b(this.jdField_a_of_type_Xhi);
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
    if ((!a()) && (xhn.a(this.jdField_a_of_type_Xhn) != null)) {
      xhn.a(this.jdField_a_of_type_Xhn).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xho
 * JD-Core Version:    0.7.0.1
 */
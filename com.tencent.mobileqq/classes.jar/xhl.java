import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class xhl
  implements avzm
{
  public long a;
  
  xhl(xhk paramxhk, List paramList, xhe paramxhe, xhf paramxhf) {}
  
  private boolean a()
  {
    boolean bool2 = false;
    int i;
    if (xhk.a(this.jdField_a_of_type_Xhk).size() == 1) {
      i = 0;
    }
    int j;
    do
    {
      long l = 1000000 * xhk.c(this.jdField_a_of_type_Xhk);
      boolean bool1 = bool2;
      if (xhk.a(this.jdField_a_of_type_Xhk) != null)
      {
        bool1 = bool2;
        if (((Integer)xhk.a(this.jdField_a_of_type_Xhk).get(i)).intValue() > 0)
        {
          bool1 = bool2;
          if (xhk.a(this.jdField_a_of_type_Xhk) < xhk.b(this.jdField_a_of_type_Xhk) * 1000000L)
          {
            xhk.a(this.jdField_a_of_type_Xhk).a(3553, ((Integer)xhk.a(this.jdField_a_of_type_Xhk).get(0)).intValue(), null, null, xhk.a(this.jdField_a_of_type_Xhk));
            xhk.a(this.jdField_a_of_type_Xhk, xhk.a(this.jdField_a_of_type_Xhk) + l);
            bool1 = true;
          }
        }
      }
      return bool1;
      j = (int)(xhk.a(this.jdField_a_of_type_Xhk) / (Long.valueOf("2").longValue() * 1000L * 1000000L));
      i = j;
    } while (j < xhk.a(this.jdField_a_of_type_Xhk).size());
    return false;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (!xhk.a(this.jdField_a_of_type_Xhk)) {}
      for (int i = xhk.a(this.jdField_a_of_type_Xhk, localBitmap, xhk.a(this.jdField_a_of_type_Xhk), xhk.b(this.jdField_a_of_type_Xhk));; i = xhk.b(this.jdField_a_of_type_Xhk, localBitmap, xhk.a(this.jdField_a_of_type_Xhk), xhk.b(this.jdField_a_of_type_Xhk)))
      {
        xhk.a(this.jdField_a_of_type_Xhk).add(Integer.valueOf(i));
        break;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + xhk.a(this.jdField_a_of_type_Xhk));
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
  }
  
  public void a(String arg1)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart encode cost: " + (l - this.jdField_a_of_type_Long) + " ms mGpuBlur:" + xhk.a(this.jdField_a_of_type_Xhk));
    }
    if (this.jdField_a_of_type_Xhe != null) {
      this.jdField_a_of_type_Xhe.a(this.jdField_a_of_type_Xhf);
    }
    if (xhk.a(this.jdField_a_of_type_Xhk) != null)
    {
      xhk.a(this.jdField_a_of_type_Xhk).surfaceDestroyed();
      xhk.a(this.jdField_a_of_type_Xhk, null);
    }
    if (xhk.a(this.jdField_a_of_type_Xhk) != null)
    {
      xhk.a(this.jdField_a_of_type_Xhk).c();
      xhk.a(this.jdField_a_of_type_Xhk, null);
    }
    if (xhk.a(this.jdField_a_of_type_Xhk) != null) {
      xhk.a(this.jdField_a_of_type_Xhk).clear();
    }
    synchronized (this.jdField_a_of_type_Xhk)
    {
      this.jdField_a_of_type_Xhk.notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MuiltiImageToVideo", 2, "onEncodeError, code:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_Xhk)
    {
      this.jdField_a_of_type_Xhk.notifyAll();
      if (this.jdField_a_of_type_Xhe != null)
      {
        this.jdField_a_of_type_Xhf.a(paramThrowable.getMessage());
        this.jdField_a_of_type_Xhf.a(943001);
        this.jdField_a_of_type_Xhe.b(this.jdField_a_of_type_Xhf);
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
    if ((!a()) && (xhk.a(this.jdField_a_of_type_Xhk) != null)) {
      xhk.a(this.jdField_a_of_type_Xhk).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xhl
 * JD-Core Version:    0.7.0.1
 */
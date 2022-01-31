import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class zat
  implements axvu
{
  public long a;
  
  zat(zas paramzas, List paramList, zam paramzam, zan paramzan) {}
  
  private boolean a()
  {
    boolean bool2 = false;
    int i;
    if (zas.a(this.jdField_a_of_type_Zas).size() == 1) {
      i = 0;
    }
    int j;
    do
    {
      long l = 1000000 * zas.c(this.jdField_a_of_type_Zas);
      boolean bool1 = bool2;
      if (zas.a(this.jdField_a_of_type_Zas) != null)
      {
        bool1 = bool2;
        if (((Integer)zas.a(this.jdField_a_of_type_Zas).get(i)).intValue() > 0)
        {
          bool1 = bool2;
          if (zas.a(this.jdField_a_of_type_Zas) < zas.b(this.jdField_a_of_type_Zas) * 1000000L)
          {
            zas.a(this.jdField_a_of_type_Zas).a(3553, ((Integer)zas.a(this.jdField_a_of_type_Zas).get(0)).intValue(), null, null, zas.a(this.jdField_a_of_type_Zas));
            zas.a(this.jdField_a_of_type_Zas, zas.a(this.jdField_a_of_type_Zas) + l);
            bool1 = true;
          }
        }
      }
      return bool1;
      j = (int)(zas.a(this.jdField_a_of_type_Zas) / (Long.valueOf("2").longValue() * 1000L * 1000000L));
      i = j;
    } while (j < zas.a(this.jdField_a_of_type_Zas).size());
    return false;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (!zas.a(this.jdField_a_of_type_Zas)) {}
      for (int i = zas.a(this.jdField_a_of_type_Zas, localBitmap, zas.a(this.jdField_a_of_type_Zas), zas.b(this.jdField_a_of_type_Zas));; i = zas.b(this.jdField_a_of_type_Zas, localBitmap, zas.a(this.jdField_a_of_type_Zas), zas.b(this.jdField_a_of_type_Zas)))
      {
        zas.a(this.jdField_a_of_type_Zas).add(Integer.valueOf(i));
        break;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + zas.a(this.jdField_a_of_type_Zas));
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
  }
  
  public void a(String arg1)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart encode cost: " + (l - this.jdField_a_of_type_Long) + " ms mGpuBlur:" + zas.a(this.jdField_a_of_type_Zas));
    }
    if (this.jdField_a_of_type_Zam != null) {
      this.jdField_a_of_type_Zam.a(this.jdField_a_of_type_Zan);
    }
    if (zas.a(this.jdField_a_of_type_Zas) != null)
    {
      zas.a(this.jdField_a_of_type_Zas).surfaceDestroyed();
      zas.a(this.jdField_a_of_type_Zas, null);
    }
    if (zas.a(this.jdField_a_of_type_Zas) != null)
    {
      zas.a(this.jdField_a_of_type_Zas).c();
      zas.a(this.jdField_a_of_type_Zas, null);
    }
    if (zas.a(this.jdField_a_of_type_Zas) != null) {
      zas.a(this.jdField_a_of_type_Zas).clear();
    }
    synchronized (this.jdField_a_of_type_Zas)
    {
      this.jdField_a_of_type_Zas.notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MuiltiImageToVideo", 2, "onEncodeError, code:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_Zas)
    {
      this.jdField_a_of_type_Zas.notifyAll();
      if (this.jdField_a_of_type_Zam != null)
      {
        this.jdField_a_of_type_Zan.a(paramThrowable.getMessage());
        this.jdField_a_of_type_Zan.a(943001);
        this.jdField_a_of_type_Zam.b(this.jdField_a_of_type_Zan);
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
    if ((!a()) && (zas.a(this.jdField_a_of_type_Zas) != null)) {
      zas.a(this.jdField_a_of_type_Zas).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zat
 * JD-Core Version:    0.7.0.1
 */
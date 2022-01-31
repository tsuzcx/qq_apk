import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ywe
  implements axrl
{
  public long a;
  
  ywe(ywd paramywd, List paramList, yvx paramyvx, yvy paramyvy) {}
  
  private boolean a()
  {
    boolean bool2 = false;
    int i;
    if (ywd.a(this.jdField_a_of_type_Ywd).size() == 1) {
      i = 0;
    }
    int j;
    do
    {
      long l = 1000000 * ywd.c(this.jdField_a_of_type_Ywd);
      boolean bool1 = bool2;
      if (ywd.a(this.jdField_a_of_type_Ywd) != null)
      {
        bool1 = bool2;
        if (((Integer)ywd.a(this.jdField_a_of_type_Ywd).get(i)).intValue() > 0)
        {
          bool1 = bool2;
          if (ywd.a(this.jdField_a_of_type_Ywd) < ywd.b(this.jdField_a_of_type_Ywd) * 1000000L)
          {
            ywd.a(this.jdField_a_of_type_Ywd).a(3553, ((Integer)ywd.a(this.jdField_a_of_type_Ywd).get(0)).intValue(), null, null, ywd.a(this.jdField_a_of_type_Ywd));
            ywd.a(this.jdField_a_of_type_Ywd, ywd.a(this.jdField_a_of_type_Ywd) + l);
            bool1 = true;
          }
        }
      }
      return bool1;
      j = (int)(ywd.a(this.jdField_a_of_type_Ywd) / (Long.valueOf("2").longValue() * 1000L * 1000000L));
      i = j;
    } while (j < ywd.a(this.jdField_a_of_type_Ywd).size());
    return false;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (!ywd.a(this.jdField_a_of_type_Ywd)) {}
      for (int i = ywd.a(this.jdField_a_of_type_Ywd, localBitmap, ywd.a(this.jdField_a_of_type_Ywd), ywd.b(this.jdField_a_of_type_Ywd));; i = ywd.b(this.jdField_a_of_type_Ywd, localBitmap, ywd.a(this.jdField_a_of_type_Ywd), ywd.b(this.jdField_a_of_type_Ywd)))
      {
        ywd.a(this.jdField_a_of_type_Ywd).add(Integer.valueOf(i));
        break;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + ywd.a(this.jdField_a_of_type_Ywd));
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
  }
  
  public void a(String arg1)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart encode cost: " + (l - this.jdField_a_of_type_Long) + " ms mGpuBlur:" + ywd.a(this.jdField_a_of_type_Ywd));
    }
    if (this.jdField_a_of_type_Yvx != null) {
      this.jdField_a_of_type_Yvx.a(this.jdField_a_of_type_Yvy);
    }
    if (ywd.a(this.jdField_a_of_type_Ywd) != null)
    {
      ywd.a(this.jdField_a_of_type_Ywd).surfaceDestroyed();
      ywd.a(this.jdField_a_of_type_Ywd, null);
    }
    if (ywd.a(this.jdField_a_of_type_Ywd) != null)
    {
      ywd.a(this.jdField_a_of_type_Ywd).c();
      ywd.a(this.jdField_a_of_type_Ywd, null);
    }
    if (ywd.a(this.jdField_a_of_type_Ywd) != null) {
      ywd.a(this.jdField_a_of_type_Ywd).clear();
    }
    synchronized (this.jdField_a_of_type_Ywd)
    {
      this.jdField_a_of_type_Ywd.notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MuiltiImageToVideo", 2, "onEncodeError, code:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_Ywd)
    {
      this.jdField_a_of_type_Ywd.notifyAll();
      if (this.jdField_a_of_type_Yvx != null)
      {
        this.jdField_a_of_type_Yvy.a(paramThrowable.getMessage());
        this.jdField_a_of_type_Yvy.a(943001);
        this.jdField_a_of_type_Yvx.b(this.jdField_a_of_type_Yvy);
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
    if ((!a()) && (ywd.a(this.jdField_a_of_type_Ywd) != null)) {
      ywd.a(this.jdField_a_of_type_Ywd).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ywe
 * JD-Core Version:    0.7.0.1
 */
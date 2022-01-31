import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class wyo
  implements auzr
{
  public long a;
  
  wyo(wyn paramwyn, List paramList, wyh paramwyh, wyi paramwyi) {}
  
  private boolean a()
  {
    boolean bool2 = false;
    int i;
    if (wyn.a(this.jdField_a_of_type_Wyn).size() == 1) {
      i = 0;
    }
    int j;
    do
    {
      long l = 1000000 * wyn.c(this.jdField_a_of_type_Wyn);
      boolean bool1 = bool2;
      if (wyn.a(this.jdField_a_of_type_Wyn) != null)
      {
        bool1 = bool2;
        if (((Integer)wyn.a(this.jdField_a_of_type_Wyn).get(i)).intValue() > 0)
        {
          bool1 = bool2;
          if (wyn.a(this.jdField_a_of_type_Wyn) < wyn.b(this.jdField_a_of_type_Wyn) * 1000000L)
          {
            wyn.a(this.jdField_a_of_type_Wyn).a(3553, ((Integer)wyn.a(this.jdField_a_of_type_Wyn).get(0)).intValue(), null, null, wyn.a(this.jdField_a_of_type_Wyn));
            wyn.a(this.jdField_a_of_type_Wyn, wyn.a(this.jdField_a_of_type_Wyn) + l);
            bool1 = true;
          }
        }
      }
      return bool1;
      j = (int)(wyn.a(this.jdField_a_of_type_Wyn) / (Long.valueOf("2").longValue() * 1000L * 1000000L));
      i = j;
    } while (j < wyn.a(this.jdField_a_of_type_Wyn).size());
    return false;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (!wyn.a(this.jdField_a_of_type_Wyn)) {}
      for (int i = wyn.a(this.jdField_a_of_type_Wyn, localBitmap, wyn.a(this.jdField_a_of_type_Wyn), wyn.b(this.jdField_a_of_type_Wyn));; i = wyn.b(this.jdField_a_of_type_Wyn, localBitmap, wyn.a(this.jdField_a_of_type_Wyn), wyn.b(this.jdField_a_of_type_Wyn)))
      {
        wyn.a(this.jdField_a_of_type_Wyn).add(Integer.valueOf(i));
        break;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + wyn.a(this.jdField_a_of_type_Wyn));
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
  }
  
  public void a(String arg1)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart encode cost: " + (l - this.jdField_a_of_type_Long) + " ms mGpuBlur:" + wyn.a(this.jdField_a_of_type_Wyn));
    }
    if (this.jdField_a_of_type_Wyh != null) {
      this.jdField_a_of_type_Wyh.a(this.jdField_a_of_type_Wyi);
    }
    if (wyn.a(this.jdField_a_of_type_Wyn) != null)
    {
      wyn.a(this.jdField_a_of_type_Wyn).surfaceDestroyed();
      wyn.a(this.jdField_a_of_type_Wyn, null);
    }
    if (wyn.a(this.jdField_a_of_type_Wyn) != null)
    {
      wyn.a(this.jdField_a_of_type_Wyn).c();
      wyn.a(this.jdField_a_of_type_Wyn, null);
    }
    if (wyn.a(this.jdField_a_of_type_Wyn) != null) {
      wyn.a(this.jdField_a_of_type_Wyn).clear();
    }
    synchronized (this.jdField_a_of_type_Wyn)
    {
      this.jdField_a_of_type_Wyn.notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MuiltiImageToVideo", 2, "onEncodeError, code:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_Wyn)
    {
      this.jdField_a_of_type_Wyn.notifyAll();
      if (this.jdField_a_of_type_Wyh != null)
      {
        this.jdField_a_of_type_Wyi.a(paramThrowable.getMessage());
        this.jdField_a_of_type_Wyi.a(943001);
        this.jdField_a_of_type_Wyh.b(this.jdField_a_of_type_Wyi);
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
    if ((!a()) && (wyn.a(this.jdField_a_of_type_Wyn) != null)) {
      wyn.a(this.jdField_a_of_type_Wyn).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyo
 * JD-Core Version:    0.7.0.1
 */
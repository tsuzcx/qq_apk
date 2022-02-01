import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class squ
  implements amal
{
  public long Ck;
  
  squ(sqt paramsqt, List paramList, sqo.a parama, sqo.b paramb) {}
  
  private boolean LH()
  {
    boolean bool2 = false;
    int i;
    if (sqt.a(this.jdField_b_of_type_Sqt).size() == 1) {
      i = 0;
    }
    int j;
    do
    {
      long l = 1000000 * sqt.c(this.jdField_b_of_type_Sqt);
      boolean bool1 = bool2;
      if (sqt.a(this.jdField_b_of_type_Sqt) != null)
      {
        bool1 = bool2;
        if (((Integer)sqt.a(this.jdField_b_of_type_Sqt).get(i)).intValue() > 0)
        {
          bool1 = bool2;
          if (sqt.a(this.jdField_b_of_type_Sqt) < sqt.b(this.jdField_b_of_type_Sqt) * 1000000L)
          {
            sqt.a(this.jdField_b_of_type_Sqt).f(3553, ((Integer)sqt.a(this.jdField_b_of_type_Sqt).get(0)).intValue(), null, null, sqt.a(this.jdField_b_of_type_Sqt));
            sqt.a(this.jdField_b_of_type_Sqt, sqt.a(this.jdField_b_of_type_Sqt) + l);
            bool1 = true;
          }
        }
      }
      return bool1;
      j = (int)(sqt.a(this.jdField_b_of_type_Sqt) / (Long.valueOf("2").longValue() * 1000L * 1000000L));
      i = j;
    } while (j < sqt.a(this.jdField_b_of_type_Sqt).size());
    return false;
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MuiltiImageToVideo", 2, "onEncodeError, code:" + paramInt);
    }
    synchronized (this.jdField_b_of_type_Sqt)
    {
      this.jdField_b_of_type_Sqt.notifyAll();
      if (this.jdField_b_of_type_Sqo$a != null)
      {
        this.jdField_b_of_type_Sqo$b.setMessage(paramThrowable.getMessage());
        this.jdField_b_of_type_Sqo$b.setCode(943001);
        this.jdField_b_of_type_Sqo$a.b(this.jdField_b_of_type_Sqo$b);
      }
      return;
    }
  }
  
  public void auv()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.pz.iterator();
    if (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (!sqt.a(this.jdField_b_of_type_Sqt)) {}
      for (int i = sqt.a(this.jdField_b_of_type_Sqt, localBitmap, sqt.a(this.jdField_b_of_type_Sqt), sqt.b(this.jdField_b_of_type_Sqt));; i = sqt.b(this.jdField_b_of_type_Sqt, localBitmap, sqt.a(this.jdField_b_of_type_Sqt), sqt.b(this.jdField_b_of_type_Sqt)))
      {
        sqt.a(this.jdField_b_of_type_Sqt).add(Integer.valueOf(i));
        break;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + sqt.a(this.jdField_b_of_type_Sqt));
    }
    this.Ck = System.currentTimeMillis();
    LH();
  }
  
  public void btD()
  {
    QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
    if ((!LH()) && (sqt.a(this.jdField_b_of_type_Sqt) != null)) {
      sqt.a(this.jdField_b_of_type_Sqt).stopRecording();
    }
  }
  
  public void kf(String arg1)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart encode cost: " + (l - this.Ck) + " ms mGpuBlur:" + sqt.a(this.jdField_b_of_type_Sqt));
    }
    if (this.jdField_b_of_type_Sqo$a != null) {
      this.jdField_b_of_type_Sqo$a.a(this.jdField_b_of_type_Sqo$b);
    }
    if (sqt.a(this.jdField_b_of_type_Sqt) != null)
    {
      sqt.a(this.jdField_b_of_type_Sqt).surfaceDestroyed();
      sqt.a(this.jdField_b_of_type_Sqt, null);
    }
    if (sqt.a(this.jdField_b_of_type_Sqt) != null)
    {
      sqt.a(this.jdField_b_of_type_Sqt).release();
      sqt.a(this.jdField_b_of_type_Sqt, null);
    }
    if (sqt.a(this.jdField_b_of_type_Sqt) != null) {
      sqt.a(this.jdField_b_of_type_Sqt).clear();
    }
    synchronized (this.jdField_b_of_type_Sqt)
    {
      this.jdField_b_of_type_Sqt.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     squ
 * JD-Core Version:    0.7.0.1
 */
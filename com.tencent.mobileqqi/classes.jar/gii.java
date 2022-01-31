import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.service.HttpNotify;

public class gii
  implements HttpNotify
{
  private long jdField_a_of_type_Long = 0L;
  private HttpNotify jdField_a_of_type_ComTencentMobileqqServiceHttpNotify;
  
  public gii(HttpNotify paramHttpNotify)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceHttpNotify = paramHttpNotify;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new gij(this, paramLong1, paramLong2));
      return;
    }
    b(paramLong1, paramLong2);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 200L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new gik(this, paramLong1, paramLong2, paramLong3));
      return;
    }
    b(paramLong1, paramLong2, paramLong3);
  }
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new gil(this, paramLong1, paramBoolean, paramLong2));
      return;
    }
    b(paramLong1, paramBoolean, paramLong2);
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceHttpNotify.a(paramLong1, paramLong2);
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceHttpNotify.a(paramLong1, paramLong2, paramLong3);
  }
  
  public void b(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceHttpNotify.a(paramLong1, paramBoolean, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gii
 * JD-Core Version:    0.7.0.1
 */
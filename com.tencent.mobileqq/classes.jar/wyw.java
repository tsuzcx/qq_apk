import android.os.Looper;
import android.os.Message;

public class wyw
{
  private int jdField_a_of_type_Int = -1;
  protected wyv a;
  private wyy jdField_a_of_type_Wyy = new wyy(this, Looper.getMainLooper());
  
  public void a()
  {
    this.jdField_a_of_type_Wyy.removeCallbacks(null);
    this.jdField_a_of_type_Wyv = null;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Wyy);
    localMessage.what = 7;
    localMessage.obj = new wyx(paramLong);
    localMessage.sendToTarget();
  }
  
  public void a(wyv paramwyv)
  {
    this.jdField_a_of_type_Wyv = paramwyv;
  }
  
  public void b()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Wyy);
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  protected void b(long paramLong)
  {
    if (this.jdField_a_of_type_Wyv != null) {
      this.jdField_a_of_type_Wyv.a(paramLong);
    }
  }
  
  public void c()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Wyy);
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
  
  protected void c(long paramLong)
  {
    a(3);
    if (this.jdField_a_of_type_Wyv != null) {
      this.jdField_a_of_type_Wyv.a(paramLong);
    }
  }
  
  protected void d()
  {
    a(3);
    if (this.jdField_a_of_type_Wyv != null) {}
  }
  
  protected void e()
  {
    a(4);
    if (this.jdField_a_of_type_Wyv != null) {}
  }
  
  protected void f()
  {
    a(5);
    if (this.jdField_a_of_type_Wyv != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyw
 * JD-Core Version:    0.7.0.1
 */
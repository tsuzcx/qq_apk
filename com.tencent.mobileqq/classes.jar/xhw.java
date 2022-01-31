import android.os.Looper;
import android.os.Message;

public class xhw
{
  private int jdField_a_of_type_Int = -1;
  protected xhv a;
  private xhy jdField_a_of_type_Xhy = new xhy(this, Looper.getMainLooper());
  
  public void a()
  {
    this.jdField_a_of_type_Xhy.removeCallbacks(null);
    this.jdField_a_of_type_Xhv = null;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Xhy);
    localMessage.what = 7;
    localMessage.obj = new xhx(paramLong);
    localMessage.sendToTarget();
  }
  
  public void a(xhv paramxhv)
  {
    this.jdField_a_of_type_Xhv = paramxhv;
  }
  
  public void b()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Xhy);
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  protected void b(long paramLong)
  {
    if (this.jdField_a_of_type_Xhv != null) {
      this.jdField_a_of_type_Xhv.a(paramLong);
    }
  }
  
  public void c()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Xhy);
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
  
  protected void c(long paramLong)
  {
    a(3);
    if (this.jdField_a_of_type_Xhv != null) {
      this.jdField_a_of_type_Xhv.a(paramLong);
    }
  }
  
  protected void d()
  {
    a(3);
    if (this.jdField_a_of_type_Xhv != null) {}
  }
  
  protected void e()
  {
    a(4);
    if (this.jdField_a_of_type_Xhv != null) {}
  }
  
  protected void f()
  {
    a(5);
    if (this.jdField_a_of_type_Xhv != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xhw
 * JD-Core Version:    0.7.0.1
 */
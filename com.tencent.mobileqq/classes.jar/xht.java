import android.os.Looper;
import android.os.Message;

public class xht
{
  private int jdField_a_of_type_Int = -1;
  protected xhs a;
  private xhv jdField_a_of_type_Xhv = new xhv(this, Looper.getMainLooper());
  
  public void a()
  {
    this.jdField_a_of_type_Xhv.removeCallbacks(null);
    this.jdField_a_of_type_Xhs = null;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Xhv);
    localMessage.what = 7;
    localMessage.obj = new xhu(paramLong);
    localMessage.sendToTarget();
  }
  
  public void a(xhs paramxhs)
  {
    this.jdField_a_of_type_Xhs = paramxhs;
  }
  
  public void b()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Xhv);
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  protected void b(long paramLong)
  {
    if (this.jdField_a_of_type_Xhs != null) {
      this.jdField_a_of_type_Xhs.a(paramLong);
    }
  }
  
  public void c()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Xhv);
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
  
  protected void c(long paramLong)
  {
    a(3);
    if (this.jdField_a_of_type_Xhs != null) {
      this.jdField_a_of_type_Xhs.a(paramLong);
    }
  }
  
  protected void d()
  {
    a(3);
    if (this.jdField_a_of_type_Xhs != null) {}
  }
  
  protected void e()
  {
    a(4);
    if (this.jdField_a_of_type_Xhs != null) {}
  }
  
  protected void f()
  {
    a(5);
    if (this.jdField_a_of_type_Xhs != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xht
 * JD-Core Version:    0.7.0.1
 */
import android.os.Looper;
import android.os.Message;

public class ywm
{
  private int jdField_a_of_type_Int = -1;
  protected ywl a;
  private ywo jdField_a_of_type_Ywo = new ywo(this, Looper.getMainLooper());
  
  public void a()
  {
    this.jdField_a_of_type_Ywo.removeCallbacks(null);
    this.jdField_a_of_type_Ywl = null;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Ywo);
    localMessage.what = 7;
    localMessage.obj = new ywn(paramLong);
    localMessage.sendToTarget();
  }
  
  public void a(ywl paramywl)
  {
    this.jdField_a_of_type_Ywl = paramywl;
  }
  
  public void b()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Ywo);
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  protected void b(long paramLong)
  {
    if (this.jdField_a_of_type_Ywl != null) {
      this.jdField_a_of_type_Ywl.a(paramLong);
    }
  }
  
  public void c()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Ywo);
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
  
  protected void c(long paramLong)
  {
    a(3);
    if (this.jdField_a_of_type_Ywl != null) {
      this.jdField_a_of_type_Ywl.a(paramLong);
    }
  }
  
  protected void d()
  {
    a(3);
    if (this.jdField_a_of_type_Ywl != null) {}
  }
  
  protected void e()
  {
    a(4);
    if (this.jdField_a_of_type_Ywl != null) {}
  }
  
  protected void f()
  {
    a(5);
    if (this.jdField_a_of_type_Ywl != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ywm
 * JD-Core Version:    0.7.0.1
 */
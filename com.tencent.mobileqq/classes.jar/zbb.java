import android.os.Looper;
import android.os.Message;

public class zbb
{
  private int jdField_a_of_type_Int = -1;
  protected zba a;
  private zbd jdField_a_of_type_Zbd = new zbd(this, Looper.getMainLooper());
  
  public void a()
  {
    this.jdField_a_of_type_Zbd.removeCallbacks(null);
    this.jdField_a_of_type_Zba = null;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Zbd);
    localMessage.what = 7;
    localMessage.obj = new zbc(paramLong);
    localMessage.sendToTarget();
  }
  
  public void a(zba paramzba)
  {
    this.jdField_a_of_type_Zba = paramzba;
  }
  
  public void b()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Zbd);
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  protected void b(long paramLong)
  {
    if (this.jdField_a_of_type_Zba != null) {
      this.jdField_a_of_type_Zba.a(paramLong);
    }
  }
  
  public void c()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Zbd);
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
  
  protected void c(long paramLong)
  {
    a(3);
    if (this.jdField_a_of_type_Zba != null) {
      this.jdField_a_of_type_Zba.a(paramLong);
    }
  }
  
  protected void d()
  {
    a(3);
    if (this.jdField_a_of_type_Zba != null) {}
  }
  
  protected void e()
  {
    a(4);
    if (this.jdField_a_of_type_Zba != null) {}
  }
  
  protected void f()
  {
    a(5);
    if (this.jdField_a_of_type_Zba != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zbb
 * JD-Core Version:    0.7.0.1
 */
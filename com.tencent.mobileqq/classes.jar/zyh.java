import android.os.Looper;
import android.os.Message;

public class zyh
{
  private int jdField_a_of_type_Int = -1;
  protected zyg a;
  private zyj jdField_a_of_type_Zyj = new zyj(this, Looper.getMainLooper());
  
  public void a()
  {
    this.jdField_a_of_type_Zyj.removeCallbacks(null);
    this.jdField_a_of_type_Zyg = null;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Zyj);
    localMessage.what = 7;
    localMessage.obj = new zyi(paramLong);
    localMessage.sendToTarget();
  }
  
  public void a(zyg paramzyg)
  {
    this.jdField_a_of_type_Zyg = paramzyg;
  }
  
  public void b()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Zyj);
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  protected void b(long paramLong)
  {
    if (this.jdField_a_of_type_Zyg != null) {
      this.jdField_a_of_type_Zyg.a(paramLong);
    }
  }
  
  public void c()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Zyj);
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
  
  protected void c(long paramLong)
  {
    a(3);
    if (this.jdField_a_of_type_Zyg != null) {
      this.jdField_a_of_type_Zyg.a(paramLong);
    }
  }
  
  protected void d()
  {
    a(3);
    if (this.jdField_a_of_type_Zyg != null) {}
  }
  
  protected void e()
  {
    a(4);
    if (this.jdField_a_of_type_Zyg != null) {}
  }
  
  protected void f()
  {
    a(5);
    if (this.jdField_a_of_type_Zyg != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyh
 * JD-Core Version:    0.7.0.1
 */
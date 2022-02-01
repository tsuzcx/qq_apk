import android.view.MotionEvent;
import android.view.View;

public class zqt
  implements zqr
{
  protected final zqv a;
  protected final zqx a;
  
  public zqt(zqx paramzqx)
  {
    this.jdField_a_of_type_Zqv = new zqv();
    this.jdField_a_of_type_Zqx = paramzqx;
  }
  
  public void a(zqr paramzqr) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    View localView = this.jdField_a_of_type_Zqx.a();
    zqs localzqs = this.jdField_a_of_type_Zqx.jdField_a_of_type_Zqs;
    if (!localzqs.a(localView, this.jdField_a_of_type_Zqv, paramMotionEvent)) {}
    zqw localzqw;
    do
    {
      return false;
      localzqw = this.jdField_a_of_type_Zqx.jdField_a_of_type_Zqw;
    } while (((!localzqs.a(localView)) || (!this.jdField_a_of_type_Zqv.jdField_a_of_type_Boolean)) && ((!localzqs.b(localView)) || (this.jdField_a_of_type_Zqv.jdField_a_of_type_Boolean)));
    localzqw.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
    localzqw.jdField_a_of_type_Float = this.jdField_a_of_type_Zqv.jdField_a_of_type_Float;
    localzqw.jdField_a_of_type_Boolean = this.jdField_a_of_type_Zqv.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Zqx.a(this.jdField_a_of_type_Zqx.jdField_a_of_type_Zqy);
    return this.jdField_a_of_type_Zqx.jdField_a_of_type_Zqy.a(paramMotionEvent);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqt
 * JD-Core Version:    0.7.0.1
 */
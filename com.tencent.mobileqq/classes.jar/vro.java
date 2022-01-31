import android.view.MotionEvent;
import android.view.View;

public class vro
  implements vrm
{
  protected final vrq a;
  protected final vrs a;
  
  public vro(vrs paramvrs)
  {
    this.jdField_a_of_type_Vrq = new vrq();
    this.jdField_a_of_type_Vrs = paramvrs;
  }
  
  public void a(vrm paramvrm) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    View localView = this.jdField_a_of_type_Vrs.a();
    vrn localvrn = this.jdField_a_of_type_Vrs.jdField_a_of_type_Vrn;
    if (!localvrn.a(localView, this.jdField_a_of_type_Vrq, paramMotionEvent)) {}
    vrr localvrr;
    do
    {
      return false;
      localvrr = this.jdField_a_of_type_Vrs.jdField_a_of_type_Vrr;
    } while (((!localvrn.a(localView)) || (!this.jdField_a_of_type_Vrq.jdField_a_of_type_Boolean)) && ((!localvrn.b(localView)) || (this.jdField_a_of_type_Vrq.jdField_a_of_type_Boolean)));
    localvrr.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
    localvrr.jdField_a_of_type_Float = this.jdField_a_of_type_Vrq.jdField_a_of_type_Float;
    localvrr.jdField_a_of_type_Boolean = this.jdField_a_of_type_Vrq.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Vrs.a(this.jdField_a_of_type_Vrs.jdField_a_of_type_Vrt);
    return this.jdField_a_of_type_Vrs.jdField_a_of_type_Vrt.a(paramMotionEvent);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vro
 * JD-Core Version:    0.7.0.1
 */
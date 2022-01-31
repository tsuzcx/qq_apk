import android.view.MotionEvent;
import android.view.View;

public class xsz
  implements xsx
{
  protected final xtb a;
  protected final xtd a;
  
  public xsz(xtd paramxtd)
  {
    this.jdField_a_of_type_Xtb = new xtb();
    this.jdField_a_of_type_Xtd = paramxtd;
  }
  
  public void a(xsx paramxsx) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    View localView = this.jdField_a_of_type_Xtd.a();
    xsy localxsy = this.jdField_a_of_type_Xtd.jdField_a_of_type_Xsy;
    if (!localxsy.a(localView, this.jdField_a_of_type_Xtb, paramMotionEvent)) {}
    xtc localxtc;
    do
    {
      return false;
      localxtc = this.jdField_a_of_type_Xtd.jdField_a_of_type_Xtc;
    } while (((!localxsy.a(localView)) || (!this.jdField_a_of_type_Xtb.jdField_a_of_type_Boolean)) && ((!localxsy.b(localView)) || (this.jdField_a_of_type_Xtb.jdField_a_of_type_Boolean)));
    localxtc.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
    localxtc.jdField_a_of_type_Float = this.jdField_a_of_type_Xtb.jdField_a_of_type_Float;
    localxtc.jdField_a_of_type_Boolean = this.jdField_a_of_type_Xtb.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Xtd.a(this.jdField_a_of_type_Xtd.jdField_a_of_type_Xte);
    return this.jdField_a_of_type_Xtd.jdField_a_of_type_Xte.a(paramMotionEvent);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xsz
 * JD-Core Version:    0.7.0.1
 */
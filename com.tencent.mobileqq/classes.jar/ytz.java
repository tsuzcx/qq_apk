import android.view.MotionEvent;
import android.view.View;

public class ytz
  implements ytx
{
  protected final yub a;
  protected final yud a;
  
  public ytz(yud paramyud)
  {
    this.jdField_a_of_type_Yub = new yub();
    this.jdField_a_of_type_Yud = paramyud;
  }
  
  public void a(ytx paramytx) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    View localView = this.jdField_a_of_type_Yud.a();
    yty localyty = this.jdField_a_of_type_Yud.jdField_a_of_type_Yty;
    if (!localyty.a(localView, this.jdField_a_of_type_Yub, paramMotionEvent)) {}
    yuc localyuc;
    do
    {
      return false;
      localyuc = this.jdField_a_of_type_Yud.jdField_a_of_type_Yuc;
    } while (((!localyty.a(localView)) || (!this.jdField_a_of_type_Yub.jdField_a_of_type_Boolean)) && ((!localyty.b(localView)) || (this.jdField_a_of_type_Yub.jdField_a_of_type_Boolean)));
    localyuc.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
    localyuc.jdField_a_of_type_Float = this.jdField_a_of_type_Yub.jdField_a_of_type_Float;
    localyuc.jdField_a_of_type_Boolean = this.jdField_a_of_type_Yub.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Yud.a(this.jdField_a_of_type_Yud.jdField_a_of_type_Yue);
    return this.jdField_a_of_type_Yud.jdField_a_of_type_Yue.a(paramMotionEvent);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytz
 * JD-Core Version:    0.7.0.1
 */
import android.view.MotionEvent;
import android.view.View;

public class wek
  implements wei
{
  protected final wem a;
  protected final weo a;
  
  public wek(weo paramweo)
  {
    this.jdField_a_of_type_Wem = new wem();
    this.jdField_a_of_type_Weo = paramweo;
  }
  
  public void a(wei paramwei) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    View localView = this.jdField_a_of_type_Weo.a();
    wej localwej = this.jdField_a_of_type_Weo.jdField_a_of_type_Wej;
    if (!localwej.a(localView, this.jdField_a_of_type_Wem, paramMotionEvent)) {}
    wen localwen;
    do
    {
      return false;
      localwen = this.jdField_a_of_type_Weo.jdField_a_of_type_Wen;
    } while (((!localwej.a(localView)) || (!this.jdField_a_of_type_Wem.jdField_a_of_type_Boolean)) && ((!localwej.b(localView)) || (this.jdField_a_of_type_Wem.jdField_a_of_type_Boolean)));
    localwen.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
    localwen.jdField_a_of_type_Float = this.jdField_a_of_type_Wem.jdField_a_of_type_Float;
    localwen.jdField_a_of_type_Boolean = this.jdField_a_of_type_Wem.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Weo.a(this.jdField_a_of_type_Weo.jdField_a_of_type_Wep);
    return this.jdField_a_of_type_Weo.jdField_a_of_type_Wep.a(paramMotionEvent);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wek
 * JD-Core Version:    0.7.0.1
 */
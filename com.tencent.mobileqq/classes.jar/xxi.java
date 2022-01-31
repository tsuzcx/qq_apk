import android.view.MotionEvent;
import android.view.View;

public class xxi
  implements xxg
{
  protected final xxk a;
  protected final xxm a;
  
  public xxi(xxm paramxxm)
  {
    this.jdField_a_of_type_Xxk = new xxk();
    this.jdField_a_of_type_Xxm = paramxxm;
  }
  
  public void a(xxg paramxxg) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    View localView = this.jdField_a_of_type_Xxm.a();
    xxh localxxh = this.jdField_a_of_type_Xxm.jdField_a_of_type_Xxh;
    if (!localxxh.a(localView, this.jdField_a_of_type_Xxk, paramMotionEvent)) {}
    xxl localxxl;
    do
    {
      return false;
      localxxl = this.jdField_a_of_type_Xxm.jdField_a_of_type_Xxl;
    } while (((!localxxh.a(localView)) || (!this.jdField_a_of_type_Xxk.jdField_a_of_type_Boolean)) && ((!localxxh.b(localView)) || (this.jdField_a_of_type_Xxk.jdField_a_of_type_Boolean)));
    localxxl.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
    localxxl.jdField_a_of_type_Float = this.jdField_a_of_type_Xxk.jdField_a_of_type_Float;
    localxxl.jdField_a_of_type_Boolean = this.jdField_a_of_type_Xxk.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Xxm.a(this.jdField_a_of_type_Xxm.jdField_a_of_type_Xxn);
    return this.jdField_a_of_type_Xxm.jdField_a_of_type_Xxn.a(paramMotionEvent);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xxi
 * JD-Core Version:    0.7.0.1
 */
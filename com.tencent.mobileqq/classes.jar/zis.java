import android.view.MotionEvent;
import android.view.View;

public class zis
  implements ziq
{
  protected final ziu a;
  protected final ziw a;
  
  public zis(ziw paramziw)
  {
    this.jdField_a_of_type_Ziu = new ziu();
    this.jdField_a_of_type_Ziw = paramziw;
  }
  
  public void a(ziq paramziq) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    View localView = this.jdField_a_of_type_Ziw.a();
    zir localzir = this.jdField_a_of_type_Ziw.jdField_a_of_type_Zir;
    if (!localzir.a(localView, this.jdField_a_of_type_Ziu, paramMotionEvent)) {}
    ziv localziv;
    do
    {
      return false;
      localziv = this.jdField_a_of_type_Ziw.jdField_a_of_type_Ziv;
    } while (((!localzir.a(localView)) || (!this.jdField_a_of_type_Ziu.jdField_a_of_type_Boolean)) && ((!localzir.b(localView)) || (this.jdField_a_of_type_Ziu.jdField_a_of_type_Boolean)));
    localziv.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
    localziv.jdField_a_of_type_Float = this.jdField_a_of_type_Ziu.jdField_a_of_type_Float;
    localziv.jdField_a_of_type_Boolean = this.jdField_a_of_type_Ziu.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Ziw.a(this.jdField_a_of_type_Ziw.jdField_a_of_type_Zix);
    return this.jdField_a_of_type_Ziw.jdField_a_of_type_Zix.a(paramMotionEvent);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zis
 * JD-Core Version:    0.7.0.1
 */
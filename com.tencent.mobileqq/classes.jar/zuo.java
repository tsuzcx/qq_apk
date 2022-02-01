import android.view.MotionEvent;
import android.view.View;

public class zuo
  implements zum
{
  protected final zuq a;
  protected final zus a;
  
  public zuo(zus paramzus)
  {
    this.jdField_a_of_type_Zuq = new zuq();
    this.jdField_a_of_type_Zus = paramzus;
  }
  
  public void a(zum paramzum) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    View localView = this.jdField_a_of_type_Zus.a();
    zun localzun = this.jdField_a_of_type_Zus.jdField_a_of_type_Zun;
    if (!localzun.a(localView, this.jdField_a_of_type_Zuq, paramMotionEvent)) {}
    zur localzur;
    do
    {
      return false;
      localzur = this.jdField_a_of_type_Zus.jdField_a_of_type_Zur;
    } while (((!localzun.a(localView)) || (!this.jdField_a_of_type_Zuq.jdField_a_of_type_Boolean)) && ((!localzun.b(localView)) || (this.jdField_a_of_type_Zuq.jdField_a_of_type_Boolean)));
    localzur.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
    localzur.jdField_a_of_type_Float = this.jdField_a_of_type_Zuq.jdField_a_of_type_Float;
    localzur.jdField_a_of_type_Boolean = this.jdField_a_of_type_Zuq.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Zus.a(this.jdField_a_of_type_Zus.jdField_a_of_type_Zut);
    return this.jdField_a_of_type_Zus.jdField_a_of_type_Zut.a(paramMotionEvent);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zuo
 * JD-Core Version:    0.7.0.1
 */
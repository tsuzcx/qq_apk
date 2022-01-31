import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class wep
  implements wei
{
  protected final float a;
  protected int a;
  protected final wem a;
  protected final weo a;
  protected final float b;
  
  public wep(weo paramweo, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Weo = paramweo;
    this.jdField_a_of_type_Wem = new wem();
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(wei paramwei)
  {
    if (this.jdField_a_of_type_Weo.jdField_a_of_type_Wen.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    wen localwen = this.jdField_a_of_type_Weo.jdField_a_of_type_Wen;
    if (localwen.jdField_a_of_type_Int != paramMotionEvent.getPointerId(0)) {
      this.jdField_a_of_type_Weo.a(this.jdField_a_of_type_Weo.jdField_a_of_type_Weh);
    }
    View localView;
    wej localwej;
    do
    {
      return true;
      localView = this.jdField_a_of_type_Weo.a();
      localwej = this.jdField_a_of_type_Weo.jdField_a_of_type_Wej;
    } while (!localwej.a(localView, this.jdField_a_of_type_Wem, paramMotionEvent));
    float f2 = this.jdField_a_of_type_Wem.b;
    if (this.jdField_a_of_type_Wem.jdField_a_of_type_Boolean == localwen.jdField_a_of_type_Boolean) {}
    for (float f1 = this.jdField_a_of_type_Float;; f1 = this.b)
    {
      f1 = f2 / f1;
      f2 = this.jdField_a_of_type_Wem.jdField_a_of_type_Float + f1;
      if (((!localwen.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Wem.jdField_a_of_type_Boolean) || (f2 > localwen.jdField_a_of_type_Float)) && ((localwen.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_Wem.jdField_a_of_type_Boolean) || (f2 < localwen.jdField_a_of_type_Float))) {
        break;
      }
      localwej.a(localView, localwen.jdField_a_of_type_Float, paramMotionEvent);
      this.jdField_a_of_type_Weo.a(this.jdField_a_of_type_Weo.jdField_a_of_type_Wek);
      return true;
    }
    if (localView.getParent() != null) {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
    if (l > 0L) {
      this.jdField_a_of_type_Weo.jdField_a_of_type_Float = (f1 / (float)l);
    }
    localwej.a(localView, f2);
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Weo.a(this.jdField_a_of_type_Weo.jdField_a_of_type_Weh);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wep
 * JD-Core Version:    0.7.0.1
 */
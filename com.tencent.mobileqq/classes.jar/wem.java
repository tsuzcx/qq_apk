import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class wem
  implements wef
{
  protected final float a;
  protected int a;
  protected final wej a;
  protected final wel a;
  protected final float b;
  
  public wem(wel paramwel, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Wel = paramwel;
    this.jdField_a_of_type_Wej = new wej();
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(wef paramwef)
  {
    if (this.jdField_a_of_type_Wel.jdField_a_of_type_Wek.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    wek localwek = this.jdField_a_of_type_Wel.jdField_a_of_type_Wek;
    if (localwek.jdField_a_of_type_Int != paramMotionEvent.getPointerId(0)) {
      this.jdField_a_of_type_Wel.a(this.jdField_a_of_type_Wel.jdField_a_of_type_Wee);
    }
    View localView;
    weg localweg;
    do
    {
      return true;
      localView = this.jdField_a_of_type_Wel.a();
      localweg = this.jdField_a_of_type_Wel.jdField_a_of_type_Weg;
    } while (!localweg.a(localView, this.jdField_a_of_type_Wej, paramMotionEvent));
    float f2 = this.jdField_a_of_type_Wej.b;
    if (this.jdField_a_of_type_Wej.jdField_a_of_type_Boolean == localwek.jdField_a_of_type_Boolean) {}
    for (float f1 = this.jdField_a_of_type_Float;; f1 = this.b)
    {
      f1 = f2 / f1;
      f2 = this.jdField_a_of_type_Wej.jdField_a_of_type_Float + f1;
      if (((!localwek.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Wej.jdField_a_of_type_Boolean) || (f2 > localwek.jdField_a_of_type_Float)) && ((localwek.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_Wej.jdField_a_of_type_Boolean) || (f2 < localwek.jdField_a_of_type_Float))) {
        break;
      }
      localweg.a(localView, localwek.jdField_a_of_type_Float, paramMotionEvent);
      this.jdField_a_of_type_Wel.a(this.jdField_a_of_type_Wel.jdField_a_of_type_Weh);
      return true;
    }
    if (localView.getParent() != null) {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
    if (l > 0L) {
      this.jdField_a_of_type_Wel.jdField_a_of_type_Float = (f1 / (float)l);
    }
    localweg.a(localView, f2);
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Wel.a(this.jdField_a_of_type_Wel.jdField_a_of_type_Wee);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wem
 * JD-Core Version:    0.7.0.1
 */
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class vrt
  implements vrm
{
  protected final float a;
  protected int a;
  protected final vrq a;
  protected final vrs a;
  protected final float b;
  
  public vrt(vrs paramvrs, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Vrs = paramvrs;
    this.jdField_a_of_type_Vrq = new vrq();
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(vrm paramvrm)
  {
    if (this.jdField_a_of_type_Vrs.jdField_a_of_type_Vrr.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    vrr localvrr = this.jdField_a_of_type_Vrs.jdField_a_of_type_Vrr;
    if (localvrr.jdField_a_of_type_Int != paramMotionEvent.getPointerId(0)) {
      this.jdField_a_of_type_Vrs.a(this.jdField_a_of_type_Vrs.jdField_a_of_type_Vrl);
    }
    View localView;
    vrn localvrn;
    do
    {
      return true;
      localView = this.jdField_a_of_type_Vrs.a();
      localvrn = this.jdField_a_of_type_Vrs.jdField_a_of_type_Vrn;
    } while (!localvrn.a(localView, this.jdField_a_of_type_Vrq, paramMotionEvent));
    float f2 = this.jdField_a_of_type_Vrq.b;
    if (this.jdField_a_of_type_Vrq.jdField_a_of_type_Boolean == localvrr.jdField_a_of_type_Boolean) {}
    for (float f1 = this.jdField_a_of_type_Float;; f1 = this.b)
    {
      f1 = f2 / f1;
      f2 = this.jdField_a_of_type_Vrq.jdField_a_of_type_Float + f1;
      if (((!localvrr.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Vrq.jdField_a_of_type_Boolean) || (f2 > localvrr.jdField_a_of_type_Float)) && ((localvrr.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_Vrq.jdField_a_of_type_Boolean) || (f2 < localvrr.jdField_a_of_type_Float))) {
        break;
      }
      localvrn.a(localView, localvrr.jdField_a_of_type_Float, paramMotionEvent);
      this.jdField_a_of_type_Vrs.a(this.jdField_a_of_type_Vrs.jdField_a_of_type_Vro);
      return true;
    }
    if (localView.getParent() != null) {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
    if (l > 0L) {
      this.jdField_a_of_type_Vrs.jdField_a_of_type_Float = (f1 / (float)l);
    }
    localvrn.a(localView, f2);
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Vrs.a(this.jdField_a_of_type_Vrs.jdField_a_of_type_Vrl);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vrt
 * JD-Core Version:    0.7.0.1
 */
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class xte
  implements xsx
{
  protected final float a;
  protected int a;
  protected final xtb a;
  protected final xtd a;
  protected final float b;
  
  public xte(xtd paramxtd, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Xtd = paramxtd;
    this.jdField_a_of_type_Xtb = new xtb();
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(xsx paramxsx)
  {
    if (this.jdField_a_of_type_Xtd.jdField_a_of_type_Xtc.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    xtc localxtc = this.jdField_a_of_type_Xtd.jdField_a_of_type_Xtc;
    if (localxtc.jdField_a_of_type_Int != paramMotionEvent.getPointerId(0)) {
      this.jdField_a_of_type_Xtd.a(this.jdField_a_of_type_Xtd.jdField_a_of_type_Xsw);
    }
    View localView;
    xsy localxsy;
    do
    {
      return true;
      localView = this.jdField_a_of_type_Xtd.a();
      localxsy = this.jdField_a_of_type_Xtd.jdField_a_of_type_Xsy;
    } while (!localxsy.a(localView, this.jdField_a_of_type_Xtb, paramMotionEvent));
    float f2 = this.jdField_a_of_type_Xtb.b;
    if (this.jdField_a_of_type_Xtb.jdField_a_of_type_Boolean == localxtc.jdField_a_of_type_Boolean) {}
    for (float f1 = this.jdField_a_of_type_Float;; f1 = this.b)
    {
      f1 = f2 / f1;
      f2 = this.jdField_a_of_type_Xtb.jdField_a_of_type_Float + f1;
      if (((!localxtc.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Xtb.jdField_a_of_type_Boolean) || (f2 > localxtc.jdField_a_of_type_Float)) && ((localxtc.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_Xtb.jdField_a_of_type_Boolean) || (f2 < localxtc.jdField_a_of_type_Float))) {
        break;
      }
      localxsy.a(localView, localxtc.jdField_a_of_type_Float, paramMotionEvent);
      this.jdField_a_of_type_Xtd.a(this.jdField_a_of_type_Xtd.jdField_a_of_type_Xsz);
      return true;
    }
    if (localView.getParent() != null) {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
    if (l > 0L) {
      this.jdField_a_of_type_Xtd.jdField_a_of_type_Float = (f1 / (float)l);
    }
    localxsy.a(localView, f2);
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Xtd.a(this.jdField_a_of_type_Xtd.jdField_a_of_type_Xsw);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xte
 * JD-Core Version:    0.7.0.1
 */
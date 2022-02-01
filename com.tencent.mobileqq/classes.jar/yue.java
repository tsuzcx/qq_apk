import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class yue
  implements ytx
{
  public float a;
  protected int a;
  protected final yub a;
  protected final yud a;
  public float b;
  
  public yue(yud paramyud, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Yud = paramyud;
    this.jdField_a_of_type_Yub = new yub();
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(ytx paramytx)
  {
    if (this.jdField_a_of_type_Yud.jdField_a_of_type_Yuc.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    yuc localyuc = this.jdField_a_of_type_Yud.jdField_a_of_type_Yuc;
    if (localyuc.jdField_a_of_type_Int != paramMotionEvent.getPointerId(0)) {
      this.jdField_a_of_type_Yud.a(this.jdField_a_of_type_Yud.jdField_a_of_type_Ytw);
    }
    View localView;
    yty localyty;
    do
    {
      return true;
      localView = this.jdField_a_of_type_Yud.a();
      localyty = this.jdField_a_of_type_Yud.jdField_a_of_type_Yty;
    } while (!localyty.a(localView, this.jdField_a_of_type_Yub, paramMotionEvent));
    float f2 = this.jdField_a_of_type_Yub.b;
    if (this.jdField_a_of_type_Yub.jdField_a_of_type_Boolean == localyuc.jdField_a_of_type_Boolean) {}
    for (float f1 = this.jdField_a_of_type_Float;; f1 = this.b)
    {
      f1 = f2 / f1;
      f2 = this.jdField_a_of_type_Yub.jdField_a_of_type_Float + f1;
      if (((!localyuc.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Yub.jdField_a_of_type_Boolean) || (f2 > localyuc.jdField_a_of_type_Float)) && ((localyuc.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_Yub.jdField_a_of_type_Boolean) || (f2 < localyuc.jdField_a_of_type_Float))) {
        break;
      }
      localyty.a(localView, localyuc.jdField_a_of_type_Float, paramMotionEvent);
      this.jdField_a_of_type_Yud.a(this.jdField_a_of_type_Yud.jdField_a_of_type_Ytz);
      return true;
    }
    if (localView.getParent() != null) {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
    if (l > 0L) {
      this.jdField_a_of_type_Yud.jdField_a_of_type_Float = (f1 / (float)l);
    }
    localyty.a(localView, f2);
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Yud.a(this.jdField_a_of_type_Yud.jdField_a_of_type_Ytw);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yue
 * JD-Core Version:    0.7.0.1
 */
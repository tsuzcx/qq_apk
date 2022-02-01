import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class zut
  implements zum
{
  public float a;
  protected int a;
  protected final zuq a;
  protected final zus a;
  public float b;
  
  public zut(zus paramzus, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Zus = paramzus;
    this.jdField_a_of_type_Zuq = new zuq();
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(zum paramzum)
  {
    if (this.jdField_a_of_type_Zus.jdField_a_of_type_Zur.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    zur localzur = this.jdField_a_of_type_Zus.jdField_a_of_type_Zur;
    if (localzur.jdField_a_of_type_Int != paramMotionEvent.getPointerId(0)) {
      this.jdField_a_of_type_Zus.a(this.jdField_a_of_type_Zus.jdField_a_of_type_Zul);
    }
    View localView;
    zun localzun;
    do
    {
      return true;
      localView = this.jdField_a_of_type_Zus.a();
      localzun = this.jdField_a_of_type_Zus.jdField_a_of_type_Zun;
    } while (!localzun.a(localView, this.jdField_a_of_type_Zuq, paramMotionEvent));
    float f2 = this.jdField_a_of_type_Zuq.b;
    if (this.jdField_a_of_type_Zuq.jdField_a_of_type_Boolean == localzur.jdField_a_of_type_Boolean) {}
    for (float f1 = this.jdField_a_of_type_Float;; f1 = this.b)
    {
      f1 = f2 / f1;
      f2 = this.jdField_a_of_type_Zuq.jdField_a_of_type_Float + f1;
      if (((!localzur.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Zuq.jdField_a_of_type_Boolean) || (f2 > localzur.jdField_a_of_type_Float)) && ((localzur.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_Zuq.jdField_a_of_type_Boolean) || (f2 < localzur.jdField_a_of_type_Float))) {
        break;
      }
      localzun.a(localView, localzur.jdField_a_of_type_Float, paramMotionEvent);
      this.jdField_a_of_type_Zus.a(this.jdField_a_of_type_Zus.jdField_a_of_type_Zuo);
      return true;
    }
    if (localView.getParent() != null) {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
    if (l > 0L) {
      this.jdField_a_of_type_Zus.jdField_a_of_type_Float = (f1 / (float)l);
    }
    localzun.a(localView, f2);
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Zus.a(this.jdField_a_of_type_Zus.jdField_a_of_type_Zul);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zut
 * JD-Core Version:    0.7.0.1
 */
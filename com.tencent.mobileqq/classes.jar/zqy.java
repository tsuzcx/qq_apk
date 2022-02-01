import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class zqy
  implements zqr
{
  public float a;
  protected int a;
  protected final zqv a;
  protected final zqx a;
  public float b;
  
  public zqy(zqx paramzqx, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Zqx = paramzqx;
    this.jdField_a_of_type_Zqv = new zqv();
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(zqr paramzqr)
  {
    if (this.jdField_a_of_type_Zqx.jdField_a_of_type_Zqw.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    zqw localzqw = this.jdField_a_of_type_Zqx.jdField_a_of_type_Zqw;
    if (localzqw.jdField_a_of_type_Int != paramMotionEvent.getPointerId(0)) {
      this.jdField_a_of_type_Zqx.a(this.jdField_a_of_type_Zqx.jdField_a_of_type_Zqq);
    }
    View localView;
    zqs localzqs;
    do
    {
      return true;
      localView = this.jdField_a_of_type_Zqx.a();
      localzqs = this.jdField_a_of_type_Zqx.jdField_a_of_type_Zqs;
    } while (!localzqs.a(localView, this.jdField_a_of_type_Zqv, paramMotionEvent));
    float f2 = this.jdField_a_of_type_Zqv.b;
    if (this.jdField_a_of_type_Zqv.jdField_a_of_type_Boolean == localzqw.jdField_a_of_type_Boolean) {}
    for (float f1 = this.jdField_a_of_type_Float;; f1 = this.b)
    {
      f1 = f2 / f1;
      f2 = this.jdField_a_of_type_Zqv.jdField_a_of_type_Float + f1;
      if (((!localzqw.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Zqv.jdField_a_of_type_Boolean) || (f2 > localzqw.jdField_a_of_type_Float)) && ((localzqw.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_Zqv.jdField_a_of_type_Boolean) || (f2 < localzqw.jdField_a_of_type_Float))) {
        break;
      }
      localzqs.a(localView, localzqw.jdField_a_of_type_Float, paramMotionEvent);
      this.jdField_a_of_type_Zqx.a(this.jdField_a_of_type_Zqx.jdField_a_of_type_Zqt);
      return true;
    }
    if (localView.getParent() != null) {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
    if (l > 0L) {
      this.jdField_a_of_type_Zqx.jdField_a_of_type_Float = (f1 / (float)l);
    }
    localzqs.a(localView, f2);
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Zqx.a(this.jdField_a_of_type_Zqx.jdField_a_of_type_Zqq);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqy
 * JD-Core Version:    0.7.0.1
 */
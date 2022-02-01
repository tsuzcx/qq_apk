import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class zix
  implements ziq
{
  public float a;
  protected int a;
  protected final ziu a;
  protected final ziw a;
  public float b;
  
  public zix(ziw paramziw, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Ziw = paramziw;
    this.jdField_a_of_type_Ziu = new ziu();
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(ziq paramziq)
  {
    if (this.jdField_a_of_type_Ziw.jdField_a_of_type_Ziv.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    ziv localziv = this.jdField_a_of_type_Ziw.jdField_a_of_type_Ziv;
    if (localziv.jdField_a_of_type_Int != paramMotionEvent.getPointerId(0)) {
      this.jdField_a_of_type_Ziw.a(this.jdField_a_of_type_Ziw.jdField_a_of_type_Zip);
    }
    View localView;
    zir localzir;
    do
    {
      return true;
      localView = this.jdField_a_of_type_Ziw.a();
      localzir = this.jdField_a_of_type_Ziw.jdField_a_of_type_Zir;
    } while (!localzir.a(localView, this.jdField_a_of_type_Ziu, paramMotionEvent));
    float f2 = this.jdField_a_of_type_Ziu.b;
    if (this.jdField_a_of_type_Ziu.jdField_a_of_type_Boolean == localziv.jdField_a_of_type_Boolean) {}
    for (float f1 = this.jdField_a_of_type_Float;; f1 = this.b)
    {
      f1 = f2 / f1;
      f2 = this.jdField_a_of_type_Ziu.jdField_a_of_type_Float + f1;
      if (((!localziv.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Ziu.jdField_a_of_type_Boolean) || (f2 > localziv.jdField_a_of_type_Float)) && ((localziv.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_Ziu.jdField_a_of_type_Boolean) || (f2 < localziv.jdField_a_of_type_Float))) {
        break;
      }
      localzir.a(localView, localziv.jdField_a_of_type_Float, paramMotionEvent);
      this.jdField_a_of_type_Ziw.a(this.jdField_a_of_type_Ziw.jdField_a_of_type_Zis);
      return true;
    }
    if (localView.getParent() != null) {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
    if (l > 0L) {
      this.jdField_a_of_type_Ziw.jdField_a_of_type_Float = (f1 / (float)l);
    }
    localzir.a(localView, f2);
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Ziw.a(this.jdField_a_of_type_Ziw.jdField_a_of_type_Zip);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zix
 * JD-Core Version:    0.7.0.1
 */
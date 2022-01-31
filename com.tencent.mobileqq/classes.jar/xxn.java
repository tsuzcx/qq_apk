import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class xxn
  implements xxg
{
  protected final float a;
  protected int a;
  protected final xxk a;
  protected final xxm a;
  protected final float b;
  
  public xxn(xxm paramxxm, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Xxm = paramxxm;
    this.jdField_a_of_type_Xxk = new xxk();
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(xxg paramxxg)
  {
    if (this.jdField_a_of_type_Xxm.jdField_a_of_type_Xxl.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    xxl localxxl = this.jdField_a_of_type_Xxm.jdField_a_of_type_Xxl;
    if (localxxl.jdField_a_of_type_Int != paramMotionEvent.getPointerId(0)) {
      this.jdField_a_of_type_Xxm.a(this.jdField_a_of_type_Xxm.jdField_a_of_type_Xxf);
    }
    View localView;
    xxh localxxh;
    do
    {
      return true;
      localView = this.jdField_a_of_type_Xxm.a();
      localxxh = this.jdField_a_of_type_Xxm.jdField_a_of_type_Xxh;
    } while (!localxxh.a(localView, this.jdField_a_of_type_Xxk, paramMotionEvent));
    float f2 = this.jdField_a_of_type_Xxk.b;
    if (this.jdField_a_of_type_Xxk.jdField_a_of_type_Boolean == localxxl.jdField_a_of_type_Boolean) {}
    for (float f1 = this.jdField_a_of_type_Float;; f1 = this.b)
    {
      f1 = f2 / f1;
      f2 = this.jdField_a_of_type_Xxk.jdField_a_of_type_Float + f1;
      if (((!localxxl.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Xxk.jdField_a_of_type_Boolean) || (f2 > localxxl.jdField_a_of_type_Float)) && ((localxxl.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_Xxk.jdField_a_of_type_Boolean) || (f2 < localxxl.jdField_a_of_type_Float))) {
        break;
      }
      localxxh.a(localView, localxxl.jdField_a_of_type_Float, paramMotionEvent);
      this.jdField_a_of_type_Xxm.a(this.jdField_a_of_type_Xxm.jdField_a_of_type_Xxi);
      return true;
    }
    if (localView.getParent() != null) {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
    if (l > 0L) {
      this.jdField_a_of_type_Xxm.jdField_a_of_type_Float = (f1 / (float)l);
    }
    localxxh.a(localView, f2);
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Xxm.a(this.jdField_a_of_type_Xxm.jdField_a_of_type_Xxf);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xxn
 * JD-Core Version:    0.7.0.1
 */
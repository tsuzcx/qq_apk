import android.view.MotionEvent;
import android.view.View;

public class wel
  implements wej
{
  protected int a = 1;
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(View paramView, float paramFloat)
  {
    if (this.a == 1)
    {
      paramView.setTranslationY(paramFloat);
      return;
    }
    paramView.setTranslationX(paramFloat);
  }
  
  public void a(View paramView, float paramFloat, MotionEvent paramMotionEvent)
  {
    if (this.a == 1)
    {
      paramView.setTranslationY(paramFloat);
      paramMotionEvent.offsetLocation(0.0F, paramFloat - paramMotionEvent.getY(0));
      return;
    }
    paramView.setTranslationX(paramFloat);
    paramMotionEvent.offsetLocation(paramFloat - paramMotionEvent.getX(0), 0.0F);
  }
  
  public void a(View paramView, weg paramweg)
  {
    if (this.a == 1)
    {
      paramweg.jdField_a_of_type_AndroidUtilProperty = View.TRANSLATION_Y;
      paramweg.jdField_a_of_type_Float = paramView.getTranslationY();
      paramweg.b = paramView.getHeight();
      return;
    }
    paramweg.jdField_a_of_type_AndroidUtilProperty = View.TRANSLATION_X;
    paramweg.jdField_a_of_type_Float = paramView.getTranslationX();
    paramweg.b = paramView.getWidth();
  }
  
  public boolean a(View paramView)
  {
    if (this.a == 1) {
      if (paramView.canScrollVertically(-1)) {}
    }
    while (!paramView.canScrollHorizontally(-1))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean a(View paramView, wem paramwem, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramMotionEvent.getHistorySize() == 0) {}
    float f1;
    float f2;
    do
    {
      return false;
      f1 = paramMotionEvent.getY(0) - paramMotionEvent.getHistoricalY(0, 0);
      f2 = paramMotionEvent.getX(0) - paramMotionEvent.getHistoricalX(0, 0);
      if (this.a != 1) {
        break;
      }
    } while (Math.abs(f1) < Math.abs(f2));
    paramwem.jdField_a_of_type_Float = paramView.getTranslationY();
    paramwem.b = f1;
    if (paramwem.b > 0.0F) {
      bool1 = true;
    }
    for (paramwem.jdField_a_of_type_Boolean = bool1;; paramwem.jdField_a_of_type_Boolean = bool1)
    {
      return true;
      if (Math.abs(f2) < Math.abs(f1)) {
        break;
      }
      paramwem.jdField_a_of_type_Float = paramView.getTranslationX();
      paramwem.b = f2;
      bool1 = bool2;
      if (paramwem.b > 0.0F) {
        bool1 = true;
      }
    }
  }
  
  public boolean b(View paramView)
  {
    if (this.a == 1) {
      if (paramView.canScrollVertically(1)) {}
    }
    while (!paramView.canScrollHorizontally(1))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wel
 * JD-Core Version:    0.7.0.1
 */
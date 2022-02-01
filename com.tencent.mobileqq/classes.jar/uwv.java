import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class uwv
  implements View.OnTouchListener
{
  uwv(uwt paramuwt, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    uwt.a(this.jdField_a_of_type_Uwt, paramView);
    this.jdField_a_of_type_Uwt.d = this.jdField_a_of_type_Int;
    uwt.a(this.jdField_a_of_type_Uwt).onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwv
 * JD-Core Version:    0.7.0.1
 */
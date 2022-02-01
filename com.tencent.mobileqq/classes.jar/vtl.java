import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class vtl
  implements View.OnTouchListener
{
  vtl(vtj paramvtj, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    vtj.a(this.jdField_a_of_type_Vtj, paramView);
    this.jdField_a_of_type_Vtj.d = this.jdField_a_of_type_Int;
    vtj.a(this.jdField_a_of_type_Vtj).onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtl
 * JD-Core Version:    0.7.0.1
 */
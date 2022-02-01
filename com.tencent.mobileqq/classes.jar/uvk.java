import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class uvk
  implements View.OnTouchListener
{
  uvk(uvi paramuvi, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    uvi.a(this.jdField_a_of_type_Uvi, paramView);
    this.jdField_a_of_type_Uvi.d = this.jdField_a_of_type_Int;
    uvi.a(this.jdField_a_of_type_Uvi).onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvk
 * JD-Core Version:    0.7.0.1
 */
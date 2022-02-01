import android.app.Activity;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class tvu
  implements View.OnTouchListener
{
  tvu(tvr paramtvr, tvq paramtvq, boolean paramBoolean) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_Tvr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.a.getResources().getColor(2131166073));
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Tvr.c.setBackgroundResource(2130843164);
        return false;
      }
      this.jdField_a_of_type_Tvr.c.setBackgroundResource(2130843165);
      return false;
    }
    this.jdField_a_of_type_Tvr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.a.getResources().getColor(2131166072));
    this.jdField_a_of_type_Tvr.c.setBackgroundResource(2130843173);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvu
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class tvw
  implements View.OnTouchListener
{
  tvw(tvt paramtvt, tvs paramtvs, boolean paramBoolean) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_Tvt.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Tvt.jdField_a_of_type_Tvs.a.getResources().getColor(2131166074));
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Tvt.c.setBackgroundResource(2130843182);
        return false;
      }
      this.jdField_a_of_type_Tvt.c.setBackgroundResource(2130843183);
      return false;
    }
    this.jdField_a_of_type_Tvt.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Tvt.jdField_a_of_type_Tvs.a.getResources().getColor(2131166073));
    this.jdField_a_of_type_Tvt.c.setBackgroundResource(2130843191);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvw
 * JD-Core Version:    0.7.0.1
 */
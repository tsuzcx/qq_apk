import android.app.Activity;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class ucm
  implements View.OnTouchListener
{
  ucm(ucj paramucj, uci paramuci, boolean paramBoolean) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_Ucj.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.a.getResources().getColor(2131166093));
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Ucj.c.setBackgroundResource(2130843244);
        return false;
      }
      this.jdField_a_of_type_Ucj.c.setBackgroundResource(2130843245);
      return false;
    }
    this.jdField_a_of_type_Ucj.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.a.getResources().getColor(2131166092));
    this.jdField_a_of_type_Ucj.c.setBackgroundResource(2130843253);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ucm
 * JD-Core Version:    0.7.0.1
 */
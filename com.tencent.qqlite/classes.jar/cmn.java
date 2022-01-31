import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;

public class cmn
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float = 0.0F;
  float b = 0.0F;
  
  public cmn(SelectMemberActivity paramSelectMemberActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.b = paramMotionEvent.getRawY();
    }
    while ((i != 2) || ((paramMotionEvent.getRawX() - this.jdField_a_of_type_Float <= 10.0F) && (paramMotionEvent.getRawY() - this.b <= 10.0F))) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cmn
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

class dqz
  implements Runnable
{
  dqz(dqy paramdqy) {}
  
  public void run()
  {
    TroopMemberListActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, false);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getWindow().peekDecorView().getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dqz
 * JD-Core Version:    0.7.0.1
 */
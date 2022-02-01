import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;

class chw
  implements Runnable
{
  chw(chv paramchv) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getWindow().peekDecorView().getWindowToken(), 0);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     chw
 * JD-Core Version:    0.7.0.1
 */
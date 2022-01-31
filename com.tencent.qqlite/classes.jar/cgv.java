import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.phone.ContactListView;

public class cgv
  implements Animation.AnimationListener
{
  public cgv(ContactListView paramContactListView, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView.b.setAnimation(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView.b.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView.b.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgv
 * JD-Core Version:    0.7.0.1
 */
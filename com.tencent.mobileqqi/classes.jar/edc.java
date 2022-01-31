import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.contact.CircleMemberListActivity;

public class edc
  implements Animation.AnimationListener
{
  public edc(CircleMemberListActivity paramCircleMemberListActivity, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactCircleMemberListActivity.a.setAnimation(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactCircleMemberListActivity.a.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactCircleMemberListActivity.a.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     edc
 * JD-Core Version:    0.7.0.1
 */
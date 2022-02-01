import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.PublicAccountActivity;

public class dak
  implements Animation.AnimationListener
{
  public dak(PublicAccountActivity paramPublicAccountActivity, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PublicAccountActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountActivity).setAnimation(null);
    PublicAccountActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountActivity).offsetTopAndBottom(this.jdField_a_of_type_Int);
    PublicAccountActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountActivity).requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dak
 * JD-Core Version:    0.7.0.1
 */
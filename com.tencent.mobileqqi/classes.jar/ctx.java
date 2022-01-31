import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class ctx
  implements Animation.AnimationListener
{
  public ctx(FriendProfileImageActivity paramFriendProfileImageActivity, TextView paramTextView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.c) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ctx
 * JD-Core Version:    0.7.0.1
 */
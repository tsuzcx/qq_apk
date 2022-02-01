import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;

class cta
  implements Animation.AnimationListener
{
  cta(csz paramcsz) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.a.a.jdField_a_of_type_AndroidViewView.setAnimation(null);
    this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.invalidate();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cta
 * JD-Core Version:    0.7.0.1
 */
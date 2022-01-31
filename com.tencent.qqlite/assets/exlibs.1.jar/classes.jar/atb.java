import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;

class atb
  implements Animation.AnimationListener
{
  atb(ata paramata) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.a.a.jdField_a_of_type_AndroidViewView.setAnimation(null);
    this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.invalidate();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     atb
 * JD-Core Version:    0.7.0.1
 */
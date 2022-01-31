import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import com.tencent.mobileqq.activity.VisitorsActivity;

public class umy
  implements Runnable
{
  public umy(VisitorsActivity paramVisitorsActivity, ScaleAnimation paramScaleAnimation, AlphaAnimation paramAlphaAnimation1, AlphaAnimation paramAlphaAnimation2, AnimationSet paramAnimationSet) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.reset();
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.reset();
    this.b.reset();
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.reset();
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.f.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     umy
 * JD-Core Version:    0.7.0.1
 */
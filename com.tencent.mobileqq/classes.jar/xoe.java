import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.widgets.TabLayout;

public class xoe
  implements Animator.AnimatorListener
{
  public xoe(TabLayout paramTabLayout, Animator.AnimatorListener paramAnimatorListener) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationCancel(paramAnimator);
    TabLayout.a(this.jdField_a_of_type_ComTencentBizWidgetsTabLayout, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationEnd(paramAnimator);
    TabLayout.a(this.jdField_a_of_type_ComTencentBizWidgetsTabLayout, false);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a();
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationRepeat(paramAnimator);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     xoe
 * JD-Core Version:    0.7.0.1
 */
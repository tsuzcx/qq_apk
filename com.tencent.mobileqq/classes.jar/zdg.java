import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;

final class zdg
  implements Animator.AnimatorListener
{
  zdg(zdh paramzdh, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Zdh != null) {
      this.jdField_a_of_type_Zdh.d(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Zdh != null) {
      this.jdField_a_of_type_Zdh.c(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Zdh != null) {
      this.jdField_a_of_type_Zdh.b(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdg
 * JD-Core Version:    0.7.0.1
 */
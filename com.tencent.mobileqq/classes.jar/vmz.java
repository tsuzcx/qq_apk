import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;

final class vmz
  implements Animator.AnimatorListener
{
  vmz(vna paramvna, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Vna != null) {
      this.jdField_a_of_type_Vna.d(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Vna != null) {
      this.jdField_a_of_type_Vna.c(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Vna != null) {
      this.jdField_a_of_type_Vna.b(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmz
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;

final class vnu
  extends AnimatorListenerAdapter
{
  vnu(Animator.AnimatorListener paramAnimatorListener, ViewGroup paramViewGroup, ImageView paramImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationCancel(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    wsv.b("Q.qqstory.playernew.AnimationUtils", "doEnterAnimation, onAnimationEnd");
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationEnd(paramAnimator);
    paramAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    paramAnimator.setStartDelay(400L);
    paramAnimator.setDuration(400L);
    paramAnimator.addUpdateListener(new vnv(this));
    paramAnimator.addListener(new vnw(this));
    paramAnimator.start();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnu
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;

final class qim
  extends AnimatorListenerAdapter
{
  qim(Animator.AnimatorListener paramAnimatorListener, ViewGroup paramViewGroup, ImageView paramImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    this.val$animatorListener.onAnimationCancel(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ram.d("Q.qqstory.playernew.AnimationUtils", "doEnterAnimation, onAnimationEnd");
    this.co.removeView(this.mH);
    this.val$animatorListener.onAnimationEnd(paramAnimator);
    paramAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    paramAnimator.setStartDelay(400L);
    paramAnimator.setDuration(400L);
    paramAnimator.addUpdateListener(new qin(this));
    paramAnimator.addListener(new qio(this));
    paramAnimator.start();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.val$animatorListener.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qim
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.HorizontalScrollView;

class uwf
  extends AnimatorListenerAdapter
  implements ValueAnimator.AnimatorUpdateListener
{
  private uwf(uwd paramuwd) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    uwd.a(this.a).scrollTo(0, 0);
    uqf.a("WSMarqueeDirector", "onAnimationEnd: ");
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    uwd.a(this.a).scrollTo(0, 0);
    uqf.a("WSMarqueeDirector", "onAnimationStart: ");
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if ((i < 0) || (i > uwd.a(this.a))) {
      return;
    }
    uwd.a(this.a).scrollTo(i, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwf
 * JD-Core Version:    0.7.0.1
 */
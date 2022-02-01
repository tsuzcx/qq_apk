import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.HorizontalScrollView;

class vec
  extends AnimatorListenerAdapter
  implements ValueAnimator.AnimatorUpdateListener
{
  private vec(vea paramvea) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    vea.a(this.a).scrollTo(0, 0);
    uya.a("WSMarqueeDirector", "onAnimationEnd: ");
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    vea.a(this.a).scrollTo(0, 0);
    uya.a("WSMarqueeDirector", "onAnimationStart: ");
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if ((i < 0) || (i > vea.a(this.a))) {
      return;
    }
    vea.a(this.a).scrollTo(i, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vec
 * JD-Core Version:    0.7.0.1
 */
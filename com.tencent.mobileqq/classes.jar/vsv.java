import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.HorizontalScrollView;

class vsv
  extends AnimatorListenerAdapter
  implements ValueAnimator.AnimatorUpdateListener
{
  private vsv(vst paramvst) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    vst.a(this.a).scrollTo(0, 0);
    vmp.a("WSMarqueeDirector", "onAnimationEnd: ");
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    vst.a(this.a).scrollTo(0, 0);
    vmp.a("WSMarqueeDirector", "onAnimationStart: ");
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if ((i < 0) || (i > vst.a(this.a))) {
      return;
    }
    vst.a(this.a).scrollTo(i, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsv
 * JD-Core Version:    0.7.0.1
 */
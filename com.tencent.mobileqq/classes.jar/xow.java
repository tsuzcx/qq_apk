import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;

public class xow
  implements Animator.AnimatorListener
{
  public xow(XViewPager paramXViewPager) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (XViewPager.a(this.a) != null) {
      XViewPager.a(this.a).b(0);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (XViewPager.a(this.a) != null) {
      XViewPager.a(this.a).b(0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xow
 * JD-Core Version:    0.7.0.1
 */
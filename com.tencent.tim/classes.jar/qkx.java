import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.f;

public class qkx
  implements Animator.AnimatorListener
{
  public qkx(XViewPager paramXViewPager) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (XViewPager.a(this.this$0) != null) {
      XViewPager.a(this.this$0).onPageScrollStateChanged(0);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (XViewPager.a(this.this$0) != null) {
      XViewPager.a(this.this$0).onPageScrollStateChanged(0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qkx
 * JD-Core Version:    0.7.0.1
 */
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;

public class ucm
  implements ValueAnimator.AnimatorUpdateListener
{
  public ucm(XViewPager paramXViewPager) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.scrollTo(i, 0);
    XViewPager.a(this.a, i);
    if (XViewPager.a(this.a) != null) {
      XViewPager.a(this.a).b(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucm
 * JD-Core Version:    0.7.0.1
 */
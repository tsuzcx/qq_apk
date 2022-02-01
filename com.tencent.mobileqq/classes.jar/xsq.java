import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;

public class xsq
  implements ValueAnimator.AnimatorUpdateListener
{
  public xsq(XViewPager paramXViewPager) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsq
 * JD-Core Version:    0.7.0.1
 */
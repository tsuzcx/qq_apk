import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;

public class vvk
  implements ValueAnimator.AnimatorUpdateListener
{
  public vvk(XViewPager paramXViewPager) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvk
 * JD-Core Version:    0.7.0.1
 */
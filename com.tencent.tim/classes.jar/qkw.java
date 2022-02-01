import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.f;

public class qkw
  implements ValueAnimator.AnimatorUpdateListener
{
  public qkw(XViewPager paramXViewPager) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.this$0.scrollTo(i, 0);
    XViewPager.a(this.this$0, i);
    if (XViewPager.a(this.this$0) != null) {
      XViewPager.a(this.this$0).onPageScrollStateChanged(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qkw
 * JD-Core Version:    0.7.0.1
 */
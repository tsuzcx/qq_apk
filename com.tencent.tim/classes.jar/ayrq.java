import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SlideBottomPanel;

public class ayrq
  implements ValueAnimator.AnimatorUpdateListener
{
  public ayrq(SlideBottomPanel paramSlideBottomPanel, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if ((paramValueAnimator instanceof Float))
    {
      this.Ei.setY(((Float)paramValueAnimator).floatValue());
      if (this.a.a != null) {
        this.a.a.fadeBackground(1.0F - ((Float)paramValueAnimator).floatValue() / (this.a.bSn - this.a.Gj));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayrq
 * JD-Core Version:    0.7.0.1
 */
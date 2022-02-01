import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SlideBottomPanel;

public class ayro
  implements ValueAnimator.AnimatorUpdateListener
{
  public ayro(SlideBottomPanel paramSlideBottomPanel, View paramView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if ((paramValueAnimator instanceof Float))
    {
      this.Ei.setY(((Float)paramValueAnimator).floatValue());
      if (this.a.a != null) {
        this.a.a.fadeBackground(1.0F - ((Float)paramValueAnimator).floatValue() / this.cQx);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayro
 * JD-Core Version:    0.7.0.1
 */
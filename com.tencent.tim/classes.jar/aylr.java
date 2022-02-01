import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;

public class aylr
  implements ValueAnimator.AnimatorUpdateListener
{
  public aylr(DoodleEditView paramDoodleEditView, ayoo.a parama) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.d.FL = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aylr
 * JD-Core Version:    0.7.0.1
 */
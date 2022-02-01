import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.SecondDemoView;
import java.util.ArrayList;

public class ayoi
  implements ValueAnimator.AnimatorUpdateListener
{
  public ayoi(SecondDemoView paramSecondDemoView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (ArrayList)paramValueAnimator.getAnimatedValue();
    this.a.Gv = paramValueAnimator;
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayoi
 * JD-Core Version:    0.7.0.1
 */
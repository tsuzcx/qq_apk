import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.listentogether.ui.MusicPanelView;

public class aiqj
  implements ValueAnimator.AnimatorUpdateListener
{
  public aiqj(MusicPanelView paramMusicPanelView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    MusicPanelView.a(this.b, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqj
 * JD-Core Version:    0.7.0.1
 */
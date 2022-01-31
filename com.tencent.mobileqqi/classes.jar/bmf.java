import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.av.utils.RingAnimator;

public class bmf
  implements Animation.AnimationListener
{
  public bmf(RingAnimator paramRingAnimator) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.c.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmf
 * JD-Core Version:    0.7.0.1
 */
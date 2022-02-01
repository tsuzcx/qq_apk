import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class xnx
  extends AnimatorListenerAdapter
{
  public xnx(SixCombolEffectView paramSixCombolEffectView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (!SixCombolEffectView.mIsPlaying) {
      return;
    }
    this.a.ceg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xnx
 * JD-Core Version:    0.7.0.1
 */
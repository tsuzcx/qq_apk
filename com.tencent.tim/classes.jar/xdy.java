import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView;

public class xdy
  extends AnimatorListenerAdapter
{
  public xdy(HeartCombolEffectView paramHeartCombolEffectView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    this.this$0.setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.this$0.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xdy
 * JD-Core Version:    0.7.0.1
 */
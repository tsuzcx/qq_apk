import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.qphone.base.util.QLog;

public class xnu
  extends AnimatorListenerAdapter
{
  public xnu(SixCombolEffectView paramSixCombolEffectView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (!SixCombolEffectView.mIsPlaying) {
      return;
    }
    SixCombolEffectView.b(this.a).start();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (SixCombolEffectView.a(this.a)) {}
    do
    {
      return;
      SixCombolEffectView.bVC = 2;
    } while (!QLog.isColorLevel());
    QLog.w("SixCombolEffectView", 2, "Animation 2 ,mAnimationState = " + SixCombolEffectView.bVC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xnu
 * JD-Core Version:    0.7.0.1
 */
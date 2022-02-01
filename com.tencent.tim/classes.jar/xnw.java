import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.b;
import com.tencent.qphone.base.util.QLog;

public class xnw
  extends AnimatorListenerAdapter
{
  public xnw(SixCombolEffectView paramSixCombolEffectView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (!SixCombolEffectView.mIsPlaying) {}
    do
    {
      do
      {
        return;
        SixCombolEffectView.bVC = 4;
        if (QLog.isColorLevel()) {
          QLog.w("SixCombolEffectView", 2, "Animation 4 ,mAnimationState = " + SixCombolEffectView.bVC);
        }
      } while (SixCombolEffectView.a(this.a) == null);
      paramAnimator = SixCombolEffectView.a(this.a);
    } while (paramAnimator == null);
    SixCombolEffectView.a(this.a).a(paramAnimator);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (SixCombolEffectView.a(this.a)) {}
    do
    {
      return;
      SixCombolEffectView.bVC = 3;
    } while (!QLog.isColorLevel());
    QLog.w("SixCombolEffectView", 2, "Animation 3 ,mAnimationState = " + SixCombolEffectView.bVC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xnw
 * JD-Core Version:    0.7.0.1
 */
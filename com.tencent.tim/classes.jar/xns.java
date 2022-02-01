import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.qphone.base.util.QLog;

public class xns
  implements Animator.AnimatorListener
{
  public xns(SixCombolEffectView paramSixCombolEffectView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!SixCombolEffectView.mIsPlaying) {
      return;
    }
    SixCombolEffectView.a(this.a).start();
    this.a.cef();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (SixCombolEffectView.a(this.a)) {}
    do
    {
      return;
      SixCombolEffectView.bVC = 1;
    } while (!QLog.isColorLevel());
    QLog.w("SixCombolEffectView", 2, "Animation 1 ,mAnimationState = " + SixCombolEffectView.bVC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xns
 * JD-Core Version:    0.7.0.1
 */
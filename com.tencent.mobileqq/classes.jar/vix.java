import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.panel.PEPanel;
import com.tencent.qphone.base.util.QLog;

public class vix
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  public vix(PEPanel paramPEPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.setListViewVisibile(8);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((paramValueAnimator.getCurrentPlayTime() >= paramValueAnimator.getDuration() / 3L) && (QLog.isDebugVersion()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("zuiAnim.getDuration =  ");
      localStringBuilder.append(paramValueAnimator.getDuration());
      localStringBuilder.append(" currentPlaytime = ");
      localStringBuilder.append(paramValueAnimator.getCurrentPlayTime());
      QLog.d("PokeEmo.PEPanel", 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vix
 * JD-Core Version:    0.7.0.1
 */
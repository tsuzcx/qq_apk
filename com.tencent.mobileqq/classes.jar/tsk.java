import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tsk
  extends AnimatorListenerAdapter
{
  public tsk(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.a();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ThreadManager.getUIHandler().postDelayed(new ColorBandVideoEntranceButton.4.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tsk
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity.3.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class abtl
  implements Animator.AnimatorListener
{
  public abtl(ApolloGuestsStateActivity paramApolloGuestsStateActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ThreadManager.getUIHandler().postDelayed(new ApolloGuestsStateActivity.3.1(this), 200L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abtl
 * JD-Core Version:    0.7.0.1
 */
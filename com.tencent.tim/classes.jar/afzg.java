import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView;

class afzg
  implements Animator.AnimatorListener
{
  afzg(afzf paramafzf) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = ObjectAnimator.ofFloat(SignalBombAnimationView.b(this.a.b), "alpha", new float[] { 1.0F, 0.0F });
    paramAnimator.setDuration(280L);
    paramAnimator.addListener(new afzh(this));
    paramAnimator.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzg
 * JD-Core Version:    0.7.0.1
 */
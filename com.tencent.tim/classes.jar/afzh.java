import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView;

class afzh
  implements Animator.AnimatorListener
{
  afzh(afzg paramafzg) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SignalBombAnimationView.b(this.a.a.b).setTranslationY(0.0F);
    SignalBombAnimationView.a(this.a.a.b, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzh
 * JD-Core Version:    0.7.0.1
 */
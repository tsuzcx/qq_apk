import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView;
import com.tencent.qphone.base.util.QLog;

public class afzf
  implements Animator.AnimatorListener
{
  public afzf(SignalBombAnimationView paramSignalBombAnimationView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.b.f != null) && (SignalBombAnimationView.a(this.b) != null))
    {
      SignalBombAnimationView.a(this.b).setVisibility(0);
      SignalBombAnimationView.a(this.b).setImageDrawable(this.b.f);
      this.b.f.start();
      QLog.d("SignalBombAnimationView", 2, "mFireDrawable start");
    }
    paramAnimator = ObjectAnimator.ofFloat(SignalBombAnimationView.b(this.b), "alpha", new float[] { 1.0F, 1.0F });
    paramAnimator.setDuration(480L);
    paramAnimator.addListener(new afzg(this));
    paramAnimator.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzf
 * JD-Core Version:    0.7.0.1
 */
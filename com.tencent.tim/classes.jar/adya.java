import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

class adya
  extends AnimatorListenerAdapter
{
  adya(adxx paramadxx, ObjectAnimator paramObjectAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.bH.cancel();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.this$0.Bo != null) {
      this.this$0.Bo.setVisibility(0);
    }
    this.bH.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adya
 * JD-Core Version:    0.7.0.1
 */
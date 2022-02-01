import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.widget.ImageView;

class adxu
  extends AnimatorListenerAdapter
{
  adxu(adxq paramadxq, adxq.b paramb, ObjectAnimator paramObjectAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.bH.cancel();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a != null) {
      this.a.sq.setVisibility(0);
    }
    this.bH.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxu
 * JD-Core Version:    0.7.0.1
 */
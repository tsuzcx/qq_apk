import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

class tqz
  extends AnimatorListenerAdapter
{
  tqz(tqy paramtqy) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((tqy.a(this.a) != null) && (tqy.a(this.a).f != null))
    {
      tqy.a(this.a).f.setVisibility(0);
      paramAnimator = new AnimatorSet();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(tqy.a(this.a).f, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator1.setDuration(200L);
      localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(tqy.a(this.a).f, "translationY", new float[] { agej.a(15.0F, tqy.a(this.a).f.getResources()), 0.0F });
      localObjectAnimator2.setDuration(200L);
      localObjectAnimator2.setInterpolator(new DecelerateInterpolator());
      paramAnimator.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      paramAnimator.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqz
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

class mrq
  extends AnimatorListenerAdapter
{
  mrq(mrp parammrp) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((mrp.a(this.a) != null) && (mrp.a(this.a).lC != null))
    {
      mrp.a(this.a).lC.setVisibility(0);
      paramAnimator = new AnimatorSet();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(mrp.a(this.a).lC, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator1.setDuration(200L);
      localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(mrp.a(this.a).lC, "translationY", new float[] { wja.dp2px(15.0F, mrp.a(this.a).lC.getResources()), 0.0F });
      localObjectAnimator2.setDuration(200L);
      localObjectAnimator2.setInterpolator(new DecelerateInterpolator());
      paramAnimator.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      paramAnimator.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mrq
 * JD-Core Version:    0.7.0.1
 */
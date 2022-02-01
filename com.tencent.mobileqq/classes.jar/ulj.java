import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ulj
  extends AnimatorListenerAdapter
{
  ulj(uli paramuli) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((uli.a(this.a) != null) && (uli.a(this.a).e != null))
    {
      uli.a(this.a).e.setVisibility(0);
      paramAnimator = new AnimatorSet();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(uli.a(this.a).e, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator1.setDuration(200L);
      localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(uli.a(this.a).e, "translationY", new float[] { AIOUtils.dp2px(15.0F, uli.a(this.a).e.getResources()), 0.0F });
      localObjectAnimator2.setDuration(200L);
      localObjectAnimator2.setInterpolator(new DecelerateInterpolator());
      paramAnimator.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      paramAnimator.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulj
 * JD-Core Version:    0.7.0.1
 */
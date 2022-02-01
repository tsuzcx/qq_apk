import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.qqcircle.fragments.content.ScrollMoreGuideView.3.1;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class pbs
  implements Animator.AnimatorListener
{
  pbs(pbp parampbp, RecyclerViewCompat paramRecyclerViewCompat) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.b.dismiss();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.dismiss();
    if ((pbp.a(this.b) > 0) && (this.d != null)) {
      this.d.postDelayed(new ScrollMoreGuideView.3.1(this), 500L);
    }
    while (pbp.a(this.b) == null) {
      return;
    }
    pbp.a(this.b).bjo();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbs
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;

class aecq
  implements Animator.AnimatorListener
{
  aecq(aecj paramaecj, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    aecj.b(this.a).scrollTo(0, 0);
    aecj.b(this.a).setAlpha(1.0F);
    aecj.b(this.a).setBackgroundColor(aecj.a(this.a).getResources().getColor(aecj.access$700()));
    paramAnimator = this.a.recyclerView;
    if (this.bSW) {}
    for (float f = -this.a.recyclerView.getMeasuredWidth();; f = this.a.recyclerView.getMeasuredWidth())
    {
      paramAnimator.setX(f);
      this.a.recyclerView.setAlpha(0.0F);
      this.a.recyclerView.setVisibility(0);
      this.a.recyclerView.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setDuration(180L).start();
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aecq
 * JD-Core Version:    0.7.0.1
 */
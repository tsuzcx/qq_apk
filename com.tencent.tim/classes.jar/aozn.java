import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class aozn
  extends AnimatorListenerAdapter
{
  aozn(aozl paramaozl, boolean paramBoolean, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    boolean bool = false;
    if (this.cPs) {
      this.Ig.setVisibility(8);
    }
    if (!this.cPs)
    {
      paramAnimator = new int[2];
      this.Ig.getLocationOnScreen(paramAnimator);
      i = rpq.getWindowScreenHeight(this.a.mContext) - paramAnimator[1];
      if (i >= this.dSl) {}
    }
    for (int i = this.dSl - i;; i = 0)
    {
      if (this.a.b != null)
      {
        paramAnimator = this.a.b;
        if (!this.cPs) {
          bool = true;
        }
        paramAnimator.bB(bool, i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozn
 * JD-Core Version:    0.7.0.1
 */
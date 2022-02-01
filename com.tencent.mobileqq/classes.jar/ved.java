import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqcircle.widgets.QCircleTitleFollowView;

class ved
  extends AnimatorListenerAdapter
{
  ved(vdr paramvdr) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    vdr.a(this.a, false);
    vdr.a(this.a).setVisibility(8);
    vdr.a(this.a).getLayoutParams().width = bhtq.a(80.0F);
    vdr.a(this.a).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ved
 * JD-Core Version:    0.7.0.1
 */
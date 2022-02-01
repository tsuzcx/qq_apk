import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqcircle.widgets.QCircleTitleFollowView;

class vck
  extends AnimatorListenerAdapter
{
  vck(vcb paramvcb) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    vcb.a(this.a, false);
    vcb.a(this.a).setVisibility(8);
    vcb.a(this.a).getLayoutParams().width = bgtn.a(80.0F);
    vcb.a(this.a).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vck
 * JD-Core Version:    0.7.0.1
 */
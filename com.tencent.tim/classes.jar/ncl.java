import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.b;

public class ncl
  implements Animator.AnimatorListener
{
  public ncl(BaseTabbar.b paramb, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    BaseTabbar.b.a(this.a, this.arj);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    BaseTabbar.b.a(this.a, this.arj);
    BaseTabbar.b.a(this.a);
    this.a.kp.clearAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ncl
 * JD-Core Version:    0.7.0.1
 */
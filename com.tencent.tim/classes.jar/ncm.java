import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.b;
import com.tencent.qphone.base.util.QLog;

public class ncm
  implements Animator.AnimatorListener
{
  public ncm(BaseTabbar.b paramb) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QLog.d("TabBarView", 4, "onAnimationEnd");
    BaseTabbar.b.b(this.a);
    this.a.kp.clearAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ncm
 * JD-Core Version:    0.7.0.1
 */
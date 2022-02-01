import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyTabDragAnimationView;

public class nhp
  implements Animator.AnimatorListener
{
  public nhp(ReadInjoyTabDragAnimationView paramReadInjoyTabDragAnimationView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setScaleX(1.0F);
    this.a.setScaleY(1.0F);
    this.a.setRotation(0.0F);
    this.a.setAlpha(1.0F);
    if (ReadInjoyTabDragAnimationView.a(this.a) != 0) {
      this.a.tA(0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nhp
 * JD-Core Version:    0.7.0.1
 */
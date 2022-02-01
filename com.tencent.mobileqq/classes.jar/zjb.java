import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;

public class zjb
  implements Animator.AnimatorListener
{
  public zjb(RotateCircleImageView paramRotateCircleImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    RotateCircleImageView.a(this.a).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjb
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

class ykv
  implements Animator.AnimatorListener
{
  ykv(ykt paramykt, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (FrameLayout.LayoutParams)ykt.b(this.jdField_a_of_type_Ykt).getLayoutParams();
    paramAnimator.height = this.jdField_a_of_type_Int;
    paramAnimator.width = this.b;
    paramAnimator.setMargins(this.c, this.d, 0, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ykv
 * JD-Core Version:    0.7.0.1
 */
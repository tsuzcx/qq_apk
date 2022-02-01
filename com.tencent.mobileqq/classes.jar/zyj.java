import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

class zyj
  implements Animator.AnimatorListener
{
  zyj(zyh paramzyh, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (FrameLayout.LayoutParams)zyh.b(this.jdField_a_of_type_Zyh).getLayoutParams();
    paramAnimator.height = this.jdField_a_of_type_Int;
    paramAnimator.width = this.b;
    paramAnimator.setMargins(this.c, this.d, 0, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyj
 * JD-Core Version:    0.7.0.1
 */
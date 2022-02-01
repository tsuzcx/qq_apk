import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.ae.album.nocropper.AECropperImageView;

public class awvm
  implements Animator.AnimatorListener
{
  public awvm(AECropperImageView paramAECropperImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, false);
    if (this.a.animatorListener != null) {
      this.a.animatorListener.onAnimationCancel(paramAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, false);
    if (this.a.animatorListener != null) {
      this.a.animatorListener.onAnimationEnd(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, true);
    if (this.a.animatorListener != null) {
      this.a.animatorListener.onAnimationStart(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvm
 * JD-Core Version:    0.7.0.1
 */
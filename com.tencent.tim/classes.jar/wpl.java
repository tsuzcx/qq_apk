import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class wpl
  implements Animator.AnimatorListener
{
  wpl(wpj paramwpj, LottieDrawable paramLottieDrawable, int paramInt, ImageView paramImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel onAnimationCancel drawable=" + this.e);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel onAnimationEnd drawable=" + this.e);
    }
    wpj.a(this.this$0, paramAnimator, this.bQa);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel onAnimationStart drawable=" + this.e);
    }
    if ((wpm.gr(this.bQa)) && (this.e.getSpeed() > 0.0F)) {
      this.e.reverseAnimationSpeed();
    }
    this.sr.invalidateDrawable(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpl
 * JD-Core Version:    0.7.0.1
 */
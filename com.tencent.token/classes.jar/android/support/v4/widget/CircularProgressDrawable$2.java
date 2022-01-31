package android.support.v4.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class CircularProgressDrawable$2
  implements Animator.AnimatorListener
{
  CircularProgressDrawable$2(CircularProgressDrawable paramCircularProgressDrawable, CircularProgressDrawable.Ring paramRing) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    CircularProgressDrawable.access$100(this.this$0, 1.0F, this.val$ring, true);
    this.val$ring.storeOriginals();
    this.val$ring.goToNextColor();
    if (CircularProgressDrawable.access$300(this.this$0))
    {
      CircularProgressDrawable.access$302(this.this$0, false);
      paramAnimator.cancel();
      paramAnimator.setDuration(1332L);
      paramAnimator.start();
      this.val$ring.setShowArrow(false);
      return;
    }
    CircularProgressDrawable.access$202(this.this$0, CircularProgressDrawable.access$200(this.this$0) + 1.0F);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    CircularProgressDrawable.access$202(this.this$0, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.CircularProgressDrawable.2
 * JD-Core Version:    0.7.0.1
 */
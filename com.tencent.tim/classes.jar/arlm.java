import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.RelativeLayout;

class arlm
  implements Animator.AnimatorListener
{
  arlm(arlj paramarlj, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.this$0.et != null)
    {
      if (this.ekq != 0) {
        break label41;
      }
      this.this$0.et.setAlpha(1.0F);
    }
    for (;;)
    {
      arlj.b(this.this$0, this.ekq);
      return;
      label41:
      if (this.ekq == 1) {
        this.this$0.et.setAlpha(0.0F);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    arlj.b(this.this$0, this.ekq);
    if (this.ekq == 1)
    {
      arlj.a(this.this$0, false);
      this.this$0.a(false, new View[] { arlj.a(this.this$0) });
    }
    arlj.a(this.this$0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    arlj.b(this.this$0, 2);
    if (this.ekq == 0)
    {
      arlj.a(this.this$0, true);
      if (arlj.a(this.this$0) == 1) {
        this.this$0.a(true, new View[] { arlj.a(this.this$0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arlm
 * JD-Core Version:    0.7.0.1
 */
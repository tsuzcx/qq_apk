import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

class jcb
  implements Animator.AnimatorListener
{
  jcb(jbz paramjbz, int paramInt, long paramLong) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i = 4;
    if (this.a.eg != null)
    {
      i = this.a.eg.getVisibility();
      if (this.a.isShow) {
        break label173;
      }
      this.a.eg.setVisibility(8);
    }
    for (;;)
    {
      this.a.eg.setAlpha(1.0F);
      this.a.eg.setTranslationY(0.0F);
      QLog.w(this.a.TAG, 1, "ShowMenuView, onAnimationEnd, isShow[" + this.a.isShow + "], visibility[" + i + "], seq[" + this.kQ + "], \nlastObjectAnimator[" + this.a.aB + "], \nanimation[" + paramAnimator + "]");
      if (this.a.aB == paramAnimator) {
        this.a.aB = null;
      }
      return;
      label173:
      this.a.eg.setVisibility(0);
      if (this.a.a != null) {
        this.a.a.a(this.kQ, this.a.eg, false);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    int i = 4;
    if (this.a.eg != null)
    {
      i = this.a.eg.getVisibility();
      this.a.eg.setVisibility(0);
    }
    QLog.w(this.a.TAG, 1, "ShowMenuView, onAnimationStart, height[" + this.val$height + "], isShow[" + this.a.isShow + "], visibility[" + i + "], seq[" + this.kQ + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcb
 * JD-Core Version:    0.7.0.1
 */
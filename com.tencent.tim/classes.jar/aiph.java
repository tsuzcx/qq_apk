import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout;

class aiph
  implements Animator.AnimatorListener
{
  aiph(aipd paramaipd, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.this$0.b.iv(this.deD, this.deF);
    this.this$0.a.iv(this.deH, this.deJ);
    this.this$0.b.dtk();
    this.this$0.a.dtk();
    this.this$0.as = null;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.b.iv(this.deD, this.deF);
    this.this$0.a.iv(this.deH, this.deJ);
    this.this$0.b.dtk();
    this.this$0.a.dtk();
    this.this$0.as = null;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiph
 * JD-Core Version:    0.7.0.1
 */
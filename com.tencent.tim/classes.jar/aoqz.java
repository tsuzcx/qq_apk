import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ListView;

class aoqz
  implements Animator.AnimatorListener
{
  aoqz(aoqv paramaoqv) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    aoqv.a(this.a).setPadding(aqcx.dip2px(aoqv.a(this.a).getContext(), 8.0F), -aoqv.a(this.a), 0, 0);
    aoqv.a(this.a).setVisibility(8);
    aoqv.a(this.a, false);
    aoqv.b(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    aoqv.a(this.a).setPadding(aqcx.dip2px(aoqv.a(this.a).getContext(), 8.0F), -aoqv.a(this.a), 0, 0);
    aoqv.a(this.a).setVisibility(8);
    aoqv.a(this.a, false);
    aoqv.b(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    aoqv.a(this.a).setPadding(aqcx.dip2px(aoqv.a(this.a).getContext(), 8.0F), 0, 0, 0);
    aoqv.a(this.a, true);
    aoqv.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqz
 * JD-Core Version:    0.7.0.1
 */
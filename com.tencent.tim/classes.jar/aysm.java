import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class aysm
  implements Animator.AnimatorListener
{
  aysm(aysi paramaysi) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!aysi.a(this.a)) {
      return;
    }
    if (!aysi.b(this.a))
    {
      aysi.a(this.a, false);
      if (aysi.b(this.a) == 1)
      {
        aysi.a(this.a, 3);
        return;
      }
      aysi.a(this.a, 0);
      aysi.a(this.a, "");
      return;
    }
    if (aysi.b(this.a) == 1)
    {
      aysi.a(this.a, 2);
      aysi.a(this.a, aysi.b(this.a), 1000);
      return;
    }
    aysi.a(this.a, "");
    aysi.a(this.a, 0);
    aysi.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!aysi.a(this.a)) {
      return;
    }
    if (!aysi.b(this.a))
    {
      aysi.a(this.a, false);
      if (aysi.b(this.a) == 1)
      {
        aysi.a(this.a, 3);
        return;
      }
      aysi.a(this.a, 0);
      aysi.a(this.a, "");
      return;
    }
    if (aysi.b(this.a) == 1)
    {
      aysi.a(this.a, 2);
      aysi.a(this.a, aysi.b(this.a), 1000);
      return;
    }
    aysi.a(this.a, "");
    aysi.a(this.a, 0);
    aysi.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysm
 * JD-Core Version:    0.7.0.1
 */
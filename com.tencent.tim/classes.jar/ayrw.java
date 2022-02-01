import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ayrw
  implements Animator.AnimatorListener
{
  ayrw(ayrt paramayrt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!ayrt.a(this.a)) {}
    do
    {
      return;
      if (ayrt.b(this.a)) {
        break;
      }
      ayrt.a(this.a, false);
    } while (ayrt.b(this.a) != 2);
    ayrt.a(this.a, 0);
    return;
    ayrt.a(this.a, false);
    ayrt.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!ayrt.a(this.a)) {
      return;
    }
    if (!ayrt.b(this.a))
    {
      ayrt.a(this.a, false);
      if (ayrt.b(this.a) == 1)
      {
        ayrt.a(this.a, 3);
        return;
      }
      ayrt.a(this.a, 0);
      return;
    }
    if (ayrt.b(this.a) == 1)
    {
      ayrt.a(this.a, 2);
      ayrt.a(this.a, ayrt.b(this.a), 1000);
      return;
    }
    ayrt.a(this.a, false);
    ayrt.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayrw
 * JD-Core Version:    0.7.0.1
 */
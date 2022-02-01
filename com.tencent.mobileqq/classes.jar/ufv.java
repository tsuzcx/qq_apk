import android.animation.Animator;
import android.view.View;

class ufv
  extends uex
{
  ufv(ufr paramufr) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.a.b != null) {
      this.a.b.setVisibility(8);
    }
    ufr.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufv
 * JD-Core Version:    0.7.0.1
 */
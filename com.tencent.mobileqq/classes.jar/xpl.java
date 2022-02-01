import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import android.widget.ImageView;

class xpl
  extends AnimatorListenerAdapter
{
  xpl(xpj paramxpj) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (Build.VERSION.SDK_INT >= 16) {
      this.a.a.setImageAlpha(255);
    }
    for (;;)
    {
      this.a.a.setVisibility(8);
      return;
      this.a.a.setImageResource(2130850680);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpl
 * JD-Core Version:    0.7.0.1
 */
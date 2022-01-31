import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import android.widget.ImageView;

class tze
  extends AnimatorListenerAdapter
{
  tze(tzc paramtzc) {}
  
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
      this.a.a.setImageResource(2130849558);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tze
 * JD-Core Version:    0.7.0.1
 */
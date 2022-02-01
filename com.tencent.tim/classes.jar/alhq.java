import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class alhq
  implements Animation.AnimationListener
{
  alhq(alhp paramalhp) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!alhp.a(this.b)) {
      for (;;)
      {
        int j = (int)(alhp.a(this.b) * (Math.random() * 2.0D - 1.0D));
        int i = (int)Math.sqrt(alhp.a(this.b) * alhp.a(this.b) - j * j);
        if (Math.random() > 0.5D) {}
        while ((alhp.b(this.b) + j) * (alhp.b(this.b) + j) + (alhp.c(this.b) + i) * (alhp.c(this.b) + i) <= alhp.d(this.b) * alhp.d(this.b))
        {
          alhp.a(this.b, new TranslateAnimation(alhp.b(this.b), alhp.b(this.b) + j, alhp.c(this.b), alhp.c(this.b) + i));
          alhp.a(this.b, j + alhp.b(this.b));
          alhp.b(this.b, i + alhp.c(this.b));
          alhp.a(this.b).setAnimationListener(alhp.a(this.b));
          alhp.a(this.b).setDuration(alhp.a(this.b) * (int)(50.0D + Math.random() * 30.0D));
          alhp.a(this.b).startAnimation(alhp.a(this.b));
          return;
          i = -i;
        }
      }
    }
    alhp.a(this.b, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhq
 * JD-Core Version:    0.7.0.1
 */
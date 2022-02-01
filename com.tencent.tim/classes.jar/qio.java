import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import android.widget.ImageView;

class qio
  extends AnimatorListenerAdapter
{
  qio(qim paramqim) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (Build.VERSION.SDK_INT >= 16) {
      this.a.mH.setImageAlpha(255);
    }
    for (;;)
    {
      this.a.mH.setVisibility(8);
      return;
      this.a.mH.setImageResource(2130851770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qio
 * JD-Core Version:    0.7.0.1
 */
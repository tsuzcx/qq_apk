import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class mxl
  extends AnimatorListenerAdapter
{
  mxl(mxi parammxi, mtg.l paraml) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.i(this.e);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    mxi.a(this.b).setRepeatCount(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxl
 * JD-Core Version:    0.7.0.1
 */
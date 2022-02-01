import android.app.Activity;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class rrs
  implements Animation.AnimationListener
{
  rrs(rrq paramrrq, Context paramContext) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.val$context instanceof Activity))
    {
      if (!((Activity)this.val$context).isFinishing()) {
        this.b.dismiss();
      }
      return;
    }
    this.b.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rrs
 * JD-Core Version:    0.7.0.1
 */
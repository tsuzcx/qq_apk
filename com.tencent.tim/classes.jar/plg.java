import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class plg
  implements Animation.AnimationListener
{
  plg(plc.a parama) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (plc.a(this.a.a) == 1)
    {
      this.a.a.eU.setVisibility(8);
      plc.a(this.a.a).sendEmptyMessage(1);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plg
 * JD-Core Version:    0.7.0.1
 */
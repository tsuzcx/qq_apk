import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class vfv
  implements Animation.AnimationListener
{
  vfv(vfu paramvfu, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.aXZ) && (vfu.a(this.c) != null) && (vfu.a(this.c).size() >= 2)) {
      vfu.a(this.c).sendEmptyMessageDelayed(1688002, 1400L);
    }
    if (vfu.a(this.c) != null)
    {
      vfu.a(this.c).recycle();
      vfu.a(this.c, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfv
 * JD-Core Version:    0.7.0.1
 */
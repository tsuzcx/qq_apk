import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.VisitorsActivity;

public class wgl
  extends auqs.a
{
  public wgl(VisitorsActivity paramVisitorsActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.this$0.mWaveCount > 0)
    {
      this.this$0.mHandler.postDelayed(this.this$0.ee, 200L);
      return;
    }
    this.this$0.vX.setVisibility(4);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = this.this$0;
    paramAnimation.mWaveCount -= 1;
    this.this$0.vX.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgl
 * JD-Core Version:    0.7.0.1
 */
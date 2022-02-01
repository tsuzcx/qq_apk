import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.14.1;

public class ycj
  implements Animation.AnimationListener
{
  ycj(ycd paramycd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.bYs = 5;
    ycd.e(this.this$0).post(new PublicAccountChatPie.14.1(this));
    this.this$0.mHandler.sendEmptyMessage(1);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ycj
 * JD-Core Version:    0.7.0.1
 */
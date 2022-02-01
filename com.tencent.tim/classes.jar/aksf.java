import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.onlinestatus.AccountPanel.4;

public class aksf
  implements Animation.AnimationListener
{
  public aksf(AccountPanel.4 param4) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      this.a.this$0.dismiss();
      paramAnimation.setAnimationListener(null);
      akrv.a(this.a.this$0).clearAnimation();
      akrv.a(this.a.this$0, true);
      return;
    }
    catch (Exception paramAnimation)
    {
      for (;;)
      {
        paramAnimation.printStackTrace();
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksf
 * JD-Core Version:    0.7.0.1
 */
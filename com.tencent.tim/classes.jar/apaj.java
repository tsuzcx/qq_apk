import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class apaj
  implements Animation.AnimationListener
{
  apaj(apag paramapag, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (apag.a(this.this$0) != null)
    {
      apag.a(this.this$0).container.clearAnimation();
      apag.a(this.this$0).container.setVisibility(8);
    }
    apag.a(this.this$0, false);
    apag.a(this.this$0, null);
    apag.a(this.this$0, null);
    apag.a(this.this$0, -1);
    if ((!this.aZt) && (!apag.b(this.this$0)))
    {
      ThreadManager.getUIHandler().post(apag.a(this.this$0));
      apag.b(this.this$0, true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apaj
 * JD-Core Version:    0.7.0.1
 */
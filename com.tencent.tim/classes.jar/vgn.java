import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LoginInfoActivity;

public class vgn
  implements Animation.AnimationListener
{
  public vgn(LoginInfoActivity paramLoginInfoActivity, boolean paramBoolean, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    LoginInfoActivity.c(this.this$0).setVisibility(4);
    LoginInfoActivity.a(this.this$0).clearAnimation();
    LoginInfoActivity.b(this.this$0, this.aYr, this.aNZ);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vgn
 * JD-Core Version:    0.7.0.1
 */
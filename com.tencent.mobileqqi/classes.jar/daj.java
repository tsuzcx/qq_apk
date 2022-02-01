import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.PublicAccountActivity;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;

public class daj
  implements Animation.AnimationListener
{
  public daj(PublicAccountActivity paramPublicAccountActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      PublicAccountActivity.a(this.a).show();
      label10:
      PublicAccountActivity.a(this.a).setAnimation(null);
      PublicAccountActivity.b(this.a).setVisibility(8);
      return;
    }
    catch (Exception paramAnimation)
    {
      break label10;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     daj
 * JD-Core Version:    0.7.0.1
 */
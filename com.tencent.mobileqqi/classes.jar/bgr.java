import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class bgr
  implements Animation.AnimationListener
{
  public bgr(PoiMapActivity paramPoiMapActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (RelativeLayout.LayoutParams)this.a.d.getLayoutParams();
    paramAnimation.bottomMargin = (-this.a.j);
    this.a.d.setLayoutParams(paramAnimation);
    this.a.d.clearAnimation();
    this.a.a.setImageResource(2130838343);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgr
 * JD-Core Version:    0.7.0.1
 */
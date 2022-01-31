import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class hlx
  implements Animation.AnimationListener
{
  public hlx(ShaderAnimLayout paramShaderAnimLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hlx
 * JD-Core Version:    0.7.0.1
 */
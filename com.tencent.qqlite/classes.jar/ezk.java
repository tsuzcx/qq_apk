import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class ezk
  implements Animation.AnimationListener
{
  public ezk(ShaderAnimLayout paramShaderAnimLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ezk
 * JD-Core Version:    0.7.0.1
 */
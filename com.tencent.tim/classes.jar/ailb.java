import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.jsp.UiApiPlugin;

public class ailb
  implements Animation.AnimationListener
{
  public ailb(UiApiPlugin paramUiApiPlugin, View paramView, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.mr.clearAnimation();
    this.mr.layout(this.mr.getLeft(), this.ddK, this.mr.getRight(), this.ddL);
    this.mr.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ailb
 * JD-Core Version:    0.7.0.1
 */
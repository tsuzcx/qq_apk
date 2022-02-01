import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.lebasearch.widget.ScrolledTabHost;

public class jso
  implements Animation.AnimationListener
{
  public jso(ScrolledTabHost paramScrolledTabHost, View paramView1, View paramView2, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.iK.setVisibility(4);
    this.iL.setVisibility(0);
    this.a.iJ.setVisibility(8);
    this.a.oe(this.aCS);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jso
 * JD-Core Version:    0.7.0.1
 */
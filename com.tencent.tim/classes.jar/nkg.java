import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class nkg
  implements Animation.AnimationListener
{
  public nkg(FastWebActivity paramFastWebActivity, boolean paramBoolean, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.val$isShow)
    {
      this.val$view.setVisibility(0);
      return;
    }
    this.val$view.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nkg
 * JD-Core Version:    0.7.0.1
 */
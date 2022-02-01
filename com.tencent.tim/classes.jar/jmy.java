import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class jmy
  implements Animation.AnimationListener
{
  public jmy(PoiMapActivity paramPoiMapActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (FrameLayout.LayoutParams)PoiMapActivity.c(this.this$0).getLayoutParams();
    paramAnimation.bottomMargin = (this.this$0.aBU + this.this$0.aBV);
    PoiMapActivity.c(this.this$0).setLayoutParams(paramAnimation);
    if ((this.this$0.iB != null) && (this.this$0.iB.getVisibility() != 8)) {
      this.this$0.iB.setVisibility(8);
    }
    PoiMapActivity.d(this.this$0).clearAnimation();
    this.this$0.aaB = true;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmy
 * JD-Core Version:    0.7.0.1
 */
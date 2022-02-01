import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;

public class jna
  implements Animation.AnimationListener
{
  public jna(PoiMapActivity paramPoiMapActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (PoiMapActivity.g(this.this$0) != null) {
      PoiMapActivity.h(this.this$0).getMap().getUiSettings().setLogoPositionWithMargin(0, 0, 0, 0, 0);
    }
    paramAnimation = (FrameLayout.LayoutParams)this.this$0.iy.getLayoutParams();
    paramAnimation.bottomMargin = (-this.this$0.aBU);
    this.this$0.iy.setLayoutParams(paramAnimation);
    if ((this.this$0.iB != null) && (this.this$0.iB.getVisibility() != 0)) {
      this.this$0.iB.setVisibility(0);
    }
    PoiMapActivity.e(this.this$0).clearAnimation();
    this.this$0.aaB = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jna
 * JD-Core Version:    0.7.0.1
 */
import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class axwl
  implements aqnc.a<Float>
{
  public axwl(AdvancedProviderView paramAdvancedProviderView, QIMProviderContainerView paramQIMProviderContainerView, View paramView) {}
  
  @TargetApi(11)
  public void a(aqnc<Float> paramaqnc, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    paramFloat = paramFloat1.floatValue();
    if (this.c != null) {
      this.c.setBackGroundAlpha(paramFloat);
    }
    if (this.Ml != null) {
      this.Ml.setAlpha(paramFloat);
    }
    AdvancedProviderView.a(this.a, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwl
 * JD-Core Version:    0.7.0.1
 */
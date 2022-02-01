import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;

public class awzg
  implements aqnc.a<Float>
{
  public awzg(AEBeautyProviderView paramAEBeautyProviderView, AEProviderContainerView paramAEProviderContainerView, View paramView) {}
  
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
    AEBeautyProviderView.a(this.a, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awzg
 * JD-Core Version:    0.7.0.1
 */
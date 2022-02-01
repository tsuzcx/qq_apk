import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView;

public class awzp
  implements Animation.AnimationListener
{
  public awzp(AEMaterialPanel paramAEMaterialPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (AEMaterialPanel.a(this.this$0) != null)
    {
      AEMaterialPanel.a(this.this$0).setAlpha(1.0F);
      AEMaterialPanel.a(this.this$0).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awzp
 * JD-Core Version:    0.7.0.1
 */
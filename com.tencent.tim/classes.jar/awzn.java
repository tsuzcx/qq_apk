import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel.a;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView;

public class awzn
  implements Animation.AnimationListener
{
  public awzn(AEMaterialPanel paramAEMaterialPanel, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AEMaterialPanel.a(this.this$0, false);
    if (AEMaterialPanel.a(this.this$0) != null) {
      AEMaterialPanel.a(this.this$0).eGl();
    }
    if (this.val$callback != null) {
      this.val$callback.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AEMaterialPanel.a(this.this$0, true);
    if (AEMaterialPanel.a(this.this$0) != null)
    {
      AEMaterialPanel.a(this.this$0).setAlpha(1.0F);
      AEMaterialPanel.a(this.this$0).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awzn
 * JD-Core Version:    0.7.0.1
 */
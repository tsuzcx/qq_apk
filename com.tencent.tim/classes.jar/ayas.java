import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonCornerLayout;

public class ayas
  extends AnimatorListenerAdapter
{
  public ayas(LightWeightCaptureButtonCornerLayout paramLightWeightCaptureButtonCornerLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b.setTranslationY(0.0F);
    this.a.ePV();
    ainc.dsX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayas
 * JD-Core Version:    0.7.0.1
 */
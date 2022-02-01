import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.PaFlashLightView;
import com.tencent.mobileqq.widget.PaFlashLightView.a;

public class argm
  implements Animation.AnimationListener
{
  public argm(PaFlashLightView paramPaFlashLightView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.daw = true;
    switch (this.a.mIndex)
    {
    }
    for (;;)
    {
      this.a.mIndex = ((this.a.mIndex + 1) % 3);
      return;
      this.a.bW.setVisibility(8);
      this.a.a.sendEmptyMessageDelayed(0, 3250L);
      continue;
      this.a.bX.setVisibility(8);
      this.a.a.sendEmptyMessageDelayed(0, 1050L);
      continue;
      this.a.bY.setVisibility(8);
      this.a.a.sendEmptyMessageDelayed(0, 3250L);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argm
 * JD-Core Version:    0.7.0.1
 */
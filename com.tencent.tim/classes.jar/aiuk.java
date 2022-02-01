import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;

public class aiuk
  implements Animator.AnimatorListener
{
  public aiuk(PoiSlideBottomPanel paramPoiSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    PoiSlideBottomPanel.c(this.c, false);
    if (PoiSlideBottomPanel.e(this.c) != null) {
      PoiSlideBottomPanel.f(this.c).displayPanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    PoiSlideBottomPanel.b(this.c, false);
    if (PoiSlideBottomPanel.c(this.c) != null) {
      PoiSlideBottomPanel.d(this.c).displayPanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    PoiSlideBottomPanel.a(this.c, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiuk
 * JD-Core Version:    0.7.0.1
 */
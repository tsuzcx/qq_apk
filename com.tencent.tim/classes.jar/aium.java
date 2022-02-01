import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;

public class aium
  implements Animator.AnimatorListener
{
  public aium(PoiSlideBottomPanel paramPoiSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    PoiSlideBottomPanel.h(this.c, false);
    PoiSlideBottomPanel.i(this.c, false);
    PoiSlideBottomPanel.j(this.c, false);
    if (PoiSlideBottomPanel.k(this.c) != null) {
      PoiSlideBottomPanel.l(this.c).hidePanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    PoiSlideBottomPanel.e(this.c, false);
    PoiSlideBottomPanel.f(this.c, false);
    PoiSlideBottomPanel.g(this.c, false);
    if (PoiSlideBottomPanel.i(this.c) != null) {
      PoiSlideBottomPanel.j(this.c).hidePanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    PoiSlideBottomPanel.d(this.c, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aium
 * JD-Core Version:    0.7.0.1
 */
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.widget.XPanelContainer;

public class ahyy
  implements ValueAnimator.AnimatorUpdateListener
{
  public ahyy(HotPicMainPanel paramHotPicMainPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    XPanelContainer.aLe = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.b.f.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyy
 * JD-Core Version:    0.7.0.1
 */
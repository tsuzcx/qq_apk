import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qphone.base.util.QLog;

public class aiul
  implements ValueAnimator.AnimatorUpdateListener
{
  public aiul(PoiSlideBottomPanel paramPoiSlideBottomPanel, View paramView, float paramFloat, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if ((paramValueAnimator instanceof Float))
    {
      this.Ei.setY(((Float)paramValueAnimator).floatValue());
      if (QLog.isColorLevel()) {
        QLog.d("PoiSlideBottomPanel", 2, "[panel] onAnimationUpdate: hide invoked. org: " + this.wY + " dest: " + this.cQx + " value: " + this.Ei.getY());
      }
      if (PoiSlideBottomPanel.g(this.c) != null) {
        PoiSlideBottomPanel.h(this.c).fadeBackground(1.0F - ((Float)paramValueAnimator).floatValue() / this.cQx);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiul
 * JD-Core Version:    0.7.0.1
 */
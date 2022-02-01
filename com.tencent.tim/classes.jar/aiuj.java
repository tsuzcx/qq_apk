import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qphone.base.util.QLog;

public class aiuj
  implements ValueAnimator.AnimatorUpdateListener
{
  public aiuj(PoiSlideBottomPanel paramPoiSlideBottomPanel, View paramView, float paramFloat1, float paramFloat2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if ((paramValueAnimator instanceof Float))
    {
      this.Ei.setY(((Float)paramValueAnimator).floatValue());
      if (QLog.isColorLevel()) {
        QLog.d("PoiSlideBottomPanel", 2, "[panel] onAnimationUpdate: show invoked. mPanel:" + this.Ei.getId() + " org: " + this.wY + " dest: " + this.wZ + " value: " + this.Ei.getY());
      }
      if (PoiSlideBottomPanel.a(this.c) != null) {
        PoiSlideBottomPanel.b(this.c).fadeBackground(1.0F - ((Float)paramValueAnimator).floatValue() / (PoiSlideBottomPanel.a(this.c) - PoiSlideBottomPanel.a(this.c)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiuj
 * JD-Core Version:    0.7.0.1
 */
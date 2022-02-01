import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class auvu
  implements ValueAnimator.AnimatorUpdateListener
{
  public auvu(XPanelContainer paramXPanelContainer, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.g.dlm)
    {
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, "colseAnim resetPosition");
      }
      XPanelContainer.a(this.g, 0);
      return;
    }
    XPanelContainer.a(this.g, this.val$height - i);
    this.g.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auvu
 * JD-Core Version:    0.7.0.1
 */
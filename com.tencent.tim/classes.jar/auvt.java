import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class auvt
  implements ValueAnimator.AnimatorUpdateListener
{
  public auvt(XPanelContainer paramXPanelContainer, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.g.dlm)
    {
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, "openAnim resetPosition");
      }
      XPanelContainer.a(this.g, 0);
      return;
    }
    XPanelContainer.a(this.g, this.val$height - i);
    this.g.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auvt
 * JD-Core Version:    0.7.0.1
 */
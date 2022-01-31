import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.widget.XPanelContainer;

public class fjh
  implements ValueAnimator.AnimatorUpdateListener
{
  public fjh(XPanelContainer paramXPanelContainer, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    XPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_Int - i);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fjh
 * JD-Core Version:    0.7.0.1
 */
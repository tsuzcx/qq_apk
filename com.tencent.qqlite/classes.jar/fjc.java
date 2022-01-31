import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.widget.XPanelContainer;

public class fjc
  implements ValueAnimator.AnimatorUpdateListener
{
  public fjc(XPanelContainer paramXPanelContainer, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    XPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_Int - i);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fjc
 * JD-Core Version:    0.7.0.1
 */
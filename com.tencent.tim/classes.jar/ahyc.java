import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.mobileqq.hiboom.RichTextPanel;

class ahyc
  implements ValueAnimator.AnimatorUpdateListener
{
  ahyc(ahyb paramahyb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    com.tencent.widget.XPanelContainer.aLe = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.b.a.getParent() != null) {
      this.b.a.getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyc
 * JD-Core Version:    0.7.0.1
 */
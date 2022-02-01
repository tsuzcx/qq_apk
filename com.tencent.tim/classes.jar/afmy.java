import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.widget.XPanelContainer;

class afmy
  implements ValueAnimator.AnimatorUpdateListener
{
  afmy(afmw paramafmw, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    XPanelContainer.aLe = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (afmw.a(this.this$0).getParent() != null) {
      afmw.a(this.this$0).getParent().requestLayout();
    }
    if ((this.cSm == afmw.a(this.this$0)) && (XPanelContainer.aLe == afmw.a(this.this$0))) {
      this.this$0.abordFling();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afmy
 * JD-Core Version:    0.7.0.1
 */
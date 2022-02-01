import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

class afmx
  implements ValueAnimator.AnimatorUpdateListener
{
  afmx(afmw paramafmw, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i == this.val$targetHeight) {
      AbstractGifImage.resumeAll();
    }
    com.tencent.widget.XPanelContainer.aLe = i;
    if (afmw.a(this.this$0).getParent() != null) {
      afmw.a(this.this$0).getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afmx
 * JD-Core Version:    0.7.0.1
 */
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.hiboom.RichTextPanel;

class ahyd
  implements ValueAnimator.AnimatorUpdateListener
{
  ahyd(ahyb paramahyb, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i == this.val$targetHeight) {
      AbstractGifImage.resumeAll();
    }
    com.tencent.widget.XPanelContainer.aLe = i;
    if (this.b.a.getParent() != null) {
      this.b.a.getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyd
 * JD-Core Version:    0.7.0.1
 */
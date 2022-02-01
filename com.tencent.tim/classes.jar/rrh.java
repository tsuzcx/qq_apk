import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;
import com.tencent.biz.qqstory.view.RingView.a;

public class rrh
  implements ValueAnimator.AnimatorUpdateListener
{
  public rrh(NeoVideoRecordButton paramNeoVideoRecordButton) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.c.k(((Integer)paramValueAnimator.getAnimatedValue("radius")).intValue(), 0.0F);
    this.a.c.bux = ((Integer)paramValueAnimator.getAnimatedValue("color")).intValue();
    NeoVideoRecordButton.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rrh
 * JD-Core Version:    0.7.0.1
 */
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;
import com.tencent.biz.qqstory.view.RingView.a;

public class rri
  implements ValueAnimator.AnimatorUpdateListener
{
  public rri(NeoVideoRecordButton paramNeoVideoRecordButton) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a.k(((Integer)paramValueAnimator.getAnimatedValue("border")).intValue(), 0.0F);
    this.a.a.l(((Integer)paramValueAnimator.getAnimatedValue("ring")).intValue(), 0.0F);
    this.a.b.k(((Integer)paramValueAnimator.getAnimatedValue("center")).intValue(), 0.0F);
    this.a.b.bux = ((Integer)paramValueAnimator.getAnimatedValue("color")).intValue();
    NeoVideoRecordButton.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rri
 * JD-Core Version:    0.7.0.1
 */
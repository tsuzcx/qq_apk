import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;

public class xqe
  implements ValueAnimator.AnimatorUpdateListener
{
  public xqe(NeoVideoRecordButton paramNeoVideoRecordButton) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a.a(((Integer)paramValueAnimator.getAnimatedValue("border")).intValue(), 0.0F);
    this.a.a.b(((Integer)paramValueAnimator.getAnimatedValue("ring")).intValue(), 0.0F);
    this.a.b.a(((Integer)paramValueAnimator.getAnimatedValue("center")).intValue(), 0.0F);
    this.a.b.e = ((Integer)paramValueAnimator.getAnimatedValue("color")).intValue();
    NeoVideoRecordButton.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xqe
 * JD-Core Version:    0.7.0.1
 */
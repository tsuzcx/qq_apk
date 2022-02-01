import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;

public class zrr
  implements ValueAnimator.AnimatorUpdateListener
{
  public zrr(NeoVideoRecordButton paramNeoVideoRecordButton) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a.a(((Integer)paramValueAnimator.getAnimatedValue("border")).intValue(), 0.0F);
    this.a.a.b(((Integer)paramValueAnimator.getAnimatedValue("ring")).intValue(), 0.0F);
    this.a.b.a(((Integer)paramValueAnimator.getAnimatedValue("center")).intValue(), 0.0F);
    this.a.b.e = ((Integer)paramValueAnimator.getAnimatedValue("color")).intValue();
    NeoVideoRecordButton.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zrr
 * JD-Core Version:    0.7.0.1
 */
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;

public class wbl
  implements ValueAnimator.AnimatorUpdateListener
{
  public wbl(NeoVideoRecordButton paramNeoVideoRecordButton) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.c.a(((Integer)paramValueAnimator.getAnimatedValue("radius")).intValue(), 0.0F);
    this.a.c.e = ((Integer)paramValueAnimator.getAnimatedValue("color")).intValue();
    NeoVideoRecordButton.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wbl
 * JD-Core Version:    0.7.0.1
 */
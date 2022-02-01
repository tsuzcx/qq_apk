import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;

public class aapy
  implements ValueAnimator.AnimatorUpdateListener
{
  public aapy(FlowCameraActivity2 paramFlowCameraActivity2, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.this$0.zR.setPadding(0, 0, 0, paramValueAnimator.intValue());
    this.this$0.zP.setPadding(0, this.val$height - paramValueAnimator.intValue(), 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aapy
 * JD-Core Version:    0.7.0.1
 */
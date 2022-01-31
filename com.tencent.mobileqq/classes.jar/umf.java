import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgQueueView;
import com.tencent.qphone.base.util.QLog;

public class umf
  implements ValueAnimator.AnimatorUpdateListener
{
  public umf(GoldMsgQueueView paramGoldMsgQueueView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.invalidate();
    if (QLog.isColorLevel()) {
      QLog.d("GoldMsgQueueView", 2, "tryDoInsert onAnimationUpdate");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     umf
 * JD-Core Version:    0.7.0.1
 */
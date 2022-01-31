import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgQueueView;
import com.tencent.qphone.base.util.QLog;

public class uph
  extends AnimatorListenerAdapter
{
  public uph(GoldMsgQueueView paramGoldMsgQueueView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    GoldMsgQueueView.a(this.a, false);
    GoldMsgQueueView.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("GoldMsgQueueView", 2, "tryDoInsert end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uph
 * JD-Core Version:    0.7.0.1
 */
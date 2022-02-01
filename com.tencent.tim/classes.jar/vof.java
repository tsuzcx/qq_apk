import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSActivity.20.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import mqq.os.MqqHandler;

public class vof
  implements Animation.AnimationListener
{
  public vof(QQLSActivity paramQQLSActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.uiHandler.removeMessages(99);
    if (VersionUtils.isJellyBean())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "do SmoothFinish");
      }
      QQLSActivity.g(this.this$0);
      this.this$0.finish();
      return;
    }
    this.this$0.uiHandler.postAtFrontOfQueue(new QQLSActivity.20.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vof
 * JD-Core Version:    0.7.0.1
 */
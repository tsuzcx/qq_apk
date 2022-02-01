import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.anima.CloudTeamWorkAnimActivity;
import com.tencent.tim.cloudfile.anima.CloudTeamWorkAnimActivity.3.1;
import mqq.os.MqqHandler;

public class atjj
  implements Animation.AnimationListener
{
  public atjj(CloudTeamWorkAnimActivity paramCloudTeamWorkAnimActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CloudTeamWorkAnimActivity<QFileCloud>", 1, "teamwork anim is finish. activity will be close");
    }
    ThreadManager.getUIHandler().postDelayed(new CloudTeamWorkAnimActivity.3.1(this), 200L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjj
 * JD-Core Version:    0.7.0.1
 */
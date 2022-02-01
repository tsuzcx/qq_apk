import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.TeamWorkFileImportActivity;

public class auku
  implements ValueAnimator.AnimatorUpdateListener
{
  public auku(TeamWorkFileImportActivity paramTeamWorkFileImportActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedFraction() == 1.0F)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkFileImportActivity", 2, "---first animator onAnimationUpdate End---");
      }
      this.a.handler.sendEmptyMessageDelayed(7002, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auku
 * JD-Core Version:    0.7.0.1
 */
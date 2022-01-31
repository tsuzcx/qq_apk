import android.content.IntentFilter;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class tnl
  implements Runnable
{
  public tnl(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      if (QQLSActivity.a(this.a) == 0)
      {
        BaseApplicationImpl.getContext().registerReceiver(this.a.a, localIntentFilter);
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "registerScreenListener real mScreenReceiver:" + this.a.a.hashCode() + "context :" + BaseApplicationImpl.getContext().hashCode());
        }
        QQLSActivity.a(this.a, 1);
      }
      QQLSActivity.a(this.a, AnimationUtils.loadAnimation(this.a, 2131034321));
      QQLSActivity.a(this.a).setFillAfter(true);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "registerScreenListener");
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("QQLSActivity", 2, "registerScreenListener:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnl
 * JD-Core Version:    0.7.0.1
 */
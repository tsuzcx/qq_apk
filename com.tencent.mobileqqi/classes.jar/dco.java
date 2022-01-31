import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;

public class dco
  extends BroadcastReceiver
{
  public dco(QQMapActivity paramQQMapActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equals("android.intent.action.SCREEN_OFF")) && (!this.a.m) && (!this.a.jdField_n_of_type_Boolean) && (GesturePWDUtils.getGesturePWDState(this.a, this.a.jdField_n_of_type_JavaLangString) == 2) && (GesturePWDUtils.getGesturePWDMode(this.a, this.a.jdField_n_of_type_JavaLangString) == 21))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqbaseactivity", 2, "qqmapactivity.start lock. receive lock.");
      }
      paramContext = new Intent(this.a, GesturePWDUnlockActivity.class);
      QQMapActivity.b(this.a, paramContext);
      this.a.jdField_n_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dco
 * JD-Core Version:    0.7.0.1
 */
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securemodule.service.CloudScanListener;

public class fjp
  implements CloudScanListener
{
  public fjp(QQAppInterface paramQQAppInterface) {}
  
  public void onFinish(int paramInt)
  {
    if (paramInt == 0) {
      PreferenceManager.getDefaultSharedPreferences(QQAppInterface.f(this.a)).edit().putLong("security_scan_last_time", System.currentTimeMillis()).putBoolean("security_scan_last_result", false).commit();
    }
  }
  
  public void onRiskFound()
  {
    if (QLog.isColorLevel()) {
      QLog.d("security_scan", 2, "Find Risk");
    }
    PreferenceManager.getDefaultSharedPreferences(QQAppInterface.e(this.a)).edit().putBoolean("security_scan_last_result", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fjp
 * JD-Core Version:    0.7.0.1
 */
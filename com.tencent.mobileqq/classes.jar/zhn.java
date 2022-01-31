import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securemodule.service.CloudScanListener;
import java.util.List;

public class zhn
  implements CloudScanListener
{
  public zhn(QQAppInterface paramQQAppInterface) {}
  
  public void onFinish(int paramInt)
  {
    if (paramInt == 0) {
      PreferenceManager.getDefaultSharedPreferences(QQAppInterface.h(this.a)).edit().putLong("security_scan_last_time", System.currentTimeMillis()).putBoolean("security_scan_last_result", false).commit();
    }
  }
  
  public void onRiskFoud(List paramList) {}
  
  public void onRiskFound()
  {
    if (QLog.isColorLevel()) {
      QLog.d("security_scan", 2, "Find Risk");
    }
    PreferenceManager.getDefaultSharedPreferences(QQAppInterface.g(this.a)).edit().putBoolean("security_scan_last_result", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhn
 * JD-Core Version:    0.7.0.1
 */
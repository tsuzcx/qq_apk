import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class goq
  extends AsyncTask
{
  public goq(String paramString) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = BaseApplicationImpl.getContext();
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramVarArgs);
    if (((SharedPreferences)localObject).getBoolean("hasReportDeviceProfile", false)) {
      return null;
    }
    ((SharedPreferences)localObject).edit().putBoolean("hasReportDeviceProfile", true);
    localObject = new HashMap();
    int i = MainAcitivityReportHelper.a(paramVarArgs);
    int j = DeviceInfoUtil.b() * 100 + MainAcitivityReportHelper.b();
    if (i <= 240) {
      i = j + 1;
    }
    for (;;)
    {
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      StatisticCollector.a(BaseApplication.getContext()).a(this.a, "reportDeviceProfile", false, 0L, 0L, (HashMap)localObject, "");
      return null;
      if (i <= 320) {
        i = j + 2;
      } else if (i <= 480) {
        i = j + 3;
      } else if (i <= 640) {
        i = j + 4;
      } else if (i <= 720) {
        i = j + 5;
      } else if (i <= 1080) {
        i = j + 6;
      } else {
        i = j + 7;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     goq
 * JD-Core Version:    0.7.0.1
 */
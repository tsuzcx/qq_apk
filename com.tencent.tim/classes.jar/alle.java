import android.annotation.SuppressLint;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

public class alle
{
  @SuppressLint({"NewApi"})
  public static void requestPermissions(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    paramActivity.requestPermissions(paramArrayOfString, paramInt);
    paramActivity = new Throwable();
    QLog.e("QMPermissionMonitor", 1, "[requestPermissions] stack: ", paramActivity);
    allb.h("request_permission", "requestPermissions", paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alle
 * JD-Core Version:    0.7.0.1
 */
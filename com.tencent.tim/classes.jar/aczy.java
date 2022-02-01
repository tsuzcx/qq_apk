import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class aczy
{
  @TargetApi(23)
  public static void a(AppActivity paramAppActivity, int paramInt, QQPermissionCallback paramQQPermissionCallback)
  {
    if (paramAppActivity != null) {
      paramAppActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
    }
  }
  
  @TargetApi(23)
  public static boolean bd(Context paramContext)
  {
    return (paramContext != null) && (paramContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
  }
  
  public static void dW(Context paramContext)
  {
    QLog.i("PermissionUtils", 2, "gotoSettingPage");
    Intent localIntent = new Intent();
    localIntent.addFlags(335544320);
    localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.fromParts("package", paramContext.getPackageName(), null));
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczy
 * JD-Core Version:    0.7.0.1
 */
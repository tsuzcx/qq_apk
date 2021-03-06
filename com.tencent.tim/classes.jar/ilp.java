import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.camera.QavCameraUsage.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ilp
{
  public static String NH;
  
  public static boolean Z(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getSharedPreferences("qav_camera_usage_sp", 4).getString("camera_used_desc", null);
    QLog.w("QavCameraUsage", 1, "getCameraUsageState, cameraIsUsing[" + paramContext + "]");
    if (paramContext != null) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static void ay(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    String str = NH;
    paramString = paramString + "_" + System.currentTimeMillis();
    QLog.w("QavCameraUsage", 1, "setCameraUsageState, last[" + str + "], cur[" + paramString + "]");
    NH = paramString;
    paramContext = paramContext.getSharedPreferences("qav_camera_usage_sp", 4).edit();
    paramContext.putString("camera_used_desc", paramString);
    paramContext.putBoolean("camera_used", true);
    paramContext.commit();
  }
  
  public static void az(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    QLog.w("QavCameraUsage", 1, "clearCameraUsageState, cameraIsUsing[" + NH + "], type[" + paramString + "]");
    NH = null;
    paramContext = paramContext.getSharedPreferences("qav_camera_usage_sp", 4).edit();
    paramContext.remove("camera_used_desc");
    paramContext.putBoolean("camera_used", false);
    paramContext.commit();
  }
  
  public static boolean checkAVCameraUsed(Context paramContext)
  {
    return g(paramContext, true);
  }
  
  public static boolean g(Context paramContext, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramContext == null) {
      return bool2;
    }
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    label43:
    int j;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      int i = 0;
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label83;
      }
      if (!((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals("com.tencent.mobileqq:video")) {
        break label135;
      }
      i = 1;
    }
    label135:
    for (;;)
    {
      break label43;
      j = 0;
      label83:
      if (j != 0) {
        bool1 = Z(paramContext);
      }
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (!paramBoolean) {
        break;
      }
      new Handler(Looper.getMainLooper()).post(new QavCameraUsage.1(paramContext));
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilp
 * JD-Core Version:    0.7.0.1
 */
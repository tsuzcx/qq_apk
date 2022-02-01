import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import mqq.app.AppActivity;
import org.json.JSONObject;

public class aorf
{
  public static String TAG = "tribe_publish_TribePublishLauncher";
  
  public static void a(UiApiPlugin paramUiApiPlugin, Activity paramActivity, AppInterface paramAppInterface, String paramString1, byte paramByte, String paramString2)
  {
    if ((paramActivity instanceof AppActivity))
    {
      AppActivity localAppActivity = (AppActivity)paramActivity;
      if (localAppActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
        localAppActivity.requestPermissions(new aorg(localAppActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
      }
    }
    while ((ilp.checkAVCameraUsed(paramActivity)) || (aA(paramActivity))) {
      return;
    }
    boolean bool = azby.C(paramAppInterface);
    if ((!bool) && (!aqiw.isNetworkAvailable(paramActivity)))
    {
      QQToast.a(paramActivity, 2131718877, 0).show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "launchTakeVideoForTribe, videoSoUsable=" + bool);
    }
    paramUiApiPlugin.bdA();
    paramAppInterface = new Bundle();
    paramAppInterface.putBoolean("flow_camera_video_mode", true);
    paramAppInterface.putBoolean("flow_camera_capture_mode", false);
    paramAppInterface.putString("options", paramString1);
    paramAppInterface.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramAppInterface.putInt("edit_video_type", 10012);
    if (bool)
    {
      paramUiApiPlugin.startActivityForResult(QIMCameraCaptureActivity.a(paramActivity, paramAppInterface), paramByte);
      if (!"barindex".equals(paramString2)) {
        break label287;
      }
    }
    label287:
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00899", "Grp_tribe", "", "video_shoot", "exp_findview", i, 0, "", "", "", "");
      return;
      paramActivity = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
      paramActivity.putExtras(paramAppInterface);
      paramActivity.putExtra("pendingIntentClass", awta.class.getName());
      paramActivity.putExtra("pendingIntentRequest", paramByte);
      paramActivity.putExtra("pendingIntentAllWait", true);
      paramUiApiPlugin.startActivityForResult(paramActivity, paramByte);
      break;
    }
  }
  
  private static boolean aA(Context paramContext)
  {
    boolean bool = false;
    if (!alwy.auJ())
    {
      aqha.a(paramContext, 230).setMessage(acfp.m(2131715448)).setPositiveButton(2131721079, new aorh()).show();
      bool = true;
    }
    return bool;
  }
  
  public static JSONObject d(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("options");
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getTribeJsonExtra option: " + paramBundle);
      }
      try
      {
        paramBundle = new JSONObject(paramBundle);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "getTribeJsonExtra: " + paramBundle);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aorf
 * JD-Core Version:    0.7.0.1
 */
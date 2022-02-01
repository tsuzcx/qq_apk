import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.ptv.LightVideoSoDownloadFragment;
import dov.com.qq.im.ptv.PtvCameraCaptureActivity;
import dov.com.qq.im.ptv.PtvSoDownloadActivity;

public class aybs
{
  public static boolean C(AppInterface paramAppInterface)
  {
    return (ShortVideoUtils.m(paramAppInterface)) && (ankq.aB(BaseApplicationImpl.getContext()) == 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (paramQQAppInterface.bF()) {
      QQToast.a(paramActivity, 0, 2131720263, 0).show();
    }
    while (f(paramActivity, paramQQAppInterface)) {
      return;
    }
    arlc.aT(BaseApplicationImpl.getContext(), 51);
    boolean bool = C(paramQQAppInterface);
    paramQQAppInterface = paramBundle;
    if (paramBundle == null) {
      paramQQAppInterface = new Bundle();
    }
    paramBundle = ayan.class.getName();
    if (bool)
    {
      PtvCameraCaptureActivity.b(paramActivity, paramBundle, paramQQAppInterface, paramInt);
      return;
    }
    paramQQAppInterface.putInt("flow_camera_show_mode_style", 0);
    paramQQAppInterface.putBoolean("flow_camera_show_panel", false);
    paramQQAppInterface.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramQQAppInterface = PtvSoDownloadActivity.a(paramActivity, paramBundle, paramQQAppInterface);
    paramQQAppInterface.putExtra("PTV_pendingIntentRequest", paramInt);
    PublicTransFragmentActivity.startForResult(paramActivity, paramQQAppInterface, LightVideoSoDownloadFragment.class, paramInt);
  }
  
  private static boolean aQe()
  {
    if ((Build.MODEL.equals("ASUS_Z00ADB")) && (Build.VERSION.SDK_INT == 21)) {}
    while ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("M040")) && (Build.VERSION.SDK_INT == 19)) {
      return false;
    }
    return true;
  }
  
  private static boolean f(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    boolean bool3 = VideoEnvironment.p(paramQQAppInterface);
    boolean bool4 = alwy.auJ();
    boolean bool2 = aQe();
    if ((!bool3) || (!bool4) || (!bool2))
    {
      ram.d("CaptureUtils", "checkApiVersionDialog false");
      aqha.a(paramContext, 230).setMessage(acfp.m(2131710193)).setPositiveButton(2131721079, new aybt()).show();
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aybs
 * JD-Core Version:    0.7.0.1
 */
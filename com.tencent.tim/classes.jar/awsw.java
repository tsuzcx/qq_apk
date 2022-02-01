import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.QIMShortVideoUtils.2;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class awsw
{
  public static boolean O(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        boolean bool = "com.tencent.mobileqq:peak".equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName);
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QIMShortVideoUtils", 2, "get process info fail.");
      }
    }
    return false;
  }
  
  private static Intent a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    aytu.AK("jumpToCamera");
    if (!VideoEnvironment.o(paramBaseActivity.app))
    {
      aqha.a(paramBaseActivity, 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131721079, new awsx()).show();
      return null;
    }
    if (paramQQAppInterface.bF())
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131698108, 1).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
      return null;
    }
    return a(paramBaseActivity, false, paramQQAppInterface, true);
  }
  
  private static Intent a(BaseActivity paramBaseActivity, boolean paramBoolean1, QQAppInterface paramQQAppInterface, boolean paramBoolean2)
  {
    b(paramBaseActivity, paramQQAppInterface);
    if ((!paramBoolean2) && (paramBaseActivity.getIntent() != null)) {}
    for (paramBaseActivity = paramBaseActivity.getIntent();; paramBaseActivity = new Intent())
    {
      paramBaseActivity.putExtra("PhotoConst.MY_UIN", paramQQAppInterface.getAccount());
      paramBaseActivity.putExtra("sv_config", DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
      paramBaseActivity.putExtra("sv_whitelist", DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
      paramBaseActivity.putExtra("flow_camera_video_mode", true);
      paramBaseActivity.putExtra("flow_camera_use_filter_function", true);
      paramBaseActivity.putExtra("extra_now_tab", ppf.IC());
      aytu.AK("start activity");
      if (MediaPlayerManager.a(paramQQAppInterface).isPlaying()) {
        MediaPlayerManager.a(paramQQAppInterface).stop(false);
      }
      return paramBaseActivity;
    }
  }
  
  public static void a(Context paramContext, Runnable paramRunnable, String paramString)
  {
    ThreadManager.excute(new QIMShortVideoUtils.2(paramContext, paramString, paramRunnable), 64, null, false);
  }
  
  private static void a(BaseActivity paramBaseActivity, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3)
  {
    paramIntent.setClass(paramBaseActivity, QIMCameraCaptureActivity.class);
    paramIntent.putExtra("edit_video_type", paramInt1);
    paramIntent.putExtra("take_video_entrance_type", paramInt2);
    if (ankq.JS() == 2)
    {
      CaptureQmcfSoDownloadActivity.b(paramBaseActivity, awtc.class.getName(), paramIntent.getExtras(), 11000);
      return;
    }
    if (paramInt3 != -1)
    {
      paramBaseActivity.startActivityForResult(paramIntent, paramInt3);
      return;
    }
    paramBaseActivity.startActivity(paramIntent);
  }
  
  public static boolean a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7, boolean paramBoolean, int paramInt8, int paramInt9, int paramInt10, Bundle paramBundle)
  {
    Intent localIntent = a(paramBaseActivity, paramBaseActivity.app);
    if (localIntent == null) {
      return false;
    }
    ((axpr)axov.a(5)).eNM();
    localIntent.putExtra("firsttab", paramInt5);
    localIntent.putExtra("secondtab", paramInt6);
    localIntent.putExtra("itemid", paramString);
    if (paramInt8 != 0) {
      localIntent.putExtra("type", paramInt8);
    }
    localIntent.putExtra("qim_camera_open_specific", paramBoolean);
    localIntent.addFlags(603979776);
    if (paramInt7 != 0) {
      localIntent.putExtra("videoId", paramInt7);
    }
    localIntent.putExtra("WebSceneType", paramInt10);
    if ((paramInt2 == 10004) || (paramInt2 == 10002))
    {
      localIntent.putExtra("need_show_banner", true);
      if (paramBundle != null) {
        paramString = paramBundle.keySet().iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label257;
        }
        String str = (String)paramString.next();
        if ("succUrl".startsWith(str))
        {
          localIntent.putExtra(str, paramBundle.getString(str));
          continue;
          localIntent.putExtra("need_show_banner", false);
          break;
        }
        if ("failedUrl".startsWith(str)) {
          localIntent.putExtra(str, paramBundle.getString(str));
        }
      }
    }
    label257:
    localIntent.putExtra("flow_camera_qim_tab_direction", paramInt1);
    localIntent.putExtra("cameraDirection", paramInt9);
    a(paramBaseActivity, localIntent, paramInt2, paramInt3, paramInt4);
    return true;
  }
  
  private static boolean b(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    ShortVideoUtils.B(paramQQAppInterface);
    return ShortVideoUtils.awI();
  }
  
  public static void dv(Context paramContext, String paramString)
  {
    a(paramContext, null, paramString);
  }
  
  public static void gC(Context paramContext)
  {
    dv(paramContext, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awsw
 * JD-Core Version:    0.7.0.1
 */
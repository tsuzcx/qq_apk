import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.AppRuntime;

public class kqi
{
  private static boolean As()
  {
    return ankq.f(getQQAppInterface(), BaseApplicationImpl.getContext());
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, byte paramByte)
  {
    if (paramActivity == null) {
      return;
    }
    if (getQQAppInterface().bF())
    {
      QQToast.a(paramActivity, 0, 2131720263, 0).show();
      return;
    }
    boolean bool = azby.C(getQQAppInterface());
    if (!alwy.auJ())
    {
      bN(paramActivity);
      return;
    }
    if ((!bool) && (!aqiw.isNetworkAvailable(paramActivity)))
    {
      QQToast.a(paramActivity, 2131718877, 0).show();
      return;
    }
    As();
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramActivity, f(paramBundle), paramByte);
      return;
    }
    Intent localIntent = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(f(paramBundle));
    localIntent.putExtra("pendingIntentClass", awsv.class.getName());
    localIntent.putExtra("pendingIntentRequest", paramByte);
    localIntent.putExtra("pendingIntentAllWait", true);
    CaptureQmcfSoDownloadActivity.b(paramActivity, awtc.class.getName(), localIntent.getExtras(), paramByte);
  }
  
  public static void a(obw paramobw, Context paramContext, Bundle paramBundle, byte paramByte)
  {
    boolean bool = azby.C(paramobw.mRuntime.a());
    if (!alwy.auJ())
    {
      bN(paramContext);
      return;
    }
    if ((!bool) && (!aqiw.isNetworkAvailable(paramContext)))
    {
      QQToast.a(paramContext, 2131718877, 0).show();
      return;
    }
    paramobw.bdA();
    if (bool)
    {
      paramobw.startActivityForResult(QIMCameraCaptureActivity.a(paramContext, f(paramBundle)), paramByte);
      return;
    }
    paramContext = new Intent(paramContext, CaptureQmcfSoDownloadActivity.class);
    paramContext.putExtras(f(paramBundle));
    paramContext.putExtra("pendingIntentClass", awsv.class.getName());
    paramContext.putExtra("pendingIntentRequest", paramByte);
    paramContext.putExtra("pendingIntentAllWait", true);
    paramobw.startActivityForResult(paramContext, paramByte);
  }
  
  private static void bN(Context paramContext) {}
  
  public static void bO(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("edit_video_type", 10017);
    localBundle.putInt("entrance_type", 106);
    localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    localBundle.putInt("capture_intent_mode", 0);
    localBundle.putBoolean("enable_local_video", false);
    if (getQQAppInterface().bF())
    {
      QQToast.a(paramContext, 0, 2131720263, 0).show();
      return;
    }
    boolean bool = azby.C(getQQAppInterface());
    if (!alwy.auJ())
    {
      bN(paramContext);
      return;
    }
    if ((!bool) && (!aqiw.isNetworkAvailable(paramContext)))
    {
      QQToast.a(paramContext, 2131718877, 0).show();
      return;
    }
    As();
    if (bool)
    {
      QIMCameraCaptureActivity.g(paramContext, localBundle);
      return;
    }
    CaptureQmcfSoDownloadActivity.a(paramContext, mjv.class.getName(), localBundle, true);
  }
  
  private static Bundle f(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10013);
    localBundle.putInt("key_ability_flag", 3);
    localBundle.putInt("key_max_duration", awit.k(BaseApplicationImpl.getApplication().getRuntime()));
    return localBundle;
  }
  
  public static void f(Context paramContext, Bundle paramBundle)
  {
    if (getQQAppInterface().bF())
    {
      QQToast.a(paramContext, 0, 2131720263, 0).show();
      return;
    }
    boolean bool = azby.C(getQQAppInterface());
    if (!alwy.auJ())
    {
      bN(paramContext);
      return;
    }
    if ((!bool) && (!aqiw.isNetworkAvailable(paramContext)))
    {
      QQToast.a(paramContext, 2131718877, 0).show();
      return;
    }
    As();
    if (bool)
    {
      QIMCameraCaptureActivity.g(paramContext, f(paramBundle));
      return;
    }
    CaptureQmcfSoDownloadActivity.a(paramContext, awsv.class.getName(), f(paramBundle), true);
  }
  
  private static QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new AndroidRuntimeException("mobile qq main process only");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqi
 * JD-Core Version:    0.7.0.1
 */
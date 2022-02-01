import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.AndroidRuntimeException;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher.1;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class rnq
{
  public static boolean As()
  {
    return ankq.f(getQQAppInterface(), BaseApplicationImpl.getContext());
  }
  
  private Bundle a(Bundle paramBundle, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramBundle.putInt("capture_intent_mode", paramInt2);
    if ((paramInt2 == 0) || (paramInt2 == 1))
    {
      paramBundle.putInt("cameraDirection", paramInt1);
      paramBundle.putInt("firsttab", paramInt3);
      paramBundle.putInt("secondtab", paramInt4);
      paramBundle.putString("itemid", paramString1);
      paramBundle.putBoolean("qim_camera_open_specific", paramBoolean);
    }
    for (;;)
    {
      ram.i("Q.qqstory.publish.StoryPublishLauncher", "initLaunchArgs captureMode=%s, tabType=%d, category=%d, itemId=%s, openSpecific=%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString1, Boolean.valueOf(paramBoolean) });
      return paramBundle;
      if (paramInt2 == 3) {
        paramBundle.putString("story_capture_album_id", paramString3);
      }
    }
  }
  
  public static rnq a()
  {
    return new rnq();
  }
  
  private boolean aA(Context paramContext)
  {
    boolean bool = false;
    if (!alwy.auJ())
    {
      ram.d("Q.qqstory.publish.StoryPublishLauncher", "checkApiVersionDialog false");
      aqha.a(paramContext, 230).setMessage(acfp.m(2131714973)).setPositiveButton(2131721079, new rnr(this)).show();
      bool = true;
    }
    return bool;
  }
  
  public static QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new AndroidRuntimeException("mobile qq main process only");
  }
  
  private void tV(boolean paramBoolean)
  {
    int i = ankq.aB(BaseApplicationImpl.getContext());
    HashMap localHashMap;
    if (i != 0)
    {
      ThreadManager.excute(new StoryPublishLauncher.1(this, paramBoolean), 128, null, false);
      if ((paramBoolean) && (i == 1))
      {
        i = 1;
        localHashMap = new HashMap();
        if (!paramBoolean) {
          break label185;
        }
        str = "1";
        label55:
        localHashMap.put("videoSoUsable", str);
        if (i == 0) {
          break label191;
        }
        str = "1";
        label71:
        localHashMap.put("videoAndFilterReady", str);
        anpc.a(BaseApplication.getContext()).collectPerformance("", "actShortVideoSoDownload", true, 0L, 0L, localHashMap, "");
      }
    }
    else
    {
      i = angh.ay(BaseApplicationImpl.getContext());
      if (i != 0)
      {
        ThreadManager.excute(new StoryPublishLauncher.2(this), 128, null, false);
        localHashMap = new HashMap();
        if (i != 1) {
          break label197;
        }
      }
    }
    label185:
    label191:
    label197:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("ptuSoReady", str);
      anpc.a(BaseApplication.getContext()).collectPerformance("", "actShortVideoPtuSoDownload", true, 0L, 0L, localHashMap, "");
      QQStoryContext.a().blH();
      return;
      i = 0;
      break;
      str = "0";
      break label55;
      str = "0";
      break label71;
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (getQQAppInterface().bF())
    {
      axiy.w("Q.qqstory.publish.StoryPublishLauncher", "【2131720263】");
      QQToast.a(paramActivity, 0, 2131720263, 0).show();
    }
    while (aA(paramActivity)) {
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    boolean bool;
    if (localBundle.getInt("entrance_type") == 104)
    {
      bool = azby.D(getQQAppInterface());
      aW(localBundle);
      axce.a().Ya(true);
      if (!bool) {
        break label121;
      }
      axiy.i("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 QIMCameraCaptureActivity");
      QIMCameraCaptureActivity.a(paramActivity, localBundle, paramInt);
    }
    for (;;)
    {
      tV(bool);
      return;
      bool = axcj.aOt();
      break;
      label121:
      axiy.i("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 CaptureQmcfSoDownloadActivity");
      CaptureQmcfSoDownloadActivity.a(paramActivity, awsy.class.getName(), localBundle, paramInt, localBundle.getBoolean("resource_need_all_wait", false));
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt5)
  {
    a(paramActivity, a(paramBundle, paramInt1, paramInt2, paramInt3, paramInt4, paramString1, paramString2, paramString3, paramBoolean), paramInt5);
  }
  
  public boolean a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    boolean bool2 = true;
    if (getQQAppInterface().bF())
    {
      QQToast.a(paramActivity, 0, 2131720263, 0).show();
      bool2 = false;
      return bool2;
    }
    if (aA(paramActivity)) {
      return false;
    }
    boolean bool1;
    if ((paramBundle != null) && (paramBundle.getInt("entrance_type") == 104))
    {
      bool1 = azby.D(getQQAppInterface());
      label63:
      ram.b("Q.qqstory.publish.StoryPublishLauncher", "launchForResult, videoSoUsable=%s, filterOk=%s", Boolean.valueOf(bool1), Boolean.valueOf(As()));
      QQStoryContext.a().blH();
      if (paramBundle != null) {
        break label134;
      }
      paramBundle = new Bundle();
    }
    label134:
    for (;;)
    {
      aW(paramBundle);
      if (bool1) {
        break;
      }
      CaptureQmcfSoDownloadActivity.a(paramActivity, awsy.class.getName(), paramBundle, paramInt, true, true);
      return false;
      bool1 = axcj.aOt();
      break label63;
    }
  }
  
  public void aW(@NonNull Bundle paramBundle)
  {
    if (!paramBundle.containsKey("entrance_type")) {
      ram.w("Q.qqstory.publish.StoryPublishLauncher", "do not has entrance type", new Throwable());
    }
    if (!paramBundle.containsKey("edit_video_type")) {
      paramBundle.putInt("edit_video_type", 10002);
    }
    if (!paramBundle.containsKey("ability_flag")) {
      paramBundle.putInt("ability_flag", 1);
    }
    if (!paramBundle.containsKey("enable_multi_fragment"))
    {
      paramBundle.putBoolean("enable_multi_fragment", true);
      if (!paramBundle.containsKey("capture_max_duration")) {
        paramBundle.putLong("capture_max_duration", 60000L);
      }
    }
    if (!paramBundle.containsKey("capture_max_duration")) {
      paramBundle.putLong("capture_max_duration", 10000L);
    }
    paramBundle.putBoolean("camera_peak_is_alive", awsw.O(BaseApplicationImpl.getContext()));
  }
  
  public void g(Context paramContext, Bundle paramBundle)
  {
    if (getQQAppInterface().bF())
    {
      axiy.w("Q.qqstory.publish.StoryPublishLauncher", "【2131720263】");
      QQToast.a(paramContext, 0, 2131720263, 0).show();
    }
    while (aA(paramContext)) {
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    boolean bool;
    if (localBundle.getInt("entrance_type") == 104)
    {
      bool = azby.D(getQQAppInterface());
      aW(localBundle);
      axce.a().Ya(true);
      if (!bool) {
        break label116;
      }
      axiy.i("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 QIMCameraCaptureActivity");
      QIMCameraCaptureActivity.g(paramContext, localBundle);
    }
    for (;;)
    {
      tV(bool);
      return;
      bool = axcj.aOt();
      break;
      label116:
      axiy.i("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 CaptureQmcfSoDownloadActivity");
      CaptureQmcfSoDownloadActivity.a(paramContext, awsy.class.getName(), localBundle, localBundle.getBoolean("resource_need_all_wait", false));
    }
  }
  
  public void h(Context paramContext, Bundle paramBundle)
  {
    if (getQQAppInterface().bF())
    {
      axiy.w("Q.qqstory.publish.StoryPublishLauncher", "【2131720263】");
      QQToast.a(paramContext, 0, 2131720263, 0).show();
      QLog.e("Q.qqstory.publish.StoryPublishLauncher", 1, "launchForPreview failed: isVideoChatting");
      return;
    }
    if (aA(paramContext))
    {
      QLog.e("Q.qqstory.publish.StoryPublishLauncher", 1, "launchForPreview failed: not support short video");
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    aW(localBundle);
    QIMCameraCaptureActivity.g(paramContext, localBundle);
  }
  
  @Deprecated
  public boolean isSupport()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rnq
 * JD-Core Version:    0.7.0.1
 */
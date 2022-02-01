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
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class zcf
{
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
      ykq.c("Q.qqstory.publish.StoryPublishLauncher", "initLaunchArgs captureMode=%s, tabType=%d, category=%d, itemId=%s, openSpecific=%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString1, Boolean.valueOf(paramBoolean) });
      return paramBundle;
      if (paramInt2 == 3) {
        paramBundle.putString("story_capture_album_id", paramString3);
      }
    }
  }
  
  public static Bundle a(SessionWrap paramSessionWrap, String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ARG_SESSION_INFO", paramSessionWrap);
    localBundle.putInt("edit_video_type", paramInt1);
    localBundle.putInt("entrance_type", paramInt2);
    localBundle.putString("ARG_AIO_CLASS", paramString);
    if (paramInt1 == 10000) {
      localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    }
    localBundle.putBoolean("enable_local_video", false);
    return localBundle;
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new AndroidRuntimeException("mobile qq main process only");
  }
  
  public static zcf a()
  {
    return new zcf();
  }
  
  private void a(boolean paramBoolean)
  {
    int i = bnky.a(bnkt.b);
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
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actShortVideoSoDownload", true, 0L, 0L, localHashMap, "");
      }
    }
    else
    {
      i = bnky.a(bnkt.c);
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
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actShortVideoPtuSoDownload", true, 0L, 0L, localHashMap, "");
      QQStoryContext.a().b();
      return;
      i = 0;
      break;
      str = "0";
      break label55;
      str = "0";
      break label71;
    }
  }
  
  private boolean a(Context paramContext)
  {
    boolean bool = false;
    if (!bbhm.a())
    {
      ykq.b("Q.qqstory.publish.StoryPublishLauncher", "checkApiVersionDialog false");
      bhdj.a(paramContext, 230).setMessage(anvx.a(2131713936)).setPositiveButton(2131694399, new zcg(this)).show();
      bool = true;
    }
    return bool;
  }
  
  public static boolean b()
  {
    return bdee.a(a(), BaseApplicationImpl.getContext());
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (a().isVideoChatting())
    {
      bnrh.c("Q.qqstory.publish.StoryPublishLauncher", "【2131718854】");
      QQToast.a(paramActivity, 0, 2131718854, 0).a();
    }
    while (a(paramActivity)) {
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    boolean bool;
    if (localBundle.getInt("entrance_type") == 104)
    {
      bool = bptq.a(a());
      a(localBundle);
      if (!bool) {
        break label114;
      }
      bnrh.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 QIMCameraCaptureActivity");
      QIMCameraCaptureActivity.a(paramActivity, localBundle, paramInt);
    }
    for (;;)
    {
      a(bool);
      return;
      bool = bnlf.a();
      break;
      label114:
      bnrh.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 CaptureQmcfSoDownloadActivity");
      CaptureQmcfSoDownloadActivity.a(paramActivity, bmul.class.getName(), localBundle, paramInt, localBundle.getBoolean("resource_need_all_wait", false));
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt5)
  {
    a(paramActivity, a(paramBundle, paramInt1, paramInt2, paramInt3, paramInt4, paramString1, paramString2, paramString3, paramBoolean), paramInt5);
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    if (a().isVideoChatting())
    {
      bnrh.c("Q.qqstory.publish.StoryPublishLauncher", "【2131718854】");
      QQToast.a(paramContext, 0, 2131718854, 0).a();
    }
    while (a(paramContext)) {
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    boolean bool;
    if (localBundle.getInt("entrance_type") == 104)
    {
      bool = bptq.a(a());
      a(localBundle);
      if (!bool) {
        break label109;
      }
      bnrh.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 QIMCameraCaptureActivity");
      QIMCameraCaptureActivity.a(paramContext, localBundle);
    }
    for (;;)
    {
      a(bool);
      return;
      bool = bnlf.a();
      break;
      label109:
      bnrh.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 CaptureQmcfSoDownloadActivity");
      CaptureQmcfSoDownloadActivity.a(paramContext, bmul.class.getName(), localBundle, localBundle.getBoolean("resource_need_all_wait", false));
    }
  }
  
  public void a(@NonNull Bundle paramBundle)
  {
    if (!paramBundle.containsKey("entrance_type")) {
      ykq.b("Q.qqstory.publish.StoryPublishLauncher", "do not has entrance type", new Throwable());
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
    paramBundle.putBoolean("camera_peak_is_alive", bmux.a(BaseApplicationImpl.getContext()));
  }
  
  @Deprecated
  public boolean a()
  {
    return true;
  }
  
  public boolean a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    boolean bool2 = true;
    if (a().isVideoChatting())
    {
      QQToast.a(paramActivity, 0, 2131718854, 0).a();
      bool2 = false;
      return bool2;
    }
    if (a(paramActivity)) {
      return false;
    }
    boolean bool1;
    if ((paramBundle != null) && (paramBundle.getInt("entrance_type") == 104))
    {
      bool1 = bptq.a(a());
      label63:
      ykq.a("Q.qqstory.publish.StoryPublishLauncher", "launchForResult, videoSoUsable=%s, filterOk=%s", Boolean.valueOf(bool1), Boolean.valueOf(b()));
      QQStoryContext.a().b();
      if (paramBundle != null) {
        break label134;
      }
      paramBundle = new Bundle();
    }
    label134:
    for (;;)
    {
      a(paramBundle);
      if (bool1) {
        break;
      }
      CaptureQmcfSoDownloadActivity.a(paramActivity, bmul.class.getName(), paramBundle, paramInt, true, true);
      return false;
      bool1 = bnlf.a();
      break label63;
    }
  }
  
  public void b(Context paramContext, Bundle paramBundle)
  {
    if (a().isVideoChatting())
    {
      bnrh.c("Q.qqstory.publish.StoryPublishLauncher", "【2131718854】");
      QQToast.a(paramContext, 0, 2131718854, 0).a();
      QLog.e("Q.qqstory.publish.StoryPublishLauncher", 1, "launchForPreview failed: isVideoChatting");
      return;
    }
    if (a(paramContext))
    {
      QLog.e("Q.qqstory.publish.StoryPublishLauncher", 1, "launchForPreview failed: not support short video");
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    a(localBundle);
    QIMCameraCaptureActivity.a(paramContext, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zcf
 * JD-Core Version:    0.7.0.1
 */
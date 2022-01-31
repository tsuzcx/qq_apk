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

public class xpk
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
      wxe.c("Q.qqstory.publish.StoryPublishLauncher", "initLaunchArgs captureMode=%s, tabType=%d, category=%d, itemId=%s, openSpecific=%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString1, Boolean.valueOf(paramBoolean) });
      return paramBundle;
      if (paramInt2 == 3) {
        paramBundle.putString("story_capture_album_id", paramString3);
      }
    }
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new AndroidRuntimeException("mobile qq main process only");
  }
  
  public static xpk a()
  {
    return new xpk();
  }
  
  private void a(boolean paramBoolean)
  {
    int i = azkt.a(BaseApplicationImpl.getContext());
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
        azri.a(BaseApplication.getContext()).a("", "actShortVideoSoDownload", true, 0L, 0L, localHashMap, "");
      }
    }
    else
    {
      i = azdw.a(BaseApplicationImpl.getContext());
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
      azri.a(BaseApplication.getContext()).a("", "actShortVideoPtuSoDownload", true, 0L, 0L, localHashMap, "");
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
    if (!axpm.a())
    {
      wxe.b("Q.qqstory.publish.StoryPublishLauncher", "checkApiVersionDialog false");
      bdgm.a(paramContext, 230).setMessage(alud.a(2131714947)).setPositiveButton(2131694953, new xpl(this)).show();
      bool = true;
    }
    return bool;
  }
  
  public static boolean b()
  {
    return azkt.a(a(), BaseApplicationImpl.getContext());
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (a().c())
    {
      bljn.c("Q.qqstory.publish.StoryPublishLauncher", "【2131720131】");
      QQToast.a(paramActivity, 0, 2131720131, 0).a();
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
      bool = bnsn.a(a());
      a(localBundle);
      blap.a().a(true);
      if (!bool) {
        break label120;
      }
      bljn.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 QIMCameraCaptureActivity");
      QIMCameraCaptureActivity.a(paramActivity, localBundle, paramInt);
    }
    for (;;)
    {
      a(bool);
      return;
      bool = blax.a();
      break;
      label120:
      bljn.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 CaptureQmcfSoDownloadActivity");
      CaptureQmcfSoDownloadActivity.a(paramActivity, bkoa.class.getName(), localBundle, paramInt, localBundle.getBoolean("resource_need_all_wait", false));
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt5)
  {
    a(paramActivity, a(paramBundle, paramInt1, paramInt2, paramInt3, paramInt4, paramString1, paramString2, paramString3, paramBoolean), paramInt5);
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    if (a().c())
    {
      bljn.c("Q.qqstory.publish.StoryPublishLauncher", "【2131720131】");
      QQToast.a(paramContext, 0, 2131720131, 0).a();
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
      bool = bnsn.a(a());
      a(localBundle);
      blap.a().a(true);
      if (!bool) {
        break label115;
      }
      bljn.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 QIMCameraCaptureActivity");
      QIMCameraCaptureActivity.a(paramContext, localBundle);
    }
    for (;;)
    {
      a(bool);
      return;
      bool = blax.a();
      break;
      label115:
      bljn.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 CaptureQmcfSoDownloadActivity");
      CaptureQmcfSoDownloadActivity.a(paramContext, bkoa.class.getName(), localBundle, localBundle.getBoolean("resource_need_all_wait", false));
    }
  }
  
  public void a(@NonNull Bundle paramBundle)
  {
    if (!paramBundle.containsKey("entrance_type")) {
      wxe.b("Q.qqstory.publish.StoryPublishLauncher", "do not has entrance type", new Throwable());
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
    paramBundle.putBoolean("camera_peak_is_alive", bkny.a(BaseApplicationImpl.getContext()));
  }
  
  @Deprecated
  public boolean a()
  {
    return true;
  }
  
  public boolean a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    boolean bool2 = true;
    if (a().c())
    {
      QQToast.a(paramActivity, 0, 2131720131, 0).a();
      bool2 = false;
      return bool2;
    }
    if (a(paramActivity)) {
      return false;
    }
    boolean bool1;
    if ((paramBundle != null) && (paramBundle.getInt("entrance_type") == 104))
    {
      bool1 = bnsn.a(a());
      label63:
      wxe.a("Q.qqstory.publish.StoryPublishLauncher", "launchForResult, videoSoUsable=%s, filterOk=%s", Boolean.valueOf(bool1), Boolean.valueOf(b()));
      QQStoryContext.a().b();
      if (paramBundle != null) {
        break label133;
      }
      paramBundle = new Bundle();
    }
    label133:
    for (;;)
    {
      a(paramBundle);
      if (bool1) {
        break;
      }
      CaptureQmcfSoDownloadActivity.a(paramActivity, bkoa.class.getName(), paramBundle, paramInt, true, true);
      return false;
      bool1 = blax.a();
      break label63;
    }
  }
  
  public void b(Context paramContext, Bundle paramBundle)
  {
    if (a().c())
    {
      bljn.c("Q.qqstory.publish.StoryPublishLauncher", "【2131720131】");
      QQToast.a(paramContext, 0, 2131720131, 0).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xpk
 * JD-Core Version:    0.7.0.1
 */
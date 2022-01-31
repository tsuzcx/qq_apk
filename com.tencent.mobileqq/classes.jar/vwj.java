import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.AndroidRuntimeException;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher.1;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class vwj
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
      ved.c("Q.qqstory.publish.StoryPublishLauncher", "initLaunchArgs captureMode=%s, tabType=%d, category=%d, itemId=%s, openSpecific=%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString1, Boolean.valueOf(paramBoolean) });
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
  
  public static vwj a()
  {
    return new vwj();
  }
  
  private void a(boolean paramBoolean)
  {
    int i = axle.a(BaseApplicationImpl.getContext());
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
        axrn.a(BaseApplication.getContext()).a("", "actShortVideoSoDownload", true, 0L, 0L, localHashMap, "");
      }
    }
    else
    {
      i = axeh.a(BaseApplicationImpl.getContext());
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
      axrn.a(BaseApplication.getContext()).a("", "actShortVideoPtuSoDownload", true, 0L, 0L, localHashMap, "");
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
    if (!avte.a())
    {
      ved.b("Q.qqstory.publish.StoryPublishLauncher", "checkApiVersionDialog false");
      bbdj.a(paramContext, 230).setMessage(ajya.a(2131714563)).setPositiveButton(2131694794, new vwk(this)).show();
      bool = true;
    }
    return bool;
  }
  
  public static boolean b()
  {
    return (blcr.b(a())) && (axle.a(BaseApplicationImpl.getContext()) != 2);
  }
  
  public static boolean c()
  {
    return axle.a(a(), BaseApplicationImpl.getContext());
  }
  
  public Intent a(Activity paramActivity, Bundle paramBundle)
  {
    paramActivity = new Intent(paramActivity, PhotoListActivity.class);
    paramActivity.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    paramActivity.putExtra("from_qqstory", true);
    paramActivity.putExtra("ALBUM_NAME", bbbw.l);
    paramActivity.putExtra("ALBUM_ID", "$RecentAlbumId");
    paramActivity.putExtra("video_refer", "qqstory");
    paramActivity.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    paramActivity.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
    paramActivity.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramActivity.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LocalVideoSelectActivity.class.getName());
    paramActivity.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramActivity.putExtra("bundle_extra", paramBundle);
    return paramActivity;
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (a().c())
    {
      bjah.c("Q.qqstory.publish.StoryPublishLauncher", "【2131719587】");
      bcql.a(paramActivity, 0, 2131719587, 0).a();
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
      bool = blcr.a(a());
      a(localBundle);
      birq.a().a(true);
      if (!bool) {
        break label124;
      }
      bjah.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 QIMCameraCaptureActivity");
      QIMCameraCaptureActivity.a(paramActivity, localBundle, paramInt);
    }
    for (;;)
    {
      a(bool);
      return;
      bool = b();
      break;
      label124:
      bjah.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 CaptureQmcfSoDownloadActivity");
      CaptureQmcfSoDownloadActivity.a(paramActivity, bihx.class.getName(), localBundle, paramInt, localBundle.getBoolean("resource_need_all_wait", false));
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
      bjah.c("Q.qqstory.publish.StoryPublishLauncher", "【2131719587】");
      bcql.a(paramContext, 0, 2131719587, 0).a();
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
      bool = blcr.a(a());
      a(localBundle);
      birq.a().a(true);
      if (!bool) {
        break label119;
      }
      bjah.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 QIMCameraCaptureActivity");
      QIMCameraCaptureActivity.a(paramContext, localBundle);
    }
    for (;;)
    {
      a(bool);
      return;
      bool = b();
      break;
      label119:
      bjah.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 CaptureQmcfSoDownloadActivity");
      CaptureQmcfSoDownloadActivity.a(paramContext, bihx.class.getName(), localBundle, localBundle.getBoolean("resource_need_all_wait", false));
    }
  }
  
  public void a(@NonNull Bundle paramBundle)
  {
    if (!paramBundle.containsKey("entrance_type")) {
      ved.b("Q.qqstory.publish.StoryPublishLauncher", "do not has entrance type", new Throwable());
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
    paramBundle.putBoolean("camera_peak_is_alive", bihv.a(BaseApplicationImpl.getContext()));
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
      bcql.a(paramActivity, 0, 2131719587, 0).a();
      bool2 = false;
      return bool2;
    }
    if (a(paramActivity)) {
      return false;
    }
    boolean bool1;
    if ((paramBundle != null) && (paramBundle.getInt("entrance_type") == 104))
    {
      bool1 = blcr.a(a());
      label65:
      ved.a("Q.qqstory.publish.StoryPublishLauncher", "launchForResult, videoSoUsable=%s, filterOk=%s", Boolean.valueOf(bool1), Boolean.valueOf(c()));
      QQStoryContext.a().b();
      if (paramBundle != null) {
        break label136;
      }
      paramBundle = new Bundle();
    }
    label136:
    for (;;)
    {
      a(paramBundle);
      if (bool1) {
        break;
      }
      CaptureQmcfSoDownloadActivity.a(paramActivity, bihx.class.getName(), paramBundle, paramInt, true, true);
      return false;
      bool1 = b();
      break label65;
    }
  }
  
  public void b(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    ved.b("Q.qqstory.publish.StoryPublishLauncher", "launchAlbumThenEditThenPublishForResult");
    vwl.a("Q.qqstory.publish.StoryPublishLauncher", paramBundle);
    if (a(paramActivity)) {
      return;
    }
    boolean bool = b();
    ved.a("Q.qqstory.publish.StoryPublishLauncher", "videoSoUsable=%s", Boolean.valueOf(bool));
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (bool)
    {
      paramActivity.startActivityForResult(a(paramActivity, localBundle), paramInt);
      return;
    }
    a(paramActivity, localBundle, paramInt);
  }
  
  public void b(Context paramContext, Bundle paramBundle)
  {
    if (a().c())
    {
      bjah.c("Q.qqstory.publish.StoryPublishLauncher", "【2131719587】");
      bcql.a(paramContext, 0, 2131719587, 0).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vwj
 * JD-Core Version:    0.7.0.1
 */
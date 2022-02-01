import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.jsp.AECameraPlugin.a;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import java.util.LinkedList;
import java.util.List;

public class axcj
{
  private static long lastClickTime;
  
  private static boolean J(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return false;
    }
    if (!aczy.bd(paramActivity)) {}
    for (int i = 1;; i = 0)
    {
      LinkedList localLinkedList = new LinkedList();
      if (i != 0)
      {
        localLinkedList.add("android.permission.READ_EXTERNAL_STORAGE");
        localLinkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
      }
      if (localLinkedList.size() <= 0) {
        break;
      }
      alle.requestPermissions(paramActivity, (String[])localLinkedList.toArray(new String[0]), 1);
      return true;
    }
  }
  
  private static boolean K(Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1;
    if (((alwt.auI()) || (paramBundle.getInt("VIDEO_STORY_JUMP_TO_TYPE", 0) == 0)) && ((paramBundle.getInt("AECAMERA_MODE") != 202) || (!aeah.agb())))
    {
      bool1 = bool2;
      if (paramBundle.getInt("AECAMERA_MODE") == 203)
      {
        bool1 = bool2;
        if (!aeah.agb()) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, AECameraPlugin.a parama)
  {
    if (qH()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("VIDEO_STORY_FROM_TYPE", paramInt2);
    localBundle.putInt("AECAMERA_MODE", 200);
    localBundle.putInt("ability_flag", 2);
    localBundle.putInt("edit_video_type", 10023);
    if (parama != null)
    {
      localBundle.putBoolean("key_camera_prefer_id", parama.ckp);
      localBundle.putBoolean("key_has_countdown", parama.ckq);
      localBundle.putBoolean("key_disable_face_detect", parama.cks);
      localBundle.putBoolean("key_need_check_sensitive", parama.ckr);
      localBundle.putString("key_guide_image", parama.bNR);
    }
    QIMCameraCaptureActivity.a(paramActivity, localBundle, paramInt1);
    paramActivity.overridePendingTransition(2130772306, 2130772079);
  }
  
  public static boolean aOt()
  {
    if (!anfi.awy()) {}
    for (;;)
    {
      return false;
      if ((azby.C(axol.getAppInterface())) && (ankq.aB(BaseApplicationImpl.getContext()) != 2)) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
  }
  
  public static void b(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if (qH()) {
      return;
    }
    axgk.a().acy("AECameraLauncher---launchAECameraUnit-begin");
    rnq localrnq = rnq.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("entrance_type", paramInt);
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (K(localBundle))
    {
      axiy.i("AECameraLauncher", "isOpenFrontFirst: true");
      alwt.Ty(1);
    }
    alwt.dKq();
    localrnq.a(paramActivity, localBundle, 20000);
    paramActivity.overridePendingTransition(2130772306, 2130772079);
    rar.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
    axgk.a().acy("AECameraLauncher---launchAECameraUnit-end");
    axgk.a().print(false);
    axgk.a().eJy();
  }
  
  public static void k(Context paramContext, Bundle paramBundle)
  {
    if (qH()) {
      return;
    }
    rnq localrnq = rnq.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (K(localBundle))
    {
      axiy.i("AECameraLauncher", "isOpenFrontFirst: true");
      alwt.Ty(1);
    }
    localrnq.g(paramContext, localBundle);
    rar.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
  }
  
  private static boolean qH()
  {
    long l = System.currentTimeMillis();
    QLog.d("AECameraLauncher", 2, "pre: " + lastClickTime + " cur: " + l);
    if (Math.abs(l - lastClickTime) < 500L)
    {
      QLog.d("AECameraLauncher", 2, "isFastClick.");
      lastClickTime = l;
      return true;
    }
    lastClickTime = l;
    return false;
  }
  
  public static void v(Activity paramActivity, @Nullable Bundle paramBundle)
  {
    axiy.d("AECameraLauncher", "[AE Profiler] launchAECameraFromCircle");
    paramBundle = w(paramBundle);
    rnq.a().a(paramActivity, paramBundle, 20000);
    paramActivity.overridePendingTransition(2130772306, 2130772079);
  }
  
  private static Bundle w(@Nullable Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = localBundle.getString("material_id");
    if (!TextUtils.isEmpty(paramBundle))
    {
      paramBundle = paramBundle.split("\\^");
      if (paramBundle.length == 2) {
        localBundle.putString("KEY_CURRENT_SELECT_ID", paramBundle[1]);
      }
    }
    localBundle.putInt("AECAMERA_MODE", 200);
    if (!localBundle.containsKey("VIDEO_STORY_FROM_TYPE")) {
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", axcg.x.getId());
    }
    localBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
    Object localObject = localBundle.getString("qq_camera_from_qcircle_scheme");
    paramBundle = localBundle;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = Uri.parse((String)localObject);
      paramBundle = localBundle;
      if (localObject != null)
      {
        localBundle.putString("tab", ((Uri)localObject).getQueryParameter("tab"));
        localBundle = aywz.e(localBundle, ((Uri)localObject).getQueryParameter("widgetinfo"));
        localBundle.putString("VIDEO_STORY_ACTIVITY_ID", ((Uri)localObject).getQueryParameter("activity_id"));
        localObject = ((Uri)localObject).getQueryParameter("editor_filter_id");
        paramBundle = localBundle;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localBundle.putString("editor_filter_id", (String)localObject);
          paramBundle = localBundle;
        }
      }
    }
    paramBundle.putInt("entrance_type", 120);
    paramBundle.putInt("edit_video_type", 10026);
    paramBundle.putInt("capture_intent_mode", 8);
    return paramBundle;
  }
  
  public static void w(Activity paramActivity, @Nullable Bundle paramBundle)
  {
    if (!J(paramActivity))
    {
      if ((aOt()) && (Build.VERSION.SDK_INT >= 21)) {
        v(paramActivity, paramBundle);
      }
    }
    else {
      return;
    }
    axja.B(paramActivity, new Intent().putExtras(paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axcj
 * JD-Core Version:    0.7.0.1
 */
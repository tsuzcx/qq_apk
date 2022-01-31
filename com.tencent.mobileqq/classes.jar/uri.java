import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.activity.richmedia.MX3FlowNewCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;

public class uri
{
  public static Intent a(Context paramContext, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      Object localObject = NewFlowCameraActivity.class;
      if (azhf.d(azhf.c)) {
        localObject = MX3FlowNewCameraActivity.class;
      }
      paramIntent.setComponent(new ComponentName(paramContext, (Class)localObject));
      PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("camera_photo_path", paramString1).commit();
      paramIntent.putExtra("qcamera_photo_filepath", paramString1);
      paramIntent.putExtra("support_photo_merge", true);
      paramIntent.putExtra("activity_start_time", SystemClock.elapsedRealtime());
      paramIntent.putExtra("video_min_frame_count", 3);
      paramIntent.putExtra("PhotoConst.MY_UIN", paramString2);
      paramIntent.putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
      paramIntent.putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
      paramIntent.putExtra("flow_show_filter_red", paramBoolean2);
      paramIntent.putExtra("flow_show_filter_red_pkg", paramBoolean3);
      paramIntent.putExtra("edit_video_type", 10002);
      paramIntent.putExtra("set_user_callback", QQStoryFlowCallback.class.getCanonicalName());
      paramIntent.putExtra("enable_local_video", true);
      paramIntent.putExtra("short_video_refer", "qqstory");
      paramIntent.putExtra("flow_camera_video_mode", true);
      paramIntent.putExtra("flow_camera_use_filter_function", paramBoolean4);
      paramIntent.putExtra("flow_camera_use_3dfilter_function", azkm.a(false));
      paramIntent.putExtra("ignore_dpc_duration", true);
      paramIntent.putExtra("video_duration", 10);
      return paramIntent;
    }
    paramIntent.setComponent(new ComponentName(paramContext, NewPreFlowCamera.class));
    paramIntent.putExtra("qcamera_photo_filepath", paramString1);
    paramIntent.putExtra("edit_video_type", 10002);
    paramIntent.putExtra("support_photo_merge", true);
    paramIntent.putExtra("video_min_frame_count", 3);
    paramIntent.putExtra("flow_show_filter_red", paramBoolean2);
    paramIntent.putExtra("flow_show_filter_red_pkg", paramBoolean3);
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uri
 * JD-Core Version:    0.7.0.1
 */
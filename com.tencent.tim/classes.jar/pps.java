import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.MX3FlowNewCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;

public class pps
{
  public static class a
  {
    public static Intent a(Context paramContext, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2)
    {
      if (paramBoolean1)
      {
        Object localObject = NewFlowCameraActivity.class;
        if (anii.isFoundProduct(anii.KEY_NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL)) {
          localObject = MX3FlowNewCameraActivity.class;
        }
        paramIntent.setComponent(new ComponentName(paramContext, (Class)localObject));
        PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("camera_photo_path", paramString1).commit();
        paramIntent.putExtra("qcamera_photo_filepath", paramString1);
        paramIntent.putExtra("support_photo_merge", true);
        paramIntent.putExtra("activity_start_time", SystemClock.elapsedRealtime());
        paramIntent.putExtra("video_min_frame_count", 3);
        paramIntent.putExtra("PhotoConst.MY_UIN", paramString2);
        paramIntent.putExtra("sv_config", DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
        paramIntent.putExtra("sv_whitelist", DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
        paramIntent.putExtra("flow_show_filter_red", paramBoolean2);
        paramIntent.putExtra("flow_show_filter_red_pkg", paramBoolean3);
        paramIntent.putExtra("edit_video_type", 10002);
        paramIntent.putExtra("set_user_callback", QQStoryFlowCallback.class.getCanonicalName());
        paramIntent.putExtra("enable_local_video", true);
        paramIntent.putExtra("short_video_refer", "qqstory");
        paramIntent.putExtra("flow_camera_video_mode", true);
        paramIntent.putExtra("flow_camera_use_filter_function", paramBoolean4);
        paramIntent.putExtra("flow_camera_use_3dfilter_function", ankl.bp(false));
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
  
  public static class b
  {
    public static void a(MSFServlet paramMSFServlet, Intent paramIntent, boolean paramBoolean) {}
    
    public static void b(SparseIntArray paramSparseIntArray)
    {
      int[][] arrayOfInt = ppk.a.o;
      int j = arrayOfInt.length;
      int i = 0;
      if (i < j)
      {
        int[] arrayOfInt1 = arrayOfInt[i];
        int k = arrayOfInt1[0];
        int m = arrayOfInt1[1];
        if (k != -1) {
          paramSparseIntArray.put(ppf.getInteger(k), m);
        }
        for (;;)
        {
          i += 1;
          break;
          paramSparseIntArray.put(m, m);
        }
      }
    }
  }
  
  public static class c
  {
    public static boolean a(QQStoryAutoPlayView paramQQStoryAutoPlayView, MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  public static class d
  {
    public static String a(QQUserUIItem paramQQUserUIItem)
    {
      paramQQUserUIItem = qem.getQQAppInterface();
      return paramQQUserUIItem.getApplication().getSharedPreferences("public_account_qq_mail_" + paramQQUserUIItem.getCurrentAccountUin(), 0).getString("key_story_qim_online_icon_url", null);
    }
    
    public static String b(QQUserUIItem paramQQUserUIItem)
    {
      paramQQUserUIItem = qem.getQQAppInterface();
      return paramQQUserUIItem.getApplication().getSharedPreferences("public_account_qq_mail_" + paramQQUserUIItem.getCurrentAccountUin(), 0).getString("profile_card_qim_online_url", null);
    }
  }
  
  public static class e
  {
    public static boolean a(StoryVideoItem paramStoryVideoItem)
    {
      return false;
    }
    
    public static boolean fc(String paramString)
    {
      return false;
    }
    
    public static boolean q(String paramString, boolean paramBoolean)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pps
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.io.File;

@Deprecated
public class qqy
{
  @NonNull
  private final QQAppInterface mApp;
  
  public qqy(@NonNull QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public Intent a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramContext, paramBoolean1, paramBoolean2, new Intent());
  }
  
  public Intent a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Intent paramIntent)
  {
    boolean bool1 = false;
    paramIntent.putExtra("videoIsUsable", paramBoolean2);
    Object localObject1 = (altq)this.mApp.getManager(36);
    Object localObject2 = ((altq)localObject1).getAppInfoByPath("103100.103500.103501");
    if (localObject2 != null) {
      if (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1) {
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_sp", 4);
      if (((SharedPreferences)localObject2).getBoolean("flow_filter_reddot_key", false))
      {
        ((altq)localObject1).OS("103100.103500.103501");
        ((SharedPreferences)localObject2).edit().putBoolean("flow_filter_reddot_key", false).commit();
        paramBoolean1 = false;
      }
      for (;;)
      {
        if (!BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_pkg_sp" + this.mApp.getCurrentAccountUin(), 4).getBoolean("flow_filter_reddot_key", false)) {
          bool1 = true;
        }
        boolean bool2 = ankq.f(this.mApp, BaseApplicationImpl.getContext());
        localObject1 = wmj.hp(plr.atc);
        localObject2 = new File(acbn.SDCARD_IMG_CAMERA);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        return ppg.a.a(paramContext, paramBoolean2, paramIntent, paramBoolean1, bool1, bool2, (String)localObject1, this.mApp.getAccount());
        paramBoolean1 = false;
        break;
      }
      paramBoolean1 = false;
    }
  }
  
  public void bj(@NonNull Intent paramIntent)
  {
    paramIntent.putExtra("short_video_refer", "qqstory");
    paramIntent.putExtra("set_user_callback", QQStoryFlowCallback.class.getCanonicalName());
    paramIntent.putExtra("enable_local_video", true);
    paramIntent.putExtra("ignore_dpc_duration", true);
    paramIntent.putExtra("video_duration", 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqy
 * JD-Core Version:    0.7.0.1
 */
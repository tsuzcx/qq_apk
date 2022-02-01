package cooperation.dingdong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import arhz;
import atni;
import avfw;
import avfw.d;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

public class DingdongPluginProxyActivity
  extends PluginProxyActivity
{
  public static void a(String paramString1, Activity paramActivity, String paramString2, Intent paramIntent, int paramInt, arhz paramarhz)
  {
    boolean bool = atni.cy(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("DingdongPluginProxyActivity", 2, "launchPluginActivityForResult.isDingdongProcessExist=" + bool);
    }
    if (!bool)
    {
      paramarhz = new arhz(paramActivity);
      paramarhz.setMessage(2131697007);
    }
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("big_brother_source_key", "biz_src_jc_select_member");
    paramIntent.putExtra("useSkinEngine", true);
    avfw.d locald = new avfw.d(0);
    locald.mUin = paramString1;
    locald.mPluginID = "dingdong_plugin.apk";
    locald.mPluginName = PluginInfo.cKF;
    locald.cKu = paramString2;
    locald.K = e(paramString2);
    locald.mIntent = paramIntent;
    locald.mRequestCode = paramInt;
    locald.mDialog = paramarhz;
    locald.mTimeOut = 10000;
    locald.cKv = null;
    avfw.a(paramActivity, locald);
  }
  
  private static Class<? extends PluginProxyActivity> e(String paramString)
  {
    return DingdongPluginProxyActivity.class;
  }
  
  public String getPluginID()
  {
    return "dingdong_plugin.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return e(paramString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((!TextUtils.isEmpty(this.mCreateErrorInfo)) && (!this.mCreateErrorInfo.equals("success")) && (QLog.isColorLevel()))
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = getIntent().getExtras();
      }
      paramBundle = localBundle.getString("pluginsdk_launchActivity");
      QLog.e("DingdongPluginProxyActivity", 2, "start plugin error: launch_activity_name=" + paramBundle + ", error_msg=" + this.mCreateErrorInfo);
    }
  }
  
  public static class ApprovalActivity
    extends DingdongPluginProxyActivity
  {}
  
  public static class DingActivity
    extends DingdongPluginProxyActivity
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.dingdong.DingdongPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */
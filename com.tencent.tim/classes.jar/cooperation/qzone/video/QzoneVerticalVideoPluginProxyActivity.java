package cooperation.qzone.video;

import aeee;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import arlc;
import avfw;
import avfw.d;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.qphone.base.util.QLog;

public class QzoneVerticalVideoPluginProxyActivity
  extends PluginProxyFragmentActivity
{
  private static final String TAG = QzoneVerticalVideoPluginProxyActivity.class.getSimpleName();
  private static final String[] iX = new String[0];
  
  public static void d(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Class localClass = a.g("com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity");
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    avfw.d locald = new avfw.d(0);
    locald.mUin = paramString;
    locald.cKu = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
    locald.K = localClass;
    locald.mIntent = paramIntent;
    locald.mRequestCode = paramInt;
    locald.mTimeOut = 15000;
    locald.cKv = null;
    locald.dmV = false;
    locald.mPluginID = "qzone_vertical_video_plugin.apk";
    locald.mPluginName = "QZoneVerticalVideo";
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "加载原始插件");
    }
    avfw.a(paramActivity, locald);
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "QzoneVerticalVideoPluginProxyActivity.launchPluginActivityForResult");
    }
  }
  
  private static boolean d(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public String getPluginID()
  {
    return "qzone_vertical_video_plugin.apk";
  }
  
  public int getPluginResType()
  {
    return 2;
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return a.g(paramString);
  }
  
  public int getThemeResId()
  {
    return 0;
  }
  
  public void handleCrash(Bundle paramBundle, Throwable paramThrowable)
  {
    super.handleCrash(paramBundle, paramThrowable);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    arlc.b(BaseApplicationImpl.getContext(), false, 5);
    aeee.e(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void onDestroy()
  {
    aeee.e(BaseApplicationImpl.getContext(), 2, true);
    super.onDestroy();
  }
  
  static class a
  {
    public static Class<? extends PluginProxyActivity> g(String paramString)
    {
      if (QzoneVerticalVideoPluginProxyActivity.e(QzoneVerticalVideoPluginProxyActivity.iX, paramString)) {
        return QzoneVerticalVideoTransparentActivity.class;
      }
      return QzoneVerticalVideoGpuProxyActivity.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */
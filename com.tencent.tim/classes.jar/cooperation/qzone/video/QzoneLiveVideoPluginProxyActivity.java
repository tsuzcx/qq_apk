package cooperation.qzone.video;

import aeee;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import arlc;
import avfw;
import avfw.d;
import avxl;
import avxl.b;
import avyo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QzoneLiveVideoPluginProxyActivity
  extends PluginProxyActivity
{
  private static final String[] iX = { "com.qzone.adapter.livevideo.RewardGiftActivity", "com.qzonex.module.global.FeedActionPanelActivity", "com.qzone.adapter.livevideo.LiveCommonActivity" };
  Object gi = null;
  
  public static void a(Activity paramActivity, String paramString1, Intent paramIntent, int paramInt, String paramString2)
  {
    Class localClass = a.g(paramString2);
    paramIntent.putExtra("userQqResources", -1);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject = avyo.GF();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject);
    }
    for (;;)
    {
      return;
      if (((String)localObject).equals("qzone_live_video_plugin_hack.apk")) {
        if (new File(avyo.getPluginInstallDir(paramActivity), (String)localObject).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:" + (String)localObject);
          }
          localObject = new avxl.b(0);
          ((avxl.b)localObject).mUin = paramString1;
          ((avxl.b)localObject).cKu = paramString2;
          ((avxl.b)localObject).K = localClass;
          ((avxl.b)localObject).mIntent = paramIntent;
          ((avxl.b)localObject).mRequestCode = paramInt;
          ((avxl.b)localObject).mTimeOut = 15000;
          ((avxl.b)localObject).cKv = null;
          ((avxl.b)localObject).dmV = false;
          ((avxl.b)localObject).mPluginID = "qzone_live_video_plugin_hack.apk";
          ((avxl.b)localObject).mPluginName = "QZoneLiveVideo";
          avxl.a(paramActivity, (avxl.b)localObject);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("PluginDebug", 2, "QzoneLiveVideoPluginProxyActivity.launchPluingActivityForResult");
        return;
        if (QLog.isColorLevel())
        {
          QLog.e("PluginDebug", 2, "launchPluginActivityForResult 加载动态包不存在");
          continue;
          if (!"qzone_live_video_plugin.apk".equals(localObject)) {
            break label355;
          }
          localObject = new avfw.d(0);
          ((avfw.d)localObject).mUin = paramString1;
          ((avfw.d)localObject).cKu = paramString2;
          ((avfw.d)localObject).K = localClass;
          ((avfw.d)localObject).mIntent = paramIntent;
          ((avfw.d)localObject).mRequestCode = paramInt;
          ((avfw.d)localObject).mTimeOut = 15000;
          ((avfw.d)localObject).cKv = null;
          ((avfw.d)localObject).dmV = false;
          ((avfw.d)localObject).mPluginID = "qzone_live_video_plugin.apk";
          ((avfw.d)localObject).mPluginName = "QZoneLiveVideo";
          if (QLog.isColorLevel()) {
            QLog.d("PluginDebug", 2, "加载原始插件");
          }
          avfw.a(paramActivity, (avfw.d)localObject);
        }
      }
    }
    label355:
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject);
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
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return a.g(paramString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    arlc.b(BaseApplicationImpl.getContext(), false, 5);
    aeee.e(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnKeyDown(paramInt, paramKeyEvent);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void requestPermissions(Object paramObject, int paramInt, String... paramVarArgs)
  {
    super.requestPermissions(paramObject, paramInt, paramVarArgs);
    this.gi = paramObject;
  }
  
  static class a
  {
    public static Class<? extends PluginProxyActivity> g(String paramString)
    {
      if (QzoneLiveVideoPluginProxyActivity.e(QzoneLiveVideoPluginProxyActivity.iX, paramString)) {
        return QzoneLiveVideoTransparentActivity.class;
      }
      return QzoneLiveVideoGpuProxyActivity.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */
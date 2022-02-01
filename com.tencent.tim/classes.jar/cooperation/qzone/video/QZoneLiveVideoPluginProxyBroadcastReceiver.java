package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import avfw;
import avfw.d;
import avxl;
import avxl.b;
import avyo;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QZoneLiveVideoPluginProxyBroadcastReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(Context paramContext, String paramString1, Intent paramIntent, String paramString2)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    paramString2 = avyo.GF();
    if (TextUtils.isEmpty(paramString2)) {
      QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + paramString2);
    }
    do
    {
      return;
      if (!paramString2.equals("qzone_live_video_plugin_hack.apk")) {
        break;
      }
    } while (!new File(avyo.getPluginInstallDir(paramContext), paramString2).exists());
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "sendBroadcast 加载动态包:hackPluginID:" + paramString2);
    }
    avxl.b localb = new avxl.b(0);
    localb.mPluginID = "qzone_live_video_plugin_hack.apk";
    localb.mPluginName = "QZoneLiveVideo";
    localb.mUin = paramString1;
    localb.cKu = "com.qzone.adapter.livevideo.LiveVideoPluginPreloadBroadcastReceiver";
    localb.mIntent = paramIntent;
    localb.mPluginID = paramString2;
    localb.mPluginName = "QZoneLiveVideo";
    avxl.b(paramContext, localb);
    return;
    if (paramString2.equals("qzone_live_video_plugin.apk"))
    {
      paramString2 = new avfw.d(0);
      paramString2.mPluginID = "qzone_live_video_plugin.apk";
      paramString2.mPluginName = "QZoneLiveVideo";
      paramString2.mUin = paramString1;
      paramString2.cKu = "com.qzone.adapter.livevideo.LiveVideoPluginPreloadBroadcastReceiver";
      paramString2.mIntent = paramIntent;
      paramString2.mPluginID = "qzone_live_video_plugin.apk";
      paramString2.mPluginName = "QZoneLiveVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      avfw.b(paramContext, paramString2);
      return;
    }
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import avfw;
import avfw.d;
import avxl;
import avxl.b;
import avyo;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QZoneLiveVideoPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString1, Intent paramIntent, ServiceConnection paramServiceConnection, String paramString2)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    Object localObject1 = avyo.GF();
    Object localObject2 = paramIntent.getAction();
    paramString2 = "";
    if ("com.qzone.preloadLiveVideo".equals(localObject2)) {
      paramString2 = "com.qzone.adapter.livevideo.LiveVideoPreloadPluginService";
    }
    do
    {
      while (TextUtils.isEmpty(paramString2))
      {
        QLog.e("PluginDebug", 1, "启动失败 conponentName 为空");
        return;
        if ("com.qzone.LiveVideoScreenRecordPluginService".equals(localObject2)) {
          paramString2 = "com.qzone.livevideo.service.LiveVideoScreenRecordPluginService";
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject1);
        return;
      }
      if (!((String)localObject1).equals("qzone_live_video_plugin_hack.apk")) {
        break;
      }
      localObject2 = new File(avyo.getPluginInstallDir(paramContext), (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "bindService 加载动态包:hackPluginID:" + (String)localObject1);
      }
    } while (!((File)localObject2).exists());
    localObject2 = new avxl.b(0);
    ((avxl.b)localObject2).mPluginID = "qzone_live_video_plugin_hack.apk";
    ((avxl.b)localObject2).mPluginName = "QZoneLiveVideo";
    ((avxl.b)localObject2).mUin = paramString1;
    ((avxl.b)localObject2).cKu = paramString2;
    ((avxl.b)localObject2).mIntent = paramIntent;
    ((avxl.b)localObject2).mServiceConnection = paramServiceConnection;
    ((avxl.b)localObject2).mPluginID = ((String)localObject1);
    ((avxl.b)localObject2).mPluginName = "QZoneLiveVideo";
    avxl.a(paramContext, (avxl.b)localObject2);
    return;
    if (((String)localObject1).equals("qzone_live_video_plugin.apk"))
    {
      localObject1 = new avfw.d(0);
      ((avfw.d)localObject1).mPluginID = "qzone_live_video_plugin.apk";
      ((avfw.d)localObject1).mPluginName = "QZoneLiveVideo";
      ((avfw.d)localObject1).mUin = paramString1;
      ((avfw.d)localObject1).cKu = paramString2;
      ((avfw.d)localObject1).mIntent = paramIntent;
      ((avfw.d)localObject1).mServiceConnection = paramServiceConnection;
      ((avfw.d)localObject1).mPluginID = "qzone_live_video_plugin.apk";
      ((avfw.d)localObject1).mPluginName = "QZoneLiveVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      avfw.c(paramContext, (avfw.d)localObject1);
      return;
    }
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */
package cooperation.liveroom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aqzv;
import aran;
import arug;
import avfw;
import avfw.d;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

public class LiveRoomProxyActivity
  extends PluginProxyActivity
  implements aqzv, aran
{
  public static final String PLUGIN_ACTIVITY_NAME = "com.tencent.gamecontent.livesdkqqplugin.plugins.QQLiveRoomPluginActivity";
  public static final String PROXY_ACTIVITY_NAME = "cooperation.liveroom.LiveRoomProxyActivity";
  private static final String TAG = "LiveRoomProxyActivity";
  private static long clickTime = -1L;
  
  public static Intent getPluginIntent(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (!paramString.contains("sonic_live=1"))
      {
        if (!paramString.contains("?")) {
          break label156;
        }
        paramString = paramString + "&sonic_live=1";
        localObject = paramString;
      }
    }
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("startOpenPageTime", clickTime);
    localIntent.putExtra("pluginFinished", System.currentTimeMillis());
    paramString = "";
    if ("com.tencent.mobileqq:tool".equals(arug.getProcessName())) {
      paramString = LiveRoomHelper.getPluginVersionInTool();
    }
    for (;;)
    {
      localIntent.putExtra("version", paramString);
      localIntent.putExtra("param_plugin_gesturelock", true);
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      return localIntent;
      label156:
      paramString = paramString + "?sonic_live=1";
      break;
      localObject = LiveRoomHelper.getPluginInfoInQQ();
      if (localObject != null) {
        paramString = ((PluginInfo)localObject).mVersion;
      }
    }
  }
  
  private static void launchPlugin(Activity paramActivity, String paramString)
  {
    QLog.d("LiveRoomProxyActivity", 1, "launchPlugin");
    avfw.d locald = new avfw.d(1);
    locald.mPluginID = "LiveRoomPlugin.apk";
    locald.mPluginName = "直播SDK";
    locald.cKu = "com.tencent.gamecontent.livesdkqqplugin.plugins.QQLiveRoomPluginActivity";
    locald.K = LiveRoomProxyActivity.class;
    locald.mRequestCode = 1011;
    locald.mIntent = getPluginIntent(paramString);
    avfw.a(paramActivity, locald);
  }
  
  public static void open(Activity paramActivity, String paramString1, String paramString2)
  {
    clickTime = System.currentTimeMillis();
    boolean bool = "com.tencent.mobileqq:tool".equals(arug.getProcessName());
    if (bool)
    {
      if (!LiveRoomHelper.getPluginInstalledInTool()) {}
    }
    else {
      while (LiveRoomHelper.isPluginInstalledInQQ())
      {
        if (QLog.isColorLevel()) {
          QLog.i("LiveRoomProxyActivity", 2, "plugin is installed, launching plugin");
        }
        launchPlugin(paramActivity, paramString1);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("LiveRoomProxyActivity", 2, "plugin is NOT installed, opening loading page");
    }
    openWebView(paramActivity, paramString1);
    if (bool)
    {
      LiveRoomPluginInstaller.getInstance().installFromTool(paramActivity, paramString2);
      return;
    }
    LiveRoomPluginInstaller.getInstance().installFromQQ(null, paramString2);
  }
  
  public static void openWebView(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("url", paramString);
    paramActivity.startActivity(localIntent);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    LiveRoomHelper.startTime = NetConnInfoCenter.getServerTimeMillis();
    LiveRoomHelper.report("proxyActivity", "launch", "load:" + LiveRoomHelper.isSDKLoaded, 0L);
    LiveRoomHelper.isSDKLoaded = true;
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    LiveRoomHelper.cleanStaticParam();
    super.onDestroy();
  }
  
  public int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    startActivityForResult(paramIntent, paramByte);
    return 0;
  }
  
  public int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomProxyActivity
 * JD-Core Version:    0.7.0.1
 */
import android.os.RemoteException;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

class aweq
  implements avyi.a
{
  aweq(aweo paramaweo, JSONObject paramJSONObject, boolean paramBoolean, String paramString) {}
  
  public void a(avxl paramavxl)
  {
    if (paramavxl == null) {
      return;
    }
    try
    {
      localPluginRecord = paramavxl.a("qzone_live_video_plugin_hack.apk");
      if ((localPluginRecord == null) || (localPluginRecord.state != 4)) {
        break label104;
      }
      this.val$result.put("isInstalled", true);
    }
    catch (JSONException paramavxl)
    {
      for (;;)
      {
        PluginRecord localPluginRecord;
        paramavxl.printStackTrace();
        return;
        if ((localPluginRecord != null) && ((localPluginRecord.state == 2) || (NetworkState.isWifiConn())))
        {
          this.val$result.put("isInstalled", false);
          if (this.dqb)
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneLiveJsPlugin", 2, " needInstall:" + this.dqb + ",需要安装插件");
            }
            paramavxl.a(localPluginRecord.id, null, 0);
          }
        }
      }
    }
    catch (RemoteException paramavxl)
    {
      paramavxl.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QZoneLiveJsPlugin", 2, " 返回结果：" + this.val$result);
    }
    this.a.f.callJs(this.val$callback, new String[] { this.val$result.toString() });
    return;
    label104:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aweq
 * JD-Core Version:    0.7.0.1
 */
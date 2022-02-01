package com.tencent.superplayer.api;

import android.text.TextUtils;
import com.tencent.superplayer.config.CacheContent;
import com.tencent.superplayer.config.ConfigManager;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class SuperPlayerSdkOption
{
  public static final boolean DEFAULT_SERVER_CONFIG_ENABLE = true;
  public int backgroundAliveTime = 30;
  public int configRequestIntervalInHour = 12;
  public String deviceId = "";
  public boolean isAsyncInit = false;
  public String serverConfig = "{\"EnableUseQuic\":true}";
  public boolean serverConfigEnable = true;
  public String uid = "";
  public String userConfig = "";
  
  private JSONObject mergeJson(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    Iterator localIterator = paramJSONObject2.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        paramJSONObject1.put(str, paramJSONObject2.get(str));
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return paramJSONObject1;
  }
  
  public static SuperPlayerSdkOption option()
  {
    return new SuperPlayerSdkOption();
  }
  
  public String getDownloadProxyConfig()
  {
    JSONObject localJSONObject3 = new JSONObject();
    try
    {
      localJSONObject3.put("AppToBackTime", this.backgroundAliveTime);
      JSONObject localJSONObject1 = new JSONObject();
      if (!TextUtils.isEmpty(this.serverConfig))
      {
        localJSONObject1 = new JSONObject(this.serverConfig);
        JSONObject localJSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(this.userConfig)) {
          localJSONObject2 = new JSONObject(this.userConfig);
        }
        mergeJson(localJSONObject3, localJSONObject1);
        mergeJson(localJSONObject3, localJSONObject2);
        return localJSONObject3.toString();
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  void loadConfigFromConfigManager()
  {
    this.serverConfig = ConfigManager.get().getConfig("sdkOption").getString("proxyConfigStr", this.serverConfig);
  }
  
  public String toString()
  {
    return "SuperPlayerSdkOption{serverConfig=" + this.serverConfig + '\n' + "userConfig=" + this.userConfig + '\n' + "deviceId=" + this.deviceId + '\n' + "uid=" + this.uid + '\n' + "serverConfigEnable=" + this.serverConfigEnable + "\nconfigRequestIntervalInHour:" + this.configRequestIntervalInHour + "\n" + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerSdkOption
 * JD-Core Version:    0.7.0.1
 */
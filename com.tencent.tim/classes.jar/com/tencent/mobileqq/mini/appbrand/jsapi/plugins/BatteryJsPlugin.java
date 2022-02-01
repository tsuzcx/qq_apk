package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.Set;
import org.json.JSONObject;

public class BatteryJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_GET_BATTERY = "getBatteryInfo";
  public static final String EVENT_GET_BATTERY_SYNC = "getBatteryInfoSync";
  private static final Set<String> S_EVENT_MAP = new BatteryJsPlugin.1();
  private static final String TAG = "[mini] BatteryJsPlugin";
  private float batteryPct;
  private int chargePlug = -1;
  private boolean isCharging;
  private PowerConnectionReceiver mPowerConnectionReceiver = new PowerConnectionReceiver();
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if (("getBatteryInfo".equals(paramString1)) || ("getBatteryInfoSync".equals(paramString1)))
    {
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("level", (int)(this.batteryPct * 100.0F));
        ((JSONObject)localObject).put("isCharging", this.isCharging);
        localObject = ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject).toString();
        if ("getBatteryInfo".equals(paramString1)) {
          paramJsRuntime.evaluateCallbackJs(paramInt, (String)localObject);
        }
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        QZLog.e("[mini] BatteryJsPlugin", 2, localThrowable, new Object[0]);
        if ("getBatteryInfo".equals(paramString1)) {
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
        }
      }
    }
    return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    paramBaseJsPluginEngine = new IntentFilter();
    paramBaseJsPluginEngine.addAction("android.intent.action.BATTERY_CHANGED");
    BaseApplicationImpl.getApplication().registerReceiver(this.mPowerConnectionReceiver, paramBaseJsPluginEngine);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.mPowerConnectionReceiver);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[mini] BatteryJsPlugin", 1, "unregisterReceiver exception.", localThrowable);
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
  
  public class PowerConnectionReceiver
    extends BroadcastReceiver
  {
    public PowerConnectionReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramIntent.getIntExtra("status", -1);
      paramContext = BatteryJsPlugin.this;
      if (paramIntent.getIntExtra("plugged", -1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        BatteryJsPlugin.access$002(paramContext, bool);
        int i = paramIntent.getIntExtra("level", 0);
        int j = paramIntent.getIntExtra("scale", 0);
        BatteryJsPlugin.access$102(BatteryJsPlugin.this, i / j);
        BatteryJsPlugin.access$202(BatteryJsPlugin.this, paramIntent.getIntExtra("plugged", -1));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BatteryJsPlugin
 * JD-Core Version:    0.7.0.1
 */
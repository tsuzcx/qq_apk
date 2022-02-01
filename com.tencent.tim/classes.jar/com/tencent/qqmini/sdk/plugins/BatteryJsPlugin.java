package com.tencent.qqmini.sdk.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
public class BatteryJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_GET_BATTERY = "getBatteryInfo";
  public static final String EVENT_GET_BATTERY_SYNC = "getBatteryInfoSync";
  private static final String TAG = "BatteryJsPlugin";
  private float batteryPct = 0.0F;
  private int chargePlug = -1;
  private boolean isCharging = false;
  private PowerConnectionReceiver mPowerConnectionReceiver = new PowerConnectionReceiver();
  
  @JsEvent({"getBatteryInfo", "getBatteryInfoSync"})
  public String getBatteryInfo(RequestEvent paramRequestEvent)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("level", (int)(this.batteryPct * 100.0F));
      ((JSONObject)localObject).put("isCharging", this.isCharging);
      localObject = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject).toString();
      if ("getBatteryInfo".equals(paramRequestEvent.event)) {
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, (String)localObject);
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("BatteryJsPlugin", localThrowable.getMessage(), localThrowable);
      if ("getBatteryInfo".equals(paramRequestEvent.event))
      {
        String str = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, str);
      }
    }
    return "";
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    paramIMiniAppContext = new IntentFilter();
    paramIMiniAppContext.addAction("android.intent.action.BATTERY_CHANGED");
    this.mContext.registerReceiver(this.mPowerConnectionReceiver, paramIMiniAppContext);
  }
  
  public void onDestroy()
  {
    try
    {
      this.mContext.unregisterReceiver(this.mPowerConnectionReceiver);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("BatteryJsPlugin", "unregisterReceiver exception.", localThrowable);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BatteryJsPlugin
 * JD-Core Version:    0.7.0.1
 */
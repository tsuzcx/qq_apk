package com.tencent.tpns.baseapi.base.util;

import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import org.json.JSONObject;

class CloudManager$1
  implements Runnable
{
  CloudManager$1(CloudManager paramCloudManager, String paramString, long paramLong) {}
  
  public void run()
  {
    try
    {
      TBaseLogger.d("CloudManager", "config: " + this.a);
      JSONObject localJSONObject = new JSONObject(this.a);
      if (localJSONObject.has("reset"))
      {
        this.c.reset();
        return;
      }
      CloudManager.a(this.c, this.a);
      CloudManager.a(this.c, localJSONObject.optLong("cloudVersion", 0L));
      CloudManager.a(this.c, localJSONObject.optInt("keepAlive", 0));
      CloudManager.b(this.c, localJSONObject.optInt("packetLoss", 0));
      CloudManager.c(this.c, localJSONObject.optInt("interval", 0));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_keepAlive", CloudManager.a(this.c));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_packetLoss", CloudManager.b(this.c));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_interval", CloudManager.c(this.c));
      if (CloudManager.d(this.c) > 0L) {
        PushPreferences.putLong(CloudManager.a(), "cloud_control_version", CloudManager.d(this.c));
      }
      CloudManager.d(this.c, localJSONObject.optInt("appAlive", 0));
      CloudManager.e(this.c, localJSONObject.optInt("losePkt", 0));
      CloudManager.b(this.c, localJSONObject.optLong("loseStart", 0L) * 1000L);
      CloudManager.c(this.c, localJSONObject.optLong("loseEnd", 0L) * 1000L);
      CloudManager.f(this.c, localJSONObject.optInt("recons", 0));
      CloudManager.g(this.c, localJSONObject.optInt("reptErrCode", 0));
      CloudManager.h(this.c, localJSONObject.optInt("collData", 0));
      CloudManager.i(this.c, localJSONObject.optInt("shrBugly", 0));
      CloudManager.j(this.c, localJSONObject.optInt("appClsAlive", 0));
      CloudManager.k(this.c, localJSONObject.optInt("repoLanuEv", 0));
      CloudManager.l(this.c, localJSONObject.optInt("compress", 0));
      CloudManager.b(this.c, localJSONObject.optString("addrCfg", ""));
      CloudManager.m(this.c, localJSONObject.optInt("pullMsg", -1));
      CloudManager.n(this.c, localJSONObject.optInt("reptLog", -1));
      CloudManager.c(this.c, localJSONObject.optString("conf_pull_arr", ""));
      CloudManager.d(this.c, localJSONObject.optString("conf_pull_black_list", ""));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_appAlive", CloudManager.e(this.c));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_losePkt", CloudManager.f(this.c));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_recons", CloudManager.g(this.c));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_reptErrCode", CloudManager.h(this.c));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_collData", CloudManager.i(this.c));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_shrBugly", CloudManager.j(this.c));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_appClsAlive", CloudManager.k(this.c));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_repoLanuEv", CloudManager.l(this.c));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_compress", CloudManager.m(this.c));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_pullMsg", CloudManager.n(this.c));
      CloudManager.a(this.c, CloudManager.a(), "cloud_control_reptLog", CloudManager.o(this.c));
      if (!Util.isNullOrEmptyString(CloudManager.p(this.c))) {
        PushPreferences.putString(CloudManager.a(), "cloud_control_addrCfg", CloudManager.p(this.c));
      }
      if (!Util.isNullOrEmptyString(CloudManager.q(this.c))) {
        PushPreferences.putString(CloudManager.a(), "cloud_control_conf_pull_arr", CloudManager.q(this.c));
      }
      if (!Util.isNullOrEmptyString(CloudManager.r(this.c))) {
        PushPreferences.putString(CloudManager.a(), "cloud_control_conf_pull_black_list", CloudManager.r(this.c));
      }
      StatHelper.reportCloudControl(CloudManager.a(), CloudManager.d(this.c), 1, this.a, this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      TBaseLogger.w("CloudManager", "unexpected for config:" + this.a, localThrowable);
      StatHelper.reportCloudControl(CloudManager.a(), this.c.getCloudVersion(), 2, this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.CloudManager.1
 * JD-Core Version:    0.7.0.1
 */
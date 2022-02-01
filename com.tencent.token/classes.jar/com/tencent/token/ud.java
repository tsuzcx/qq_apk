package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class ud
  extends tr
{
  public int d;
  private long e;
  private long f;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.d = paramabc.j;
    this.e = ((Long)paramabc.c.get("param.realuin")).longValue();
    this.f = ((Long)paramabc.c.get("param.uinhash")).longValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aao.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append("json=");
      localStringBuilder.append(paramJSONObject);
      xj.a(localStringBuilder.toString());
      i = paramJSONObject.optInt("seq_id");
      if (i != this.d)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.d);
        xj.c(paramJSONObject.toString());
        return;
      }
      if (1 == paramJSONObject.optInt("user_action_report"))
      {
        aad.a();
        aad.g = true;
        xj.c("isNeedUpload:true");
      }
      else
      {
        aad.a();
        aad.g = false;
        xj.c("isNeedUpload:false");
      }
      this.a.a = 0;
      return;
    }
    xj.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.p().getString(2131493068));
  }
  
  public final abc b(abc paramabc)
  {
    int i = paramabc.j;
    paramabc.m = 1;
    paramabc.n = new ContentValues(3);
    Object localObject1 = paramabc.n;
    sh.a();
    ((ContentValues)localObject1).put("aq_base_sid", null);
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("uin", this.f);
      Object localObject2 = new StringBuilder("mRealUin=");
      ((StringBuilder)localObject2).append(this.e);
      ((StringBuilder)localObject2).append(",uinHash=");
      ((StringBuilder)localObject2).append(this.f);
      xj.a(((StringBuilder)localObject2).toString());
      ((JSONObject)localObject1).put("seq_id", i);
      ((JSONObject)localObject1).put("op_time", (int)(sj.b().i() / 1000L));
      ((JSONObject)localObject1).put("token_seq", sj.b().a.d());
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("cpu_info", zu.a());
      ((JSONObject)localObject2).put("available_internal_memory_size", zy.a());
      ((JSONObject)localObject2).put("available_sd_card_size", zy.c());
      ((JSONObject)localObject2).put("band_ver", zw.v());
      ((JSONObject)localObject2).put("battery_level_and_status", zw.b());
      ((JSONObject)localObject2).put("cpu_hardware", zu.c());
      ((JSONObject)localObject2).put("cpu_serial", zu.b());
      ((JSONObject)localObject2).put("cpu_count", zu.d());
      ((JSONObject)localObject2).put("cpu_frequent", zu.e());
      ((JSONObject)localObject2).put("cpu_name", zu.a());
      ((JSONObject)localObject2).put("imei", zw.a(RqdApplication.p()));
      ((JSONObject)localObject2).put("imsi", zw.b(RqdApplication.p()));
      ((JSONObject)localObject2).put("mac_address", zw.d(RqdApplication.p()));
      ((JSONObject)localObject2).put("memory_size", zy.a(RqdApplication.p()));
      ((JSONObject)localObject2).put("phone_number", zw.c(RqdApplication.p()));
      ((JSONObject)localObject2).put("sd_card_size", zy.d());
      ((JSONObject)localObject2).put("sim_serial", zw.c());
      ((JSONObject)localObject2).put("screen_dpi", aaa.c(RqdApplication.p()));
      ((JSONObject)localObject2).put("screen_height", aaa.a(RqdApplication.p()));
      ((JSONObject)localObject2).put("screen_resolution", aaa.d(RqdApplication.p()));
      ((JSONObject)localObject2).put("screen_width", aaa.b(RqdApplication.p()));
      ((JSONObject)localObject2).put("sensor_info", aab.a(RqdApplication.p()));
      ((JSONObject)localObject2).put("serial_number", zw.c());
      ((JSONObject)localObject2).put("support_instruction_sets", zw.y());
      ((JSONObject)localObject2).put("system_lock_screen_status", aaa.e(RqdApplication.p()));
      ((JSONObject)localObject2).put("system_volume_setting", aac.a(RqdApplication.p()));
      ((JSONObject)localObject2).put("total_internal_memory_size", zy.b());
      ((JSONObject)localObject2).put("voice_mail_number", aac.b(RqdApplication.p()));
      ((JSONObject)localObject2).put("voice_mail_tag", aac.c(RqdApplication.p()));
      ((JSONObject)localObject2).put("acclerometer", aab.b(RqdApplication.p()));
      ((JSONObject)localObject2).put("magnetic", aab.c(RqdApplication.p()));
      ((JSONObject)localObject2).put("gyroscope", aab.d(RqdApplication.p()));
      ((JSONObject)localObject2).put("gravity", aab.e(RqdApplication.p()));
      ((JSONObject)localObject2).put("linear_accleration", aab.f(RqdApplication.p()));
      ((JSONObject)localObject2).put("light", aab.g(RqdApplication.p()));
      ((JSONObject)localObject2).put("proximity", aab.h(RqdApplication.p()));
      ((JSONObject)localObject2).put("temperature", aab.i(RqdApplication.p()));
      ((JSONObject)localObject2).put("pressure", aab.j(RqdApplication.p()));
      ((JSONObject)localObject1).put("device_info_device", ((JSONObject)localObject2).toString());
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("network_interfaces", zz.b());
      ((JSONObject)localObject2).put("air_plane_mode", zz.a(RqdApplication.p()));
      ((JSONObject)localObject2).put("network_connection_type", zz.m(RqdApplication.p()));
      ((JSONObject)localObject2).put("network_operator_name", zz.k(RqdApplication.p()));
      ((JSONObject)localObject2).put("network_type", zz.l(RqdApplication.p()));
      RqdApplication.p();
      ((JSONObject)localObject2).put("network_type_and_ip_address", zz.c());
      ((JSONObject)localObject2).put("operator_name", zz.k(RqdApplication.p()));
      ((JSONObject)localObject2).put("operator_type", zz.b(RqdApplication.p()));
      RqdApplication.p();
      ((JSONObject)localObject2).put("phone_ip", zz.c());
      ((JSONObject)localObject2).put("wifi_bass_id", zz.g(RqdApplication.p()));
      ((JSONObject)localObject2).put("gsm_sim_stat", zz.a(0));
      ((JSONObject)localObject2).put("gsm_sim_stat2", zz.a(1));
      ((JSONObject)localObject2).put("wifi_interface", zz.d());
      ((JSONObject)localObject2).put("wifi_encrypted", zz.d(RqdApplication.p()));
      ((JSONObject)localObject2).put("mcc", zz.i(RqdApplication.p()));
      ((JSONObject)localObject2).put("mnc", zz.j(RqdApplication.p()));
      ((JSONObject)localObject2).put("wifi_ssid", zz.f(RqdApplication.p()));
      ((JSONObject)localObject2).put("wifi_list_near_by", zz.e(RqdApplication.p()));
      ((JSONObject)localObject2).put("wifi_strength", zz.h(RqdApplication.p()));
      RqdApplication.p();
      ((JSONObject)localObject2).put("ip_address", zz.c());
      ((JSONObject)localObject2).put("is_wifi_active", zz.c(RqdApplication.p()));
      ((JSONObject)localObject1).put("device_info_device", localObject2);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("all_app_name", zt.a(RqdApplication.p()));
      ((JSONObject)localObject2).put("android_id", zw.e(RqdApplication.p()));
      ((JSONObject)localObject2).put("kernel_version", zw.d());
      ((JSONObject)localObject2).put("language", zw.j());
      ((JSONObject)localObject2).put("system_boot_time", zw.e());
      ((JSONObject)localObject2).put("system_boot_time_length", zw.f());
      ((JSONObject)localObject2).put("time_zone", zw.k());
      ((JSONObject)localObject2).put("build_display_id", zw.w());
      ((JSONObject)localObject2).put("build_tags", zw.x());
      ((JSONObject)localObject2).put("build_version_incremental", zw.m());
      ((JSONObject)localObject2).put("build_version_release", zw.n());
      ((JSONObject)localObject2).put("build_version_sdk", zw.o());
      ((JSONObject)localObject2).put("kernel_qume", zw.h());
      ((JSONObject)localObject2).put("os_name", zw.l());
      ((JSONObject)localObject2).put("product_board", zw.p());
      ((JSONObject)localObject2).put("product_brand", zw.q());
      ((JSONObject)localObject2).put("product_device", zw.r());
      ((JSONObject)localObject2).put("product_manufacture", zw.s());
      ((JSONObject)localObject2).put("product_model", zw.t());
      ((JSONObject)localObject2).put("product_name", zw.u());
      ((JSONObject)localObject2).put("usb_stat", zw.f(RqdApplication.p()));
      ((JSONObject)localObject2).put("is_emulator", zw.i());
      ((JSONObject)localObject2).put("is_rooted", zw.g());
      ((JSONObject)localObject2).put("app_boot_time", zw.a());
      ((JSONObject)localObject1).put("device_info_env", localObject2);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("cell_id", zx.b);
      ((JSONObject)localObject2).put("cell_rssi", 0);
      ((JSONObject)localObject2).put("lac", zx.b);
      ((JSONObject)localObject2).put("latitude", zx.b);
      ((JSONObject)localObject2).put("longitude", zx.b);
      ((JSONObject)localObject2).put("gps_open", 0);
      ((JSONObject)localObject1).put("device_info_location", localObject2);
      localObject1 = aao.b(((JSONObject)localObject1).toString().getBytes());
      paramabc.n.put("data", (String)localObject1);
      return paramabc;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramabc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ud
 * JD-Core Version:    0.7.0.1
 */
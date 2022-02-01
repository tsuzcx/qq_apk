package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class tw
  extends tk
{
  public int d;
  private long e;
  private long f;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.d = paramaar.j;
    this.e = ((Long)paramaar.c.get("param.realuin")).longValue();
    this.f = ((Long)paramaar.c.get("param.uinhash")).longValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append("json=");
      localStringBuilder.append(paramJSONObject);
      xb.a(localStringBuilder.toString());
      i = paramJSONObject.optInt("seq_id");
      if (i != this.d)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.d);
        xb.c(paramJSONObject.toString());
        return;
      }
      if (1 == paramJSONObject.optInt("user_action_report"))
      {
        zs.a();
        zs.g = true;
        xb.c("isNeedUpload:true");
      }
      else
      {
        zs.a();
        zs.g = false;
        xb.c("isNeedUpload:false");
      }
      this.a.a = 0;
      return;
    }
    xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  public final aar b(aar paramaar)
  {
    int i = paramaar.j;
    paramaar.m = 1;
    paramaar.n = new ContentValues(3);
    Object localObject1 = paramaar.n;
    sa.a();
    ((ContentValues)localObject1).put("aq_base_sid", null);
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("uin", this.f);
      Object localObject2 = new StringBuilder("mRealUin=");
      ((StringBuilder)localObject2).append(this.e);
      ((StringBuilder)localObject2).append(",uinHash=");
      ((StringBuilder)localObject2).append(this.f);
      xb.a(((StringBuilder)localObject2).toString());
      ((JSONObject)localObject1).put("seq_id", i);
      ((JSONObject)localObject1).put("op_time", (int)(sc.b().i() / 1000L));
      ((JSONObject)localObject1).put("token_seq", sc.b().a.d());
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("cpu_info", zi.a());
      ((JSONObject)localObject2).put("available_internal_memory_size", zn.a());
      ((JSONObject)localObject2).put("available_sd_card_size", zn.c());
      ((JSONObject)localObject2).put("band_ver", zk.v());
      ((JSONObject)localObject2).put("battery_level_and_status", zk.b());
      ((JSONObject)localObject2).put("cpu_hardware", zi.c());
      ((JSONObject)localObject2).put("cpu_serial", zi.b());
      ((JSONObject)localObject2).put("cpu_count", zi.d());
      ((JSONObject)localObject2).put("cpu_frequent", zi.e());
      ((JSONObject)localObject2).put("cpu_name", zi.a());
      ((JSONObject)localObject2).put("imei", zk.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("imsi", zk.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("mac_address", zk.d(RqdApplication.n()));
      ((JSONObject)localObject2).put("memory_size", zn.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("phone_number", zk.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("sd_card_size", zn.d());
      ((JSONObject)localObject2).put("sim_serial", zk.c());
      ((JSONObject)localObject2).put("screen_dpi", zp.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("screen_height", zp.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("screen_resolution", zp.d(RqdApplication.n()));
      ((JSONObject)localObject2).put("screen_width", zp.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("sensor_info", zq.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("serial_number", zk.c());
      ((JSONObject)localObject2).put("support_instruction_sets", zk.y());
      ((JSONObject)localObject2).put("system_lock_screen_status", zp.e(RqdApplication.n()));
      ((JSONObject)localObject2).put("system_volume_setting", zr.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("total_internal_memory_size", zn.b());
      ((JSONObject)localObject2).put("voice_mail_number", zr.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("voice_mail_tag", zr.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("acclerometer", zq.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("magnetic", zq.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("gyroscope", zq.d(RqdApplication.n()));
      ((JSONObject)localObject2).put("gravity", zq.e(RqdApplication.n()));
      ((JSONObject)localObject2).put("linear_accleration", zq.f(RqdApplication.n()));
      ((JSONObject)localObject2).put("light", zq.g(RqdApplication.n()));
      ((JSONObject)localObject2).put("proximity", zq.h(RqdApplication.n()));
      ((JSONObject)localObject2).put("temperature", zq.i(RqdApplication.n()));
      ((JSONObject)localObject2).put("pressure", zq.j(RqdApplication.n()));
      ((JSONObject)localObject1).put("device_info_device", ((JSONObject)localObject2).toString());
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("network_interfaces", zo.b());
      ((JSONObject)localObject2).put("air_plane_mode", zo.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("network_connection_type", zo.m(RqdApplication.n()));
      ((JSONObject)localObject2).put("network_operator_name", zo.k(RqdApplication.n()));
      ((JSONObject)localObject2).put("network_type", zo.l(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject2).put("network_type_and_ip_address", zo.c());
      ((JSONObject)localObject2).put("operator_name", zo.k(RqdApplication.n()));
      ((JSONObject)localObject2).put("operator_type", zo.b(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject2).put("phone_ip", zo.c());
      ((JSONObject)localObject2).put("wifi_bass_id", zo.g(RqdApplication.n()));
      ((JSONObject)localObject2).put("gsm_sim_stat", zo.a(0));
      ((JSONObject)localObject2).put("gsm_sim_stat2", zo.a(1));
      ((JSONObject)localObject2).put("wifi_interface", zo.d());
      ((JSONObject)localObject2).put("wifi_encrypted", zo.d(RqdApplication.n()));
      ((JSONObject)localObject2).put("mcc", zo.i(RqdApplication.n()));
      ((JSONObject)localObject2).put("mnc", zo.j(RqdApplication.n()));
      ((JSONObject)localObject2).put("wifi_ssid", zo.f(RqdApplication.n()));
      ((JSONObject)localObject2).put("wifi_list_near_by", zo.e(RqdApplication.n()));
      ((JSONObject)localObject2).put("wifi_strength", zo.h(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject2).put("ip_address", zo.c());
      ((JSONObject)localObject2).put("is_wifi_active", zo.c(RqdApplication.n()));
      ((JSONObject)localObject1).put("device_info_device", localObject2);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("all_app_name", zh.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("android_id", zk.e(RqdApplication.n()));
      ((JSONObject)localObject2).put("kernel_version", zk.d());
      ((JSONObject)localObject2).put("language", zk.j());
      ((JSONObject)localObject2).put("system_boot_time", zk.e());
      ((JSONObject)localObject2).put("system_boot_time_length", zk.f());
      ((JSONObject)localObject2).put("time_zone", zk.k());
      ((JSONObject)localObject2).put("build_display_id", zk.w());
      ((JSONObject)localObject2).put("build_tags", zk.x());
      ((JSONObject)localObject2).put("build_version_incremental", zk.m());
      ((JSONObject)localObject2).put("build_version_release", zk.n());
      ((JSONObject)localObject2).put("build_version_sdk", zk.o());
      ((JSONObject)localObject2).put("kernel_qume", zk.h());
      ((JSONObject)localObject2).put("os_name", zk.l());
      ((JSONObject)localObject2).put("product_board", zk.p());
      ((JSONObject)localObject2).put("product_brand", zk.q());
      ((JSONObject)localObject2).put("product_device", zk.r());
      ((JSONObject)localObject2).put("product_manufacture", zk.s());
      ((JSONObject)localObject2).put("product_model", zk.t());
      ((JSONObject)localObject2).put("product_name", zk.u());
      ((JSONObject)localObject2).put("usb_stat", zk.f(RqdApplication.n()));
      ((JSONObject)localObject2).put("is_emulator", zk.i());
      ((JSONObject)localObject2).put("is_rooted", zk.g());
      ((JSONObject)localObject2).put("app_boot_time", zk.a());
      ((JSONObject)localObject1).put("device_info_env", localObject2);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("cell_id", zm.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("cell_rssi", zm.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("lac", zm.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("latitude", zm.a(RqdApplication.n(), zl.c));
      ((JSONObject)localObject2).put("longitude", zm.a(RqdApplication.n(), zl.d));
      ((JSONObject)localObject2).put("gps_open", zm.d(RqdApplication.n()));
      ((JSONObject)localObject1).put("device_info_location", localObject2);
      localObject1 = aad.b(((JSONObject)localObject1).toString().getBytes());
      paramaar.n.put("data", (String)localObject1);
      return paramaar;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramaar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tw
 * JD-Core Version:    0.7.0.1
 */
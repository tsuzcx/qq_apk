package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class tv
  extends tj
{
  public int d;
  private long e;
  private long f;
  
  public final String a()
  {
    rz.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aaq paramaaq)
  {
    this.d = paramaaq.j;
    this.e = ((Long)paramaaq.c.get("param.realuin")).longValue();
    this.f = ((Long)paramaaq.c.get("param.uinhash")).longValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aac.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append("json=");
      localStringBuilder.append(paramJSONObject);
      xa.a(localStringBuilder.toString());
      i = paramJSONObject.optInt("seq_id");
      if (i != this.d)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.d);
        xa.c(paramJSONObject.toString());
        return;
      }
      if (1 == paramJSONObject.optInt("user_action_report"))
      {
        zr.a();
        zr.g = true;
        xa.c("isNeedUpload:true");
      }
      else
      {
        zr.a();
        zr.g = false;
        xa.c("isNeedUpload:false");
      }
      this.a.a = 0;
      return;
    }
    xa.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  public final aaq b(aaq paramaaq)
  {
    int i = paramaaq.j;
    paramaaq.m = 1;
    paramaaq.n = new ContentValues(3);
    Object localObject1 = paramaaq.n;
    rz.a();
    ((ContentValues)localObject1).put("aq_base_sid", null);
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("uin", this.f);
      Object localObject2 = new StringBuilder("mRealUin=");
      ((StringBuilder)localObject2).append(this.e);
      ((StringBuilder)localObject2).append(",uinHash=");
      ((StringBuilder)localObject2).append(this.f);
      xa.a(((StringBuilder)localObject2).toString());
      ((JSONObject)localObject1).put("seq_id", i);
      ((JSONObject)localObject1).put("op_time", (int)(sb.b().i() / 1000L));
      ((JSONObject)localObject1).put("token_seq", sb.b().a.d());
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("cpu_info", zh.a());
      ((JSONObject)localObject2).put("available_internal_memory_size", zm.a());
      ((JSONObject)localObject2).put("available_sd_card_size", zm.c());
      ((JSONObject)localObject2).put("band_ver", zj.v());
      ((JSONObject)localObject2).put("battery_level_and_status", zj.b());
      ((JSONObject)localObject2).put("cpu_hardware", zh.c());
      ((JSONObject)localObject2).put("cpu_serial", zh.b());
      ((JSONObject)localObject2).put("cpu_count", zh.d());
      ((JSONObject)localObject2).put("cpu_frequent", zh.e());
      ((JSONObject)localObject2).put("cpu_name", zh.a());
      ((JSONObject)localObject2).put("imei", zj.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("imsi", zj.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("mac_address", zj.d(RqdApplication.n()));
      ((JSONObject)localObject2).put("memory_size", zm.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("phone_number", zj.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("sd_card_size", zm.d());
      ((JSONObject)localObject2).put("sim_serial", zj.c());
      ((JSONObject)localObject2).put("screen_dpi", zo.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("screen_height", zo.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("screen_resolution", zo.d(RqdApplication.n()));
      ((JSONObject)localObject2).put("screen_width", zo.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("sensor_info", zp.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("serial_number", zj.c());
      ((JSONObject)localObject2).put("support_instruction_sets", zj.y());
      ((JSONObject)localObject2).put("system_lock_screen_status", zo.e(RqdApplication.n()));
      ((JSONObject)localObject2).put("system_volume_setting", zq.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("total_internal_memory_size", zm.b());
      ((JSONObject)localObject2).put("voice_mail_number", zq.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("voice_mail_tag", zq.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("acclerometer", zp.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("magnetic", zp.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("gyroscope", zp.d(RqdApplication.n()));
      ((JSONObject)localObject2).put("gravity", zp.e(RqdApplication.n()));
      ((JSONObject)localObject2).put("linear_accleration", zp.f(RqdApplication.n()));
      ((JSONObject)localObject2).put("light", zp.g(RqdApplication.n()));
      ((JSONObject)localObject2).put("proximity", zp.h(RqdApplication.n()));
      ((JSONObject)localObject2).put("temperature", zp.i(RqdApplication.n()));
      ((JSONObject)localObject2).put("pressure", zp.j(RqdApplication.n()));
      ((JSONObject)localObject1).put("device_info_device", ((JSONObject)localObject2).toString());
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("network_interfaces", zn.b());
      ((JSONObject)localObject2).put("air_plane_mode", zn.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("network_connection_type", zn.m(RqdApplication.n()));
      ((JSONObject)localObject2).put("network_operator_name", zn.k(RqdApplication.n()));
      ((JSONObject)localObject2).put("network_type", zn.l(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject2).put("network_type_and_ip_address", zn.c());
      ((JSONObject)localObject2).put("operator_name", zn.k(RqdApplication.n()));
      ((JSONObject)localObject2).put("operator_type", zn.b(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject2).put("phone_ip", zn.c());
      ((JSONObject)localObject2).put("wifi_bass_id", zn.g(RqdApplication.n()));
      ((JSONObject)localObject2).put("gsm_sim_stat", zn.a(0));
      ((JSONObject)localObject2).put("gsm_sim_stat2", zn.a(1));
      ((JSONObject)localObject2).put("wifi_interface", zn.d());
      ((JSONObject)localObject2).put("wifi_encrypted", zn.d(RqdApplication.n()));
      ((JSONObject)localObject2).put("mcc", zn.i(RqdApplication.n()));
      ((JSONObject)localObject2).put("mnc", zn.j(RqdApplication.n()));
      ((JSONObject)localObject2).put("wifi_ssid", zn.f(RqdApplication.n()));
      ((JSONObject)localObject2).put("wifi_list_near_by", zn.e(RqdApplication.n()));
      ((JSONObject)localObject2).put("wifi_strength", zn.h(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject2).put("ip_address", zn.c());
      ((JSONObject)localObject2).put("is_wifi_active", zn.c(RqdApplication.n()));
      ((JSONObject)localObject1).put("device_info_device", localObject2);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("all_app_name", zg.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("android_id", zj.e(RqdApplication.n()));
      ((JSONObject)localObject2).put("kernel_version", zj.d());
      ((JSONObject)localObject2).put("language", zj.j());
      ((JSONObject)localObject2).put("system_boot_time", zj.e());
      ((JSONObject)localObject2).put("system_boot_time_length", zj.f());
      ((JSONObject)localObject2).put("time_zone", zj.k());
      ((JSONObject)localObject2).put("build_display_id", zj.w());
      ((JSONObject)localObject2).put("build_tags", zj.x());
      ((JSONObject)localObject2).put("build_version_incremental", zj.m());
      ((JSONObject)localObject2).put("build_version_release", zj.n());
      ((JSONObject)localObject2).put("build_version_sdk", zj.o());
      ((JSONObject)localObject2).put("kernel_qume", zj.h());
      ((JSONObject)localObject2).put("os_name", zj.l());
      ((JSONObject)localObject2).put("product_board", zj.p());
      ((JSONObject)localObject2).put("product_brand", zj.q());
      ((JSONObject)localObject2).put("product_device", zj.r());
      ((JSONObject)localObject2).put("product_manufacture", zj.s());
      ((JSONObject)localObject2).put("product_model", zj.t());
      ((JSONObject)localObject2).put("product_name", zj.u());
      ((JSONObject)localObject2).put("usb_stat", zj.f(RqdApplication.n()));
      ((JSONObject)localObject2).put("is_emulator", zj.i());
      ((JSONObject)localObject2).put("is_rooted", zj.g());
      ((JSONObject)localObject2).put("app_boot_time", zj.a());
      ((JSONObject)localObject1).put("device_info_env", localObject2);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("cell_id", zl.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("cell_rssi", zl.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("lac", zl.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("latitude", zl.a(RqdApplication.n(), zk.c));
      ((JSONObject)localObject2).put("longitude", zl.a(RqdApplication.n(), zk.d));
      ((JSONObject)localObject2).put("gps_open", zl.d(RqdApplication.n()));
      ((JSONObject)localObject1).put("device_info_location", localObject2);
      localObject1 = aac.b(((JSONObject)localObject1).toString().getBytes());
      paramaaq.n.put("data", (String)localObject1);
      return paramaaq;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramaaq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tv
 * JD-Core Version:    0.7.0.1
 */
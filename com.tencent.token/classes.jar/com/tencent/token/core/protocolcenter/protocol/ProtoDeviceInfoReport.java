package com.tencent.token.core.protocolcenter.protocol;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.token.cb;
import com.tencent.token.cd;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.upload.b;
import com.tencent.token.upload.f;
import com.tencent.token.upload.h;
import com.tencent.token.upload.i;
import com.tencent.token.upload.j;
import com.tencent.token.upload.k;
import com.tencent.token.upload.useraction.a;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDeviceInfoReport
  extends d
{
  public int d;
  private long e;
  private long f;
  
  public static void b(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("cpu_info", com.tencent.token.upload.c.a());
    localJSONObject.put("available_internal_memory_size", h.b());
    localJSONObject.put("available_sd_card_size", h.d());
    localJSONObject.put("band_ver", com.tencent.token.upload.e.v());
    localJSONObject.put("battery_level_and_status", com.tencent.token.upload.e.b());
    localJSONObject.put("cpu_hardware", com.tencent.token.upload.c.c());
    localJSONObject.put("cpu_serial", com.tencent.token.upload.c.b());
    localJSONObject.put("cpu_count", com.tencent.token.upload.c.d());
    localJSONObject.put("cpu_frequent", com.tencent.token.upload.c.e());
    localJSONObject.put("cpu_name", com.tencent.token.upload.c.a());
    localJSONObject.put("imei", com.tencent.token.upload.e.a(RqdApplication.n()));
    localJSONObject.put("imsi", com.tencent.token.upload.e.b(RqdApplication.n()));
    localJSONObject.put("mac_address", com.tencent.token.upload.e.d(RqdApplication.n()));
    localJSONObject.put("memory_size", h.a(RqdApplication.n()));
    localJSONObject.put("phone_number", com.tencent.token.upload.e.c(RqdApplication.n()));
    localJSONObject.put("sd_card_size", h.e());
    localJSONObject.put("sim_serial", com.tencent.token.upload.e.c());
    localJSONObject.put("screen_dpi", j.c(RqdApplication.n()));
    localJSONObject.put("screen_height", j.a(RqdApplication.n()));
    localJSONObject.put("screen_resolution", j.e(RqdApplication.n()));
    localJSONObject.put("screen_width", j.b(RqdApplication.n()));
    localJSONObject.put("sensor_info", k.b(RqdApplication.n()));
    localJSONObject.put("serial_number", com.tencent.token.upload.e.c());
    localJSONObject.put("support_instruction_sets", com.tencent.token.upload.e.y());
    localJSONObject.put("system_lock_screen_status", j.g(RqdApplication.n()));
    localJSONObject.put("system_volume_setting", com.tencent.token.upload.l.a(RqdApplication.n()));
    localJSONObject.put("total_internal_memory_size", h.c());
    localJSONObject.put("voice_mail_number", com.tencent.token.upload.l.b(RqdApplication.n()));
    localJSONObject.put("voice_mail_tag", com.tencent.token.upload.l.c(RqdApplication.n()));
    localJSONObject.put("acclerometer", k.c(RqdApplication.n()));
    localJSONObject.put("magnetic", k.d(RqdApplication.n()));
    localJSONObject.put("gyroscope", k.e(RqdApplication.n()));
    localJSONObject.put("gravity", k.f(RqdApplication.n()));
    localJSONObject.put("linear_accleration", k.g(RqdApplication.n()));
    localJSONObject.put("light", k.h(RqdApplication.n()));
    localJSONObject.put("proximity", k.i(RqdApplication.n()));
    localJSONObject.put("temperature", k.j(RqdApplication.n()));
    localJSONObject.put("pressure", k.k(RqdApplication.n()));
    paramJSONObject.put("device_info_device", localJSONObject.toString());
    localJSONObject = new JSONObject();
    localJSONObject.put("network_interfaces", i.c());
    localJSONObject.put("air_plane_mode", i.c(RqdApplication.n()));
    localJSONObject.put("network_connection_type", i.o(RqdApplication.n()));
    localJSONObject.put("network_operator_name", i.m(RqdApplication.n()));
    localJSONObject.put("network_type", i.n(RqdApplication.n()));
    localJSONObject.put("network_type_and_ip_address", i.b(RqdApplication.n()));
    localJSONObject.put("operator_name", i.m(RqdApplication.n()));
    localJSONObject.put("operator_type", i.d(RqdApplication.n()));
    localJSONObject.put("phone_ip", i.b(RqdApplication.n()));
    localJSONObject.put("wifi_bass_id", i.i(RqdApplication.n()));
    localJSONObject.put("gsm_sim_stat", i.a(0));
    localJSONObject.put("gsm_sim_stat2", i.a(1));
    localJSONObject.put("wifi_interface", i.d());
    localJSONObject.put("wifi_encrypted", i.f(RqdApplication.n()));
    localJSONObject.put("mcc", i.k(RqdApplication.n()));
    localJSONObject.put("mnc", i.l(RqdApplication.n()));
    localJSONObject.put("wifi_ssid", i.h(RqdApplication.n()));
    localJSONObject.put("wifi_list_near_by", i.g(RqdApplication.n()));
    localJSONObject.put("wifi_strength", i.j(RqdApplication.n()));
    localJSONObject.put("ip_address", i.b(RqdApplication.n()));
    localJSONObject.put("is_wifi_active", i.e(RqdApplication.n()));
    paramJSONObject.put("device_info_device", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("all_app_name", b.b(RqdApplication.n()));
    localJSONObject.put("android_id", com.tencent.token.upload.e.e(RqdApplication.n()));
    localJSONObject.put("kernel_version", com.tencent.token.upload.e.d());
    localJSONObject.put("language", com.tencent.token.upload.e.j());
    localJSONObject.put("system_boot_time", com.tencent.token.upload.e.e());
    localJSONObject.put("system_boot_time_length", com.tencent.token.upload.e.f());
    localJSONObject.put("time_zone", com.tencent.token.upload.e.k());
    localJSONObject.put("build_display_id", com.tencent.token.upload.e.w());
    localJSONObject.put("build_tags", com.tencent.token.upload.e.x());
    localJSONObject.put("build_version_incremental", com.tencent.token.upload.e.m());
    localJSONObject.put("build_version_release", com.tencent.token.upload.e.n());
    localJSONObject.put("build_version_sdk", com.tencent.token.upload.e.o());
    localJSONObject.put("kernel_qume", com.tencent.token.upload.e.h());
    localJSONObject.put("os_name", com.tencent.token.upload.e.l());
    localJSONObject.put("product_board", com.tencent.token.upload.e.p());
    localJSONObject.put("product_brand", com.tencent.token.upload.e.q());
    localJSONObject.put("product_device", com.tencent.token.upload.e.r());
    localJSONObject.put("product_manufacture", com.tencent.token.upload.e.s());
    localJSONObject.put("product_model", com.tencent.token.upload.e.t());
    localJSONObject.put("product_name", com.tencent.token.upload.e.u());
    localJSONObject.put("usb_stat", com.tencent.token.upload.e.f(RqdApplication.n()));
    localJSONObject.put("is_emulator", com.tencent.token.upload.e.i());
    localJSONObject.put("is_rooted", com.tencent.token.upload.e.g());
    localJSONObject.put("app_boot_time", com.tencent.token.upload.e.a());
    paramJSONObject.put("device_info_env", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("cell_id", com.tencent.token.upload.g.a(RqdApplication.n()));
    localJSONObject.put("cell_rssi", com.tencent.token.upload.g.c(RqdApplication.n()));
    localJSONObject.put("lac", com.tencent.token.upload.g.b(RqdApplication.n()));
    localJSONObject.put("latitude", com.tencent.token.upload.g.a(RqdApplication.n(), f.c));
    localJSONObject.put("longitude", com.tencent.token.upload.g.a(RqdApplication.n(), f.d));
    localJSONObject.put("gps_open", com.tencent.token.upload.g.d(RqdApplication.n()));
    paramJSONObject.put("device_info_location", localJSONObject);
  }
  
  protected String a()
  {
    if (cb.a().b() == null)
    {
      this.a.b(104);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.token.global.c.e());
    localStringBuilder.append("/cn/mbtoken3/mbtoken3_device_info_report_encrypt");
    return localStringBuilder.toString();
  }
  
  protected void a(dp paramdp)
  {
    this.d = paramdp.j;
    this.e = ((Long)paramdp.c.get("param.realuin")).longValue();
    this.f = ((Long)paramdp.c.get("param.uinhash")).longValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = com.tencent.token.utils.l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append("json=");
      localStringBuilder.append(paramJSONObject);
      com.tencent.token.global.g.a(localStringBuilder.toString());
      i = paramJSONObject.optInt("seq_id");
      if (i != this.d)
      {
        this.a.b(10030);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.d);
        com.tencent.token.global.g.c(paramJSONObject.toString());
        return;
      }
      if (1 == paramJSONObject.optInt("user_action_report"))
      {
        a.a().a(true);
        com.tencent.token.global.g.c("isNeedUpload:true");
      }
      else
      {
        a.a().a(false);
        com.tencent.token.global.g.c("isNeedUpload:false");
      }
      this.a.c();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseJSON error decodeData=");
    localStringBuilder.append(paramJSONObject);
    com.tencent.token.global.g.c(localStringBuilder.toString());
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  public dp b(dp paramdp)
  {
    int i = paramdp.j;
    paramdp.m = 1;
    paramdp.n = new ContentValues(3);
    paramdp.n.put("aq_base_sid", cb.a().b());
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("uin", this.f);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mRealUin=");
      localStringBuilder.append(this.e);
      localStringBuilder.append(",uinHash=");
      localStringBuilder.append(this.f);
      com.tencent.token.global.g.a(localStringBuilder.toString());
      ((JSONObject)localObject).put("seq_id", i);
      ((JSONObject)localObject).put("op_time", (int)(cd.c().s() / 1000L));
      ((JSONObject)localObject).put("token_seq", cd.c().k());
      b((JSONObject)localObject);
      localObject = com.tencent.token.utils.l.b(((JSONObject)localObject).toString().getBytes());
      paramdp.n.put("data", (String)localObject);
      return paramdp;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramdp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDeviceInfoReport
 * JD-Core Version:    0.7.0.1
 */
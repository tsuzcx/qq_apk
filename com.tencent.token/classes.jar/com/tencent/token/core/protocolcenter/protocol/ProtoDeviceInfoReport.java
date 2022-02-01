package com.tencent.token.core.protocolcenter.protocol;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dn;
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
    localJSONObject.put("imei", com.tencent.token.upload.e.a(RqdApplication.l()));
    localJSONObject.put("imsi", com.tencent.token.upload.e.b(RqdApplication.l()));
    localJSONObject.put("mac_address", com.tencent.token.upload.e.d(RqdApplication.l()));
    localJSONObject.put("memory_size", h.a(RqdApplication.l()));
    localJSONObject.put("phone_number", com.tencent.token.upload.e.c(RqdApplication.l()));
    localJSONObject.put("sd_card_size", h.e());
    localJSONObject.put("sim_serial", com.tencent.token.upload.e.c());
    localJSONObject.put("screen_dpi", j.c(RqdApplication.l()));
    localJSONObject.put("screen_height", j.a(RqdApplication.l()));
    localJSONObject.put("screen_resolution", j.e(RqdApplication.l()));
    localJSONObject.put("screen_width", j.b(RqdApplication.l()));
    localJSONObject.put("sensor_info", k.b(RqdApplication.l()));
    localJSONObject.put("serial_number", com.tencent.token.upload.e.c());
    localJSONObject.put("support_instruction_sets", com.tencent.token.upload.e.y());
    localJSONObject.put("system_lock_screen_status", j.g(RqdApplication.l()));
    localJSONObject.put("system_volume_setting", com.tencent.token.upload.l.a(RqdApplication.l()));
    localJSONObject.put("total_internal_memory_size", h.c());
    localJSONObject.put("voice_mail_number", com.tencent.token.upload.l.b(RqdApplication.l()));
    localJSONObject.put("voice_mail_tag", com.tencent.token.upload.l.c(RqdApplication.l()));
    localJSONObject.put("acclerometer", k.c(RqdApplication.l()));
    localJSONObject.put("magnetic", k.d(RqdApplication.l()));
    localJSONObject.put("gyroscope", k.e(RqdApplication.l()));
    localJSONObject.put("gravity", k.f(RqdApplication.l()));
    localJSONObject.put("linear_accleration", k.g(RqdApplication.l()));
    localJSONObject.put("light", k.h(RqdApplication.l()));
    localJSONObject.put("proximity", k.i(RqdApplication.l()));
    localJSONObject.put("temperature", k.j(RqdApplication.l()));
    localJSONObject.put("pressure", k.k(RqdApplication.l()));
    paramJSONObject.put("device_info_device", localJSONObject.toString());
    localJSONObject = new JSONObject();
    localJSONObject.put("network_interfaces", i.c());
    localJSONObject.put("air_plane_mode", i.c(RqdApplication.l()));
    localJSONObject.put("network_connection_type", i.o(RqdApplication.l()));
    localJSONObject.put("network_operator_name", i.m(RqdApplication.l()));
    localJSONObject.put("network_type", i.n(RqdApplication.l()));
    localJSONObject.put("network_type_and_ip_address", i.b(RqdApplication.l()));
    localJSONObject.put("operator_name", i.m(RqdApplication.l()));
    localJSONObject.put("operator_type", i.d(RqdApplication.l()));
    localJSONObject.put("phone_ip", i.b(RqdApplication.l()));
    localJSONObject.put("wifi_bass_id", i.i(RqdApplication.l()));
    localJSONObject.put("gsm_sim_stat", i.a(0));
    localJSONObject.put("gsm_sim_stat2", i.a(1));
    localJSONObject.put("wifi_interface", i.d());
    localJSONObject.put("wifi_encrypted", i.f(RqdApplication.l()));
    localJSONObject.put("mcc", i.k(RqdApplication.l()));
    localJSONObject.put("mnc", i.l(RqdApplication.l()));
    localJSONObject.put("wifi_ssid", i.h(RqdApplication.l()));
    localJSONObject.put("wifi_list_near_by", i.g(RqdApplication.l()));
    localJSONObject.put("wifi_strength", i.j(RqdApplication.l()));
    localJSONObject.put("ip_address", i.b(RqdApplication.l()));
    localJSONObject.put("is_wifi_active", i.e(RqdApplication.l()));
    paramJSONObject.put("device_info_device", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("all_app_name", b.b(RqdApplication.l()));
    localJSONObject.put("android_id", com.tencent.token.upload.e.e(RqdApplication.l()));
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
    localJSONObject.put("usb_stat", com.tencent.token.upload.e.f(RqdApplication.l()));
    localJSONObject.put("is_emulator", com.tencent.token.upload.e.i());
    localJSONObject.put("is_rooted", com.tencent.token.upload.e.g());
    localJSONObject.put("app_boot_time", com.tencent.token.upload.e.a());
    paramJSONObject.put("device_info_env", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("cell_id", com.tencent.token.upload.g.a(RqdApplication.l()));
    localJSONObject.put("cell_rssi", com.tencent.token.upload.g.c(RqdApplication.l()));
    localJSONObject.put("lac", com.tencent.token.upload.g.b(RqdApplication.l()));
    localJSONObject.put("latitude", com.tencent.token.upload.g.a(RqdApplication.l(), f.c));
    localJSONObject.put("longitude", com.tencent.token.upload.g.a(RqdApplication.l(), f.d));
    localJSONObject.put("gps_open", com.tencent.token.upload.g.d(RqdApplication.l()));
    paramJSONObject.put("device_info_location", localJSONObject);
  }
  
  protected String a()
  {
    if (bz.a().b() == null)
    {
      this.a.b(104);
      return null;
    }
    return com.tencent.token.global.c.e() + "/cn/mbtoken3/mbtoken3_device_info_report_encrypt";
  }
  
  protected void a(dn paramdn)
  {
    this.d = paramdn.j;
    this.e = ((Long)paramdn.c.get("param.realuin")).longValue();
    this.f = ((Long)paramdn.c.get("param.uinhash")).longValue();
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
      com.tencent.token.global.g.a(this + "json=" + paramJSONObject);
      i = paramJSONObject.optInt("seq_id");
      if (i != this.d)
      {
        this.a.b(10030);
        com.tencent.token.global.g.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.d);
        return;
      }
      if (1 == paramJSONObject.optInt("user_action_report"))
      {
        a.a().a(true);
        com.tencent.token.global.g.c("isNeedUpload:true");
      }
      for (;;)
      {
        this.a.c();
        return;
        a.a().a(false);
        com.tencent.token.global.g.c("isNeedUpload:false");
      }
    }
    com.tencent.token.global.g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  public dn b(dn paramdn)
  {
    int i = paramdn.j;
    paramdn.m = 1;
    paramdn.n = new ContentValues(3);
    paramdn.n.put("aq_base_sid", bz.a().b());
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("uin", this.f);
      com.tencent.token.global.g.a("mRealUin=" + this.e + ",uinHash=" + this.f);
      ((JSONObject)localObject).put("seq_id", i);
      ((JSONObject)localObject).put("op_time", (int)(cb.c().s() / 1000L));
      ((JSONObject)localObject).put("token_seq", cb.c().k());
      b((JSONObject)localObject);
      localObject = com.tencent.token.utils.l.b(((JSONObject)localObject).toString().getBytes());
      paramdn.n.put("data", (String)localObject);
      return paramdn;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramdn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDeviceInfoReport
 * JD-Core Version:    0.7.0.1
 */
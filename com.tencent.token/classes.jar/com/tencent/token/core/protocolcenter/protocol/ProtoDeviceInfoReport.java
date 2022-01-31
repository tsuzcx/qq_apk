package com.tencent.token.core.protocolcenter.protocol;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.upload.b;
import com.tencent.token.upload.g;
import com.tencent.token.upload.i;
import com.tencent.token.upload.o;
import com.tencent.token.upload.p;
import com.tencent.token.upload.q;
import com.tencent.token.upload.r;
import com.tencent.token.upload.useraction.a;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDeviceInfoReport
  extends e
{
  public int d;
  private long e;
  private long f;
  
  public static void b(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("cpu_info", com.tencent.token.upload.c.a());
    localJSONObject.put("available_internal_memory_size", i.b());
    localJSONObject.put("available_sd_card_size", i.d());
    localJSONObject.put("band_ver", com.tencent.token.upload.f.v());
    localJSONObject.put("battery_level_and_status", com.tencent.token.upload.f.b());
    localJSONObject.put("cpu_hardware", com.tencent.token.upload.c.c());
    localJSONObject.put("cpu_serial", com.tencent.token.upload.c.b());
    localJSONObject.put("cpu_count", com.tencent.token.upload.c.d());
    localJSONObject.put("cpu_frequent", com.tencent.token.upload.c.e());
    localJSONObject.put("cpu_name", com.tencent.token.upload.c.a());
    localJSONObject.put("imei", com.tencent.token.upload.f.a(RqdApplication.l()));
    localJSONObject.put("imsi", com.tencent.token.upload.f.b(RqdApplication.l()));
    localJSONObject.put("mac_address", com.tencent.token.upload.f.d(RqdApplication.l()));
    localJSONObject.put("memory_size", i.a(RqdApplication.l()));
    localJSONObject.put("phone_number", com.tencent.token.upload.f.c(RqdApplication.l()));
    localJSONObject.put("sd_card_size", i.e());
    localJSONObject.put("sim_serial", com.tencent.token.upload.f.c());
    localJSONObject.put("screen_dpi", p.c(RqdApplication.l()));
    localJSONObject.put("screen_height", p.a(RqdApplication.l()));
    localJSONObject.put("screen_resolution", p.e(RqdApplication.l()));
    localJSONObject.put("screen_width", p.b(RqdApplication.l()));
    localJSONObject.put("sensor_info", q.b(RqdApplication.l()));
    localJSONObject.put("serial_number", com.tencent.token.upload.f.c());
    localJSONObject.put("support_instruction_sets", com.tencent.token.upload.f.y());
    localJSONObject.put("system_lock_screen_status", p.g(RqdApplication.l()));
    localJSONObject.put("system_volume_setting", r.a(RqdApplication.l()));
    localJSONObject.put("total_internal_memory_size", i.c());
    localJSONObject.put("voice_mail_number", r.b(RqdApplication.l()));
    localJSONObject.put("voice_mail_tag", r.c(RqdApplication.l()));
    localJSONObject.put("acclerometer", q.c(RqdApplication.l()));
    localJSONObject.put("magnetic", q.d(RqdApplication.l()));
    localJSONObject.put("gyroscope", q.e(RqdApplication.l()));
    localJSONObject.put("gravity", q.f(RqdApplication.l()));
    localJSONObject.put("linear_accleration", q.g(RqdApplication.l()));
    localJSONObject.put("light", q.h(RqdApplication.l()));
    localJSONObject.put("proximity", q.i(RqdApplication.l()));
    localJSONObject.put("temperature", q.j(RqdApplication.l()));
    localJSONObject.put("pressure", q.k(RqdApplication.l()));
    paramJSONObject.put("device_info_device", localJSONObject.toString());
    localJSONObject = new JSONObject();
    localJSONObject.put("network_interfaces", o.c());
    localJSONObject.put("air_plane_mode", o.c(RqdApplication.l()));
    localJSONObject.put("network_connection_type", o.o(RqdApplication.l()));
    localJSONObject.put("network_operator_name", o.m(RqdApplication.l()));
    localJSONObject.put("network_type", o.n(RqdApplication.l()));
    localJSONObject.put("network_type_and_ip_address", o.b(RqdApplication.l()));
    localJSONObject.put("operator_name", o.m(RqdApplication.l()));
    localJSONObject.put("operator_type", o.d(RqdApplication.l()));
    localJSONObject.put("phone_ip", o.b(RqdApplication.l()));
    localJSONObject.put("wifi_bass_id", o.i(RqdApplication.l()));
    localJSONObject.put("gsm_sim_stat", o.a(0));
    localJSONObject.put("gsm_sim_stat2", o.a(1));
    localJSONObject.put("wifi_interface", o.d());
    localJSONObject.put("wifi_encrypted", o.f(RqdApplication.l()));
    localJSONObject.put("mcc", o.k(RqdApplication.l()));
    localJSONObject.put("mnc", o.l(RqdApplication.l()));
    localJSONObject.put("wifi_ssid", o.h(RqdApplication.l()));
    localJSONObject.put("wifi_list_near_by", o.g(RqdApplication.l()));
    localJSONObject.put("wifi_strength", o.j(RqdApplication.l()));
    localJSONObject.put("ip_address", o.b(RqdApplication.l()));
    localJSONObject.put("is_wifi_active", o.e(RqdApplication.l()));
    paramJSONObject.put("device_info_device", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("all_app_name", b.b(RqdApplication.l()));
    localJSONObject.put("android_id", com.tencent.token.upload.f.e(RqdApplication.l()));
    localJSONObject.put("kernel_version", com.tencent.token.upload.f.d());
    localJSONObject.put("language", com.tencent.token.upload.f.j());
    localJSONObject.put("system_boot_time", com.tencent.token.upload.f.e());
    localJSONObject.put("system_boot_time_length", com.tencent.token.upload.f.f());
    localJSONObject.put("time_zone", com.tencent.token.upload.f.k());
    localJSONObject.put("build_display_id", com.tencent.token.upload.f.w());
    localJSONObject.put("build_tags", com.tencent.token.upload.f.x());
    localJSONObject.put("build_version_incremental", com.tencent.token.upload.f.m());
    localJSONObject.put("build_version_release", com.tencent.token.upload.f.n());
    localJSONObject.put("build_version_sdk", com.tencent.token.upload.f.o());
    localJSONObject.put("kernel_qume", com.tencent.token.upload.f.h());
    localJSONObject.put("os_name", com.tencent.token.upload.f.l());
    localJSONObject.put("product_board", com.tencent.token.upload.f.p());
    localJSONObject.put("product_brand", com.tencent.token.upload.f.q());
    localJSONObject.put("product_device", com.tencent.token.upload.f.r());
    localJSONObject.put("product_manufacture", com.tencent.token.upload.f.s());
    localJSONObject.put("product_model", com.tencent.token.upload.f.t());
    localJSONObject.put("product_name", com.tencent.token.upload.f.u());
    localJSONObject.put("usb_stat", com.tencent.token.upload.f.f(RqdApplication.l()));
    localJSONObject.put("is_emulator", com.tencent.token.upload.f.i());
    localJSONObject.put("is_rooted", com.tencent.token.upload.f.g());
    localJSONObject.put("app_boot_time", com.tencent.token.upload.f.a());
    paramJSONObject.put("device_info_env", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("cell_id", com.tencent.token.upload.h.a(RqdApplication.l()));
    localJSONObject.put("cell_rssi", com.tencent.token.upload.h.c(RqdApplication.l()));
    localJSONObject.put("lac", com.tencent.token.upload.h.b(RqdApplication.l()));
    localJSONObject.put("latitude", com.tencent.token.upload.h.a(RqdApplication.l(), g.c));
    localJSONObject.put("longitude", com.tencent.token.upload.h.a(RqdApplication.l(), g.d));
    localJSONObject.put("gps_open", com.tencent.token.upload.h.d(RqdApplication.l()));
    paramJSONObject.put("device_info_location", localJSONObject);
  }
  
  protected String a()
  {
    if (cv.a().b() == null)
    {
      this.a.b(104);
      return null;
    }
    return com.tencent.token.global.c.e() + "/cn/mbtoken3/mbtoken3_device_info_report_encrypt";
  }
  
  protected void a(ev paramev)
  {
    this.d = paramev.j;
    this.e = ((Long)paramev.c.get("param.realuin")).longValue();
    this.f = ((Long)paramev.c.get("param.uinhash")).longValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      com.tencent.token.global.h.a(this + "json=" + paramJSONObject);
      i = paramJSONObject.optInt("seq_id");
      if (i != this.d)
      {
        this.a.b(10030);
        com.tencent.token.global.h.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.d);
        return;
      }
      if (1 == paramJSONObject.optInt("user_action_report"))
      {
        a.a().a(true);
        com.tencent.token.global.h.c("isNeedUpload:true");
      }
      for (;;)
      {
        this.a.c();
        return;
        a.a().a(false);
        com.tencent.token.global.h.c("isNeedUpload:false");
      }
    }
    com.tencent.token.global.h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  public ev b(ev paramev)
  {
    int i = paramev.j;
    paramev.m = 1;
    paramev.n = new ContentValues(3);
    paramev.n.put("aq_base_sid", cv.a().b());
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("uin", this.f);
      com.tencent.token.global.h.a("mRealUin=" + this.e + ",uinHash=" + this.f);
      ((JSONObject)localObject).put("seq_id", i);
      ((JSONObject)localObject).put("op_time", (int)(cx.c().s() / 1000L));
      ((JSONObject)localObject).put("token_seq", cx.c().k());
      b((JSONObject)localObject);
      localObject = w.b(((JSONObject)localObject).toString().getBytes());
      paramev.n.put("data", (String)localObject);
      return paramev;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramev;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDeviceInfoReport
 * JD-Core Version:    0.7.0.1
 */
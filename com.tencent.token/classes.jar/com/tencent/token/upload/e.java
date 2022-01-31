package com.tencent.token.upload;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.gk;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.upload.useraction.a;
import com.tencent.token.utils.w;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private static e a = null;
  private int b;
  
  public static e a()
  {
    if (a == null) {
      a = new e();
    }
    return a;
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("cpu_info", c.a());
    localJSONObject.put("available_internal_memory_size", i.b());
    localJSONObject.put("available_sd_card_size", i.d());
    localJSONObject.put("band_ver", f.v());
    localJSONObject.put("battery_level_and_status", f.b());
    localJSONObject.put("cpu_hardware", c.c());
    localJSONObject.put("cpu_serial", c.b());
    localJSONObject.put("cpu_count", c.d());
    localJSONObject.put("cpu_frequent", c.e());
    localJSONObject.put("cpu_name", c.a());
    localJSONObject.put("imei", f.a(RqdApplication.l()));
    localJSONObject.put("imsi", f.b(RqdApplication.l()));
    localJSONObject.put("mac_address", f.d(RqdApplication.l()));
    localJSONObject.put("memory_size", i.a(RqdApplication.l()));
    localJSONObject.put("phone_number", f.c(RqdApplication.l()));
    localJSONObject.put("sd_card_size", i.e());
    localJSONObject.put("sim_serial", f.c());
    localJSONObject.put("screen_dpi", p.c(RqdApplication.l()));
    localJSONObject.put("screen_height", p.a(RqdApplication.l()));
    localJSONObject.put("screen_resolution", p.e(RqdApplication.l()));
    localJSONObject.put("screen_width", p.b(RqdApplication.l()));
    localJSONObject.put("sensor_info", q.b(RqdApplication.l()));
    localJSONObject.put("serial_number", f.c());
    localJSONObject.put("support_instruction_sets", f.y());
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
    paramJSONObject.put("device_info_device", localJSONObject);
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
    paramJSONObject.put("device_info_network", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("all_app_name", b.b(RqdApplication.l()));
    localJSONObject.put("android_id", f.e(RqdApplication.l()));
    localJSONObject.put("kernel_version", f.d());
    localJSONObject.put("language", f.j());
    localJSONObject.put("system_boot_time", f.e());
    localJSONObject.put("system_boot_time_length", f.f());
    localJSONObject.put("time_zone", f.k());
    localJSONObject.put("build_display_id", f.w());
    localJSONObject.put("build_tags", f.x());
    localJSONObject.put("build_version_incremental", f.m());
    localJSONObject.put("build_version_release", f.n());
    localJSONObject.put("build_version_sdk", f.o());
    localJSONObject.put("kernel_qume", f.h());
    localJSONObject.put("os_name", f.l());
    localJSONObject.put("product_board", f.p());
    localJSONObject.put("product_brand", f.q());
    localJSONObject.put("product_device", f.r());
    localJSONObject.put("product_manufacture", f.s());
    localJSONObject.put("product_model", f.t());
    localJSONObject.put("product_name", f.u());
    localJSONObject.put("usb_stat", f.f(RqdApplication.l()));
    localJSONObject.put("is_emulator", f.i());
    localJSONObject.put("is_rooted", f.g());
    localJSONObject.put("app_boot_time", f.a());
    paramJSONObject.put("device_info_env", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("cell_id", h.a(RqdApplication.l()));
    localJSONObject.put("cell_rssi", h.c(RqdApplication.l()));
    localJSONObject.put("lac", h.b(RqdApplication.l()));
    localJSONObject.put("latitude", h.a(RqdApplication.l(), g.c));
    localJSONObject.put("longitude", h.a(RqdApplication.l(), g.d));
    localJSONObject.put("gps_open", h.d(RqdApplication.l()));
    paramJSONObject.put("device_info_location", localJSONObject);
  }
  
  public com.tencent.token.global.f b()
  {
    com.tencent.token.global.f localf = new com.tencent.token.global.f();
    try
    {
      Object localObject1 = do.a();
      com.tencent.token.global.h.c("====上报信息开始====");
      i = cw.a + 1;
      cw.a = i;
      this.b = i;
      Object localObject4 = new JSONObject();
      try
      {
        ((JSONObject)localObject4).put("uin", ((do)localObject1).e().mUin);
        com.tencent.token.global.h.a("mRealUin=" + ((do)localObject1).e().mRealUin + ",uinHash=" + ((do)localObject1).e().mUin);
        ((JSONObject)localObject4).put("seq_id", this.b);
        ((JSONObject)localObject4).put("op_time", (int)(cx.c().s() / 1000L));
        ((JSONObject)localObject4).put("token_seq", cx.c().k());
        a((JSONObject)localObject4);
        localObject1 = w.b(((JSONObject)localObject4).toString().getBytes());
        localObject4 = com.tencent.token.global.c.e() + "/cn/mbtoken3/mbtoken3_device_info_report_encrypt";
        ContentValues localContentValues = new ContentValues(3);
        localContentValues.put("aq_base_sid", cv.a().b());
        localContentValues.put("data", (String)localObject1);
        com.tencent.token.global.h.a("deviceinfo aq_base_sid=" + cv.a().b());
        com.tencent.token.global.h.a("deviceinfo data=" + (String)localObject1);
        localObject1 = new gk();
        localObject4 = ((gk)localObject1).a((String)localObject4, localContentValues);
        if (localObject4 == null)
        {
          localf.a(((gk)localObject1).a());
          return localf;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
          localObject2 = "";
        }
        localObject2 = new JSONObject(new String((byte[])localObject4));
        i = ((JSONObject)localObject2).getInt("err");
        com.tencent.token.global.h.c("errCode:" + i);
        com.tencent.token.global.h.c("====上报信息结束====");
        if (i == 0) {
          break label482;
        }
      }
      Object localObject2 = ((JSONObject)localObject2).getString("info");
      com.tencent.token.global.h.c(i + "--" + (String)localObject2);
      localf.a(i, (String)localObject2, (String)localObject2);
      return localf;
    }
    catch (JSONException localJSONException)
    {
      com.tencent.token.global.h.c("parse json failed: " + localJSONException.toString());
      localf.a(10020, "JSONException:" + localJSONException.toString());
      return localf;
      Object localObject3 = w.c(localJSONException.getString("data"));
      if (localObject3 == null) {
        break label706;
      }
      localObject3 = new JSONObject(new String((byte[])localObject3));
      com.tencent.token.global.h.a(this + "json=" + localObject3);
      int i = ((JSONObject)localObject3).optInt("seq_id");
      if (i != this.b)
      {
        localf.b(10030);
        com.tencent.token.global.h.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.b);
        return localf;
      }
    }
    catch (Exception localException2)
    {
      label482:
      com.tencent.token.global.h.c("unknown err: " + localException2.toString());
      localf.a(10021, "JSONException:" + localException2.toString());
      return localf;
    }
    if (1 == localException2.optInt("user_action_report"))
    {
      a.a().a(true);
      com.tencent.token.global.h.c("isNeedUpload:true");
    }
    for (;;)
    {
      localf.c();
      return localf;
      a.a().a(false);
      com.tencent.token.global.h.c("isNeedUpload:false");
    }
    label706:
    com.tencent.token.global.h.c("parseJSON error decodeData=" + localException2);
    localf.a(10022, RqdApplication.l().getString(2131230925));
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.e
 * JD-Core Version:    0.7.0.1
 */
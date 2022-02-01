package com.tencent.token.upload;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cs;
import com.tencent.token.fc;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.upload.useraction.a;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static d a;
  private int b;
  
  public static d a()
  {
    if (a == null) {
      a = new d();
    }
    return a;
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("cpu_info", c.a());
    localJSONObject.put("available_internal_memory_size", h.b());
    localJSONObject.put("available_sd_card_size", h.d());
    localJSONObject.put("band_ver", e.v());
    localJSONObject.put("battery_level_and_status", e.b());
    localJSONObject.put("cpu_hardware", c.c());
    localJSONObject.put("cpu_serial", c.b());
    localJSONObject.put("cpu_count", c.d());
    localJSONObject.put("cpu_frequent", c.e());
    localJSONObject.put("cpu_name", c.a());
    localJSONObject.put("imei", e.a(RqdApplication.n()));
    localJSONObject.put("imsi", e.b(RqdApplication.n()));
    localJSONObject.put("mac_address", e.d(RqdApplication.n()));
    localJSONObject.put("memory_size", h.a(RqdApplication.n()));
    localJSONObject.put("phone_number", e.c(RqdApplication.n()));
    localJSONObject.put("sd_card_size", h.e());
    localJSONObject.put("sim_serial", e.c());
    localJSONObject.put("screen_dpi", j.c(RqdApplication.n()));
    localJSONObject.put("screen_height", j.a(RqdApplication.n()));
    localJSONObject.put("screen_resolution", j.e(RqdApplication.n()));
    localJSONObject.put("screen_width", j.b(RqdApplication.n()));
    localJSONObject.put("sensor_info", k.b(RqdApplication.n()));
    localJSONObject.put("serial_number", e.c());
    localJSONObject.put("support_instruction_sets", e.y());
    localJSONObject.put("system_lock_screen_status", j.g(RqdApplication.n()));
    localJSONObject.put("system_volume_setting", l.a(RqdApplication.n()));
    localJSONObject.put("total_internal_memory_size", h.c());
    localJSONObject.put("voice_mail_number", l.b(RqdApplication.n()));
    localJSONObject.put("voice_mail_tag", l.c(RqdApplication.n()));
    localJSONObject.put("acclerometer", k.c(RqdApplication.n()));
    localJSONObject.put("magnetic", k.d(RqdApplication.n()));
    localJSONObject.put("gyroscope", k.e(RqdApplication.n()));
    localJSONObject.put("gravity", k.f(RqdApplication.n()));
    localJSONObject.put("linear_accleration", k.g(RqdApplication.n()));
    localJSONObject.put("light", k.h(RqdApplication.n()));
    localJSONObject.put("proximity", k.i(RqdApplication.n()));
    localJSONObject.put("temperature", k.j(RqdApplication.n()));
    localJSONObject.put("pressure", k.k(RqdApplication.n()));
    paramJSONObject.put("device_info_device", localJSONObject);
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
    paramJSONObject.put("device_info_network", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("all_app_name", b.b(RqdApplication.n()));
    localJSONObject.put("android_id", e.e(RqdApplication.n()));
    localJSONObject.put("kernel_version", e.d());
    localJSONObject.put("language", e.j());
    localJSONObject.put("system_boot_time", e.e());
    localJSONObject.put("system_boot_time_length", e.f());
    localJSONObject.put("time_zone", e.k());
    localJSONObject.put("build_display_id", e.w());
    localJSONObject.put("build_tags", e.x());
    localJSONObject.put("build_version_incremental", e.m());
    localJSONObject.put("build_version_release", e.n());
    localJSONObject.put("build_version_sdk", e.o());
    localJSONObject.put("kernel_qume", e.h());
    localJSONObject.put("os_name", e.l());
    localJSONObject.put("product_board", e.p());
    localJSONObject.put("product_brand", e.q());
    localJSONObject.put("product_device", e.r());
    localJSONObject.put("product_manufacture", e.s());
    localJSONObject.put("product_model", e.t());
    localJSONObject.put("product_name", e.u());
    localJSONObject.put("usb_stat", e.f(RqdApplication.n()));
    localJSONObject.put("is_emulator", e.i());
    localJSONObject.put("is_rooted", e.g());
    localJSONObject.put("app_boot_time", e.a());
    paramJSONObject.put("device_info_env", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("cell_id", g.a(RqdApplication.n()));
    localJSONObject.put("cell_rssi", g.c(RqdApplication.n()));
    localJSONObject.put("lac", g.b(RqdApplication.n()));
    localJSONObject.put("latitude", g.a(RqdApplication.n(), f.c));
    localJSONObject.put("longitude", g.a(RqdApplication.n(), f.d));
    localJSONObject.put("gps_open", g.d(RqdApplication.n()));
    paramJSONObject.put("device_info_location", localJSONObject);
  }
  
  public com.tencent.token.global.e b()
  {
    com.tencent.token.global.e locale = new com.tencent.token.global.e();
    try
    {
      Object localObject2 = cs.a();
      com.tencent.token.global.g.c("====上报信息开始====");
      int i = cc.a + 1;
      cc.a = i;
      this.b = i;
      Object localObject4 = new JSONObject();
      Object localObject1 = "";
      try
      {
        ((JSONObject)localObject4).put("uin", ((cs)localObject2).e().mUin);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mRealUin=");
        localStringBuilder.append(((cs)localObject2).e().mRealUin);
        localStringBuilder.append(",uinHash=");
        localStringBuilder.append(((cs)localObject2).e().mUin);
        com.tencent.token.global.g.a(localStringBuilder.toString());
        ((JSONObject)localObject4).put("seq_id", this.b);
        ((JSONObject)localObject4).put("op_time", (int)(cd.c().s() / 1000L));
        ((JSONObject)localObject4).put("token_seq", cd.c().k());
        a((JSONObject)localObject4);
        localObject2 = com.tencent.token.utils.l.b(((JSONObject)localObject4).toString().getBytes());
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(com.tencent.token.global.c.e());
      ((StringBuilder)localObject3).append("/cn/mbtoken3/mbtoken3_device_info_report_encrypt");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new ContentValues(3);
      ((ContentValues)localObject4).put("aq_base_sid", cb.a().b());
      ((ContentValues)localObject4).put("data", (String)localObject1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deviceinfo aq_base_sid=");
      localStringBuilder.append(cb.a().b());
      com.tencent.token.global.g.a(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("deviceinfo data=");
      localStringBuilder.append((String)localObject1);
      com.tencent.token.global.g.a(localStringBuilder.toString());
      localObject1 = new fc();
      localObject3 = ((fc)localObject1).a((String)localObject3, (ContentValues)localObject4);
      if (localObject3 == null)
      {
        locale.a(((fc)localObject1).a());
        return locale;
      }
      localObject1 = new JSONObject(new String((byte[])localObject3));
      i = ((JSONObject)localObject1).getInt("err");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("errCode:");
      ((StringBuilder)localObject3).append(i);
      com.tencent.token.global.g.c(((StringBuilder)localObject3).toString());
      com.tencent.token.global.g.c("====上报信息结束====");
      if (i != 0)
      {
        localObject1 = ((JSONObject)localObject1).getString("info");
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("--");
        ((StringBuilder)localObject3).append((String)localObject1);
        com.tencent.token.global.g.c(((StringBuilder)localObject3).toString());
        locale.a(i, (String)localObject1, (String)localObject1);
        return locale;
      }
      localObject1 = com.tencent.token.utils.l.c(((JSONObject)localObject1).getString("data"));
      if (localObject1 != null)
      {
        localObject1 = new JSONObject(new String((byte[])localObject1));
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this);
        ((StringBuilder)localObject3).append("json=");
        ((StringBuilder)localObject3).append(localObject1);
        com.tencent.token.global.g.a(((StringBuilder)localObject3).toString());
        i = ((JSONObject)localObject1).optInt("seq_id");
        if (i != this.b)
        {
          locale.b(10030);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("parseJSON error seq is wrong seq=");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(",right = ");
          ((StringBuilder)localObject1).append(this.b);
          com.tencent.token.global.g.c(((StringBuilder)localObject1).toString());
          return locale;
        }
        if (1 == ((JSONObject)localObject1).optInt("user_action_report"))
        {
          a.a().a(true);
          com.tencent.token.global.g.c("isNeedUpload:true");
        }
        else
        {
          a.a().a(false);
          com.tencent.token.global.g.c("isNeedUpload:false");
        }
        locale.c();
        return locale;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("parseJSON error decodeData=");
      ((StringBuilder)localObject3).append(localObject1);
      com.tencent.token.global.g.c(((StringBuilder)localObject3).toString());
      locale.a(10022, RqdApplication.n().getString(2131493068));
      return locale;
    }
    catch (Exception localException1)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("unknown err: ");
      ((StringBuilder)localObject3).append(localException1.toString());
      com.tencent.token.global.g.c(((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("JSONException:");
      ((StringBuilder)localObject3).append(localException1.toString());
      locale.a(10021, ((StringBuilder)localObject3).toString());
      return locale;
    }
    catch (JSONException localJSONException)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("parse json failed: ");
      ((StringBuilder)localObject3).append(localJSONException.toString());
      com.tencent.token.global.g.c(((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("JSONException:");
      ((StringBuilder)localObject3).append(localJSONException.toString());
      locale.a(10020, ((StringBuilder)localObject3).toString());
    }
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class up
  extends ud
{
  public int d;
  private long e;
  private long f;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.d = paramabm.j;
    this.e = ((Long)paramabm.c.get("param.realuin")).longValue();
    this.f = ((Long)paramabm.c.get("param.uinhash")).longValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append("json=");
      localStringBuilder.append(paramJSONObject);
      xv.a(localStringBuilder.toString());
      i = paramJSONObject.optInt("seq_id");
      if (i != this.d)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.d);
        xv.c(paramJSONObject.toString());
        return;
      }
      if (1 == paramJSONObject.optInt("user_action_report"))
      {
        aan.a();
        aan.g = true;
        xv.c("isNeedUpload:true");
      }
      else
      {
        aan.a();
        aan.g = false;
        xv.c("isNeedUpload:false");
      }
      this.a.a = 0;
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
  
  public final abm b(abm paramabm)
  {
    int i = paramabm.j;
    paramabm.m = 1;
    paramabm.n = new ContentValues(3);
    Object localObject1 = paramabm.n;
    st.a();
    ((ContentValues)localObject1).put("aq_base_sid", null);
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("uin", this.f);
      Object localObject2 = new StringBuilder("mRealUin=");
      ((StringBuilder)localObject2).append(this.e);
      ((StringBuilder)localObject2).append(",uinHash=");
      ((StringBuilder)localObject2).append(this.f);
      xv.a(((StringBuilder)localObject2).toString());
      ((JSONObject)localObject1).put("seq_id", i);
      sv.b();
      ((JSONObject)localObject1).put("op_time", (int)((System.currentTimeMillis() + 0L) / 1000L));
      sv.b();
      ((JSONObject)localObject1).put("token_seq", 0L);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("cpu_info", aae.a());
      ((JSONObject)localObject2).put("available_internal_memory_size", aai.a());
      ((JSONObject)localObject2).put("available_sd_card_size", aai.c());
      ((JSONObject)localObject2).put("band_ver", aag.y());
      ((JSONObject)localObject2).put("battery_level_and_status", aag.b());
      ((JSONObject)localObject2).put("cpu_hardware", aae.c());
      ((JSONObject)localObject2).put("cpu_serial", aae.b());
      ((JSONObject)localObject2).put("cpu_count", aae.d());
      ((JSONObject)localObject2).put("cpu_frequent", aae.e());
      ((JSONObject)localObject2).put("cpu_name", aae.a());
      RqdApplication.n();
      ((JSONObject)localObject2).put("imei", aag.d());
      RqdApplication.n();
      ((JSONObject)localObject2).put("imsi", aag.e());
      ((JSONObject)localObject2).put("mac_address", aag.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("memory_size", aai.a(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject2).put("phone_number", aag.f());
      ((JSONObject)localObject2).put("sd_card_size", aai.d());
      ((JSONObject)localObject2).put("sim_serial", aag.c());
      ((JSONObject)localObject2).put("screen_dpi", aak.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("screen_height", aak.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("screen_resolution", aak.d(RqdApplication.n()));
      ((JSONObject)localObject2).put("screen_width", aak.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("sensor_info", aal.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("serial_number", aag.c());
      ((JSONObject)localObject2).put("support_instruction_sets", aag.B());
      ((JSONObject)localObject2).put("system_lock_screen_status", aak.e(RqdApplication.n()));
      ((JSONObject)localObject2).put("system_volume_setting", aam.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("total_internal_memory_size", aai.b());
      ((JSONObject)localObject2).put("voice_mail_number", aam.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("voice_mail_tag", aam.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("acclerometer", aal.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("magnetic", aal.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("gyroscope", aal.d(RqdApplication.n()));
      ((JSONObject)localObject2).put("gravity", aal.e(RqdApplication.n()));
      ((JSONObject)localObject2).put("linear_accleration", aal.f(RqdApplication.n()));
      ((JSONObject)localObject2).put("light", aal.g(RqdApplication.n()));
      ((JSONObject)localObject2).put("proximity", aal.h(RqdApplication.n()));
      ((JSONObject)localObject2).put("temperature", aal.i(RqdApplication.n()));
      ((JSONObject)localObject2).put("pressure", aal.j(RqdApplication.n()));
      ((JSONObject)localObject1).put("device_info_device", ((JSONObject)localObject2).toString());
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("network_interfaces", aaj.b());
      ((JSONObject)localObject2).put("air_plane_mode", aaj.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("network_connection_type", aaj.m(RqdApplication.n()));
      ((JSONObject)localObject2).put("network_operator_name", aaj.k(RqdApplication.n()));
      ((JSONObject)localObject2).put("network_type", aaj.l(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject2).put("network_type_and_ip_address", aaj.c());
      ((JSONObject)localObject2).put("operator_name", aaj.k(RqdApplication.n()));
      ((JSONObject)localObject2).put("operator_type", aaj.b(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject2).put("phone_ip", aaj.c());
      ((JSONObject)localObject2).put("wifi_bass_id", aaj.g(RqdApplication.n()));
      ((JSONObject)localObject2).put("gsm_sim_stat", aaj.a(0));
      ((JSONObject)localObject2).put("gsm_sim_stat2", aaj.a(1));
      ((JSONObject)localObject2).put("wifi_interface", aaj.d());
      ((JSONObject)localObject2).put("wifi_encrypted", aaj.d(RqdApplication.n()));
      ((JSONObject)localObject2).put("mcc", aaj.i(RqdApplication.n()));
      ((JSONObject)localObject2).put("mnc", aaj.j(RqdApplication.n()));
      ((JSONObject)localObject2).put("wifi_ssid", aaj.f(RqdApplication.n()));
      ((JSONObject)localObject2).put("wifi_list_near_by", aaj.e(RqdApplication.n()));
      ((JSONObject)localObject2).put("wifi_strength", aaj.h(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject2).put("ip_address", aaj.c());
      ((JSONObject)localObject2).put("is_wifi_active", aaj.c(RqdApplication.n()));
      ((JSONObject)localObject1).put("device_info_device", localObject2);
      localObject2 = new JSONObject();
      RqdApplication.n();
      ((JSONObject)localObject2).put("all_app_name", new JSONArray());
      ((JSONObject)localObject2).put("android_id", aag.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("kernel_version", aag.g());
      ((JSONObject)localObject2).put("language", aag.m());
      ((JSONObject)localObject2).put("system_boot_time", aag.h());
      ((JSONObject)localObject2).put("system_boot_time_length", aag.i());
      ((JSONObject)localObject2).put("time_zone", aag.n());
      ((JSONObject)localObject2).put("build_display_id", aag.z());
      ((JSONObject)localObject2).put("build_tags", aag.A());
      ((JSONObject)localObject2).put("build_version_incremental", aag.p());
      ((JSONObject)localObject2).put("build_version_release", aag.q());
      ((JSONObject)localObject2).put("build_version_sdk", aag.r());
      ((JSONObject)localObject2).put("kernel_qume", aag.k());
      ((JSONObject)localObject2).put("os_name", aag.o());
      ((JSONObject)localObject2).put("product_board", aag.s());
      ((JSONObject)localObject2).put("product_brand", aag.t());
      ((JSONObject)localObject2).put("product_device", aag.u());
      ((JSONObject)localObject2).put("product_manufacture", aag.v());
      ((JSONObject)localObject2).put("product_model", aag.w());
      ((JSONObject)localObject2).put("product_name", aag.x());
      ((JSONObject)localObject2).put("usb_stat", aag.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("is_emulator", aag.l());
      ((JSONObject)localObject2).put("is_rooted", aag.j());
      ((JSONObject)localObject2).put("app_boot_time", aag.a());
      ((JSONObject)localObject1).put("device_info_env", localObject2);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("cell_id", aah.b);
      ((JSONObject)localObject2).put("cell_rssi", 0);
      ((JSONObject)localObject2).put("lac", aah.b);
      ((JSONObject)localObject2).put("latitude", aah.b);
      ((JSONObject)localObject2).put("longitude", aah.b);
      ((JSONObject)localObject2).put("gps_open", 0);
      ((JSONObject)localObject1).put("device_info_location", localObject2);
      localObject1 = aay.b(((JSONObject)localObject1).toString().getBytes());
      paramabm.n.put("data", (String)localObject1);
      return paramabm;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramabm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.up
 * JD-Core Version:    0.7.0.1
 */
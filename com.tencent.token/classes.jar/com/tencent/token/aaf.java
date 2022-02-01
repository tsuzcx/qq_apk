package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aaf
{
  private static aaf a;
  private int b;
  
  public static aaf a()
  {
    if (a == null) {
      a = new aaf();
    }
    return a;
  }
  
  public final xt b()
  {
    xt localxt = new xt();
    try
    {
      tt localtt = tt.a();
      xv.c("====上报信息开始====");
      localObject2 = new JSONObject();
      Object localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("cpu_info", aae.a());
      ((JSONObject)localObject3).put("available_internal_memory_size", aai.a());
      ((JSONObject)localObject3).put("available_sd_card_size", aai.c());
      ((JSONObject)localObject3).put("band_ver", aag.y());
      ((JSONObject)localObject3).put("battery_level_and_status", aag.b());
      ((JSONObject)localObject3).put("cpu_hardware", aae.c());
      ((JSONObject)localObject3).put("cpu_serial", aae.b());
      ((JSONObject)localObject3).put("cpu_count", aae.d());
      ((JSONObject)localObject3).put("cpu_frequent", aae.e());
      ((JSONObject)localObject3).put("cpu_name", aae.a());
      RqdApplication.n();
      ((JSONObject)localObject3).put("imei", aag.d());
      RqdApplication.n();
      ((JSONObject)localObject3).put("imsi", aag.e());
      ((JSONObject)localObject3).put("mac_address", aag.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("memory_size", aai.a(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject3).put("phone_number", aag.f());
      ((JSONObject)localObject3).put("sd_card_size", aai.d());
      ((JSONObject)localObject3).put("sim_serial", aag.c());
      ((JSONObject)localObject3).put("screen_dpi", aak.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("screen_height", aak.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("screen_resolution", aak.d(RqdApplication.n()));
      ((JSONObject)localObject3).put("screen_width", aak.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("sensor_info", aal.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("serial_number", aag.c());
      ((JSONObject)localObject3).put("support_instruction_sets", aag.B());
      ((JSONObject)localObject3).put("system_lock_screen_status", aak.e(RqdApplication.n()));
      ((JSONObject)localObject3).put("system_volume_setting", aam.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("total_internal_memory_size", aai.b());
      ((JSONObject)localObject3).put("voice_mail_number", aam.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("voice_mail_tag", aam.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("acclerometer", aal.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("magnetic", aal.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("gyroscope", aal.d(RqdApplication.n()));
      ((JSONObject)localObject3).put("gravity", aal.e(RqdApplication.n()));
      ((JSONObject)localObject3).put("linear_accleration", aal.f(RqdApplication.n()));
      ((JSONObject)localObject3).put("light", aal.g(RqdApplication.n()));
      ((JSONObject)localObject3).put("proximity", aal.h(RqdApplication.n()));
      ((JSONObject)localObject3).put("temperature", aal.i(RqdApplication.n()));
      ((JSONObject)localObject3).put("pressure", aal.j(RqdApplication.n()));
      ((JSONObject)localObject2).put("device_info_device", localObject3);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("network_interfaces", aaj.b());
      ((JSONObject)localObject3).put("air_plane_mode", aaj.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("network_connection_type", aaj.m(RqdApplication.n()));
      ((JSONObject)localObject3).put("network_operator_name", aaj.k(RqdApplication.n()));
      ((JSONObject)localObject3).put("network_type", aaj.l(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject3).put("network_type_and_ip_address", aaj.c());
      ((JSONObject)localObject3).put("operator_name", aaj.k(RqdApplication.n()));
      ((JSONObject)localObject3).put("operator_type", aaj.b(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject3).put("phone_ip", aaj.c());
      ((JSONObject)localObject3).put("wifi_bass_id", aaj.g(RqdApplication.n()));
      ((JSONObject)localObject3).put("gsm_sim_stat", aaj.a(0));
      ((JSONObject)localObject3).put("gsm_sim_stat2", aaj.a(1));
      ((JSONObject)localObject3).put("wifi_interface", aaj.d());
      ((JSONObject)localObject3).put("wifi_encrypted", aaj.d(RqdApplication.n()));
      ((JSONObject)localObject3).put("mcc", aaj.i(RqdApplication.n()));
      ((JSONObject)localObject3).put("mnc", aaj.j(RqdApplication.n()));
      ((JSONObject)localObject3).put("wifi_ssid", aaj.f(RqdApplication.n()));
      ((JSONObject)localObject3).put("wifi_list_near_by", aaj.e(RqdApplication.n()));
      ((JSONObject)localObject3).put("wifi_strength", aaj.h(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject3).put("ip_address", aaj.c());
      ((JSONObject)localObject3).put("is_wifi_active", aaj.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("device_info_network", localObject3);
      localObject3 = new JSONObject();
      RqdApplication.n();
      ((JSONObject)localObject3).put("all_app_name", new JSONArray());
      ((JSONObject)localObject3).put("android_id", aag.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("kernel_version", aag.g());
      ((JSONObject)localObject3).put("language", aag.m());
      ((JSONObject)localObject3).put("system_boot_time", aag.h());
      ((JSONObject)localObject3).put("system_boot_time_length", aag.i());
      ((JSONObject)localObject3).put("time_zone", aag.n());
      ((JSONObject)localObject3).put("build_display_id", aag.z());
      ((JSONObject)localObject3).put("build_tags", aag.A());
      ((JSONObject)localObject3).put("build_version_incremental", aag.p());
      ((JSONObject)localObject3).put("build_version_release", aag.q());
      ((JSONObject)localObject3).put("build_version_sdk", aag.r());
      ((JSONObject)localObject3).put("kernel_qume", aag.k());
      ((JSONObject)localObject3).put("os_name", aag.o());
      ((JSONObject)localObject3).put("product_board", aag.s());
      ((JSONObject)localObject3).put("product_brand", aag.t());
      ((JSONObject)localObject3).put("product_device", aag.u());
      ((JSONObject)localObject3).put("product_manufacture", aag.v());
      ((JSONObject)localObject3).put("product_model", aag.w());
      ((JSONObject)localObject3).put("product_name", aag.x());
      ((JSONObject)localObject3).put("usb_stat", aag.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("is_emulator", aag.l());
      ((JSONObject)localObject3).put("is_rooted", aag.j());
      ((JSONObject)localObject3).put("app_boot_time", aag.a());
      ((JSONObject)localObject2).put("device_info_env", localObject3);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("cell_id", aah.b);
      ((JSONObject)localObject3).put("cell_rssi", 0);
      ((JSONObject)localObject3).put("lac", aah.b);
      ((JSONObject)localObject3).put("latitude", aah.b);
      ((JSONObject)localObject3).put("longitude", aah.b);
      ((JSONObject)localObject3).put("gps_open", 0);
      ((JSONObject)localObject2).put("device_info_location", localObject3);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject3 = new AtomicReference(null);
      rt.a().a(localtt.k.b().mUin, (JSONObject)localObject2, new rt.a()
      {
        public final void a(rv paramAnonymousrv)
        {
          this.a.set(paramAnonymousrv);
          localCountDownLatch.countDown();
        }
      });
      try
      {
        localCountDownLatch.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      Object localObject1 = (rv)((AtomicReference)localObject3).get();
      if (localObject1 == null)
      {
        localxt.a(-357, null, null);
        return localxt;
      }
      int i = ((rv)localObject1).b;
      xv.c("errCode:".concat(String.valueOf(i)));
      xv.c("====上报信息结束====");
      if (i != 0)
      {
        localObject1 = ((rv)localObject1).d;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("--");
        ((StringBuilder)localObject2).append((String)localObject1);
        xv.c(((StringBuilder)localObject2).toString());
        localxt.a(i, (String)localObject1, (String)localObject1);
        return localxt;
      }
      localObject1 = ((rv)localObject1).c;
      if (localObject1 != null)
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this);
        ((StringBuilder)localObject2).append("json=");
        ((StringBuilder)localObject2).append(localObject1);
        xv.a(((StringBuilder)localObject2).toString());
        i = ((JSONObject)localObject1).optInt("seq_id");
        if (i != this.b)
        {
          localxt.a(10030, null, null);
          localObject1 = new StringBuilder("parseJSON error seq is wrong seq=");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(",right = ");
          ((StringBuilder)localObject1).append(this.b);
          xv.c(((StringBuilder)localObject1).toString());
          return localxt;
        }
        if (1 == ((JSONObject)localObject1).optInt("user_action_report"))
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
        localxt.a = 0;
        return localxt;
      }
      xv.c("parseJSON error decodeData");
      localxt.a(10022, RqdApplication.n().getString(2131493069), null);
      return localxt;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder("unknown err: ");
      ((StringBuilder)localObject2).append(localException.toString());
      xv.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localException.toString());
      localxt.a(10021, ((StringBuilder)localObject2).toString(), null);
      return localxt;
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = new StringBuilder("parse json failed: ");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      xv.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      localxt.a(10020, ((StringBuilder)localObject2).toString(), null);
    }
    return localxt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aaf
 * JD-Core Version:    0.7.0.1
 */
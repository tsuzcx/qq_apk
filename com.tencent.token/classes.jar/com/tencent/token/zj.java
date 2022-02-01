package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class zj
{
  private static zj a;
  private int b;
  
  public static zj a()
  {
    if (a == null) {
      a = new zj();
    }
    return a;
  }
  
  public final wz b()
  {
    wz localwz = new wz();
    try
    {
      ta localta = ta.a();
      xb.c("====上报信息开始====");
      localObject2 = new JSONObject();
      Object localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("cpu_info", zi.a());
      ((JSONObject)localObject3).put("available_internal_memory_size", zn.a());
      ((JSONObject)localObject3).put("available_sd_card_size", zn.c());
      ((JSONObject)localObject3).put("band_ver", zk.v());
      ((JSONObject)localObject3).put("battery_level_and_status", zk.b());
      ((JSONObject)localObject3).put("cpu_hardware", zi.c());
      ((JSONObject)localObject3).put("cpu_serial", zi.b());
      ((JSONObject)localObject3).put("cpu_count", zi.d());
      ((JSONObject)localObject3).put("cpu_frequent", zi.e());
      ((JSONObject)localObject3).put("cpu_name", zi.a());
      ((JSONObject)localObject3).put("imei", zk.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("imsi", zk.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("mac_address", zk.d(RqdApplication.n()));
      ((JSONObject)localObject3).put("memory_size", zn.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("phone_number", zk.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("sd_card_size", zn.d());
      ((JSONObject)localObject3).put("sim_serial", zk.c());
      ((JSONObject)localObject3).put("screen_dpi", zp.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("screen_height", zp.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("screen_resolution", zp.d(RqdApplication.n()));
      ((JSONObject)localObject3).put("screen_width", zp.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("sensor_info", zq.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("serial_number", zk.c());
      ((JSONObject)localObject3).put("support_instruction_sets", zk.y());
      ((JSONObject)localObject3).put("system_lock_screen_status", zp.e(RqdApplication.n()));
      ((JSONObject)localObject3).put("system_volume_setting", zr.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("total_internal_memory_size", zn.b());
      ((JSONObject)localObject3).put("voice_mail_number", zr.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("voice_mail_tag", zr.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("acclerometer", zq.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("magnetic", zq.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("gyroscope", zq.d(RqdApplication.n()));
      ((JSONObject)localObject3).put("gravity", zq.e(RqdApplication.n()));
      ((JSONObject)localObject3).put("linear_accleration", zq.f(RqdApplication.n()));
      ((JSONObject)localObject3).put("light", zq.g(RqdApplication.n()));
      ((JSONObject)localObject3).put("proximity", zq.h(RqdApplication.n()));
      ((JSONObject)localObject3).put("temperature", zq.i(RqdApplication.n()));
      ((JSONObject)localObject3).put("pressure", zq.j(RqdApplication.n()));
      ((JSONObject)localObject2).put("device_info_device", localObject3);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("network_interfaces", zo.b());
      ((JSONObject)localObject3).put("air_plane_mode", zo.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("network_connection_type", zo.m(RqdApplication.n()));
      ((JSONObject)localObject3).put("network_operator_name", zo.k(RqdApplication.n()));
      ((JSONObject)localObject3).put("network_type", zo.l(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject3).put("network_type_and_ip_address", zo.c());
      ((JSONObject)localObject3).put("operator_name", zo.k(RqdApplication.n()));
      ((JSONObject)localObject3).put("operator_type", zo.b(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject3).put("phone_ip", zo.c());
      ((JSONObject)localObject3).put("wifi_bass_id", zo.g(RqdApplication.n()));
      ((JSONObject)localObject3).put("gsm_sim_stat", zo.a(0));
      ((JSONObject)localObject3).put("gsm_sim_stat2", zo.a(1));
      ((JSONObject)localObject3).put("wifi_interface", zo.d());
      ((JSONObject)localObject3).put("wifi_encrypted", zo.d(RqdApplication.n()));
      ((JSONObject)localObject3).put("mcc", zo.i(RqdApplication.n()));
      ((JSONObject)localObject3).put("mnc", zo.j(RqdApplication.n()));
      ((JSONObject)localObject3).put("wifi_ssid", zo.f(RqdApplication.n()));
      ((JSONObject)localObject3).put("wifi_list_near_by", zo.e(RqdApplication.n()));
      ((JSONObject)localObject3).put("wifi_strength", zo.h(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject3).put("ip_address", zo.c());
      ((JSONObject)localObject3).put("is_wifi_active", zo.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("device_info_network", localObject3);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("all_app_name", zh.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("android_id", zk.e(RqdApplication.n()));
      ((JSONObject)localObject3).put("kernel_version", zk.d());
      ((JSONObject)localObject3).put("language", zk.j());
      ((JSONObject)localObject3).put("system_boot_time", zk.e());
      ((JSONObject)localObject3).put("system_boot_time_length", zk.f());
      ((JSONObject)localObject3).put("time_zone", zk.k());
      ((JSONObject)localObject3).put("build_display_id", zk.w());
      ((JSONObject)localObject3).put("build_tags", zk.x());
      ((JSONObject)localObject3).put("build_version_incremental", zk.m());
      ((JSONObject)localObject3).put("build_version_release", zk.n());
      ((JSONObject)localObject3).put("build_version_sdk", zk.o());
      ((JSONObject)localObject3).put("kernel_qume", zk.h());
      ((JSONObject)localObject3).put("os_name", zk.l());
      ((JSONObject)localObject3).put("product_board", zk.p());
      ((JSONObject)localObject3).put("product_brand", zk.q());
      ((JSONObject)localObject3).put("product_device", zk.r());
      ((JSONObject)localObject3).put("product_manufacture", zk.s());
      ((JSONObject)localObject3).put("product_model", zk.t());
      ((JSONObject)localObject3).put("product_name", zk.u());
      ((JSONObject)localObject3).put("usb_stat", zk.f(RqdApplication.n()));
      ((JSONObject)localObject3).put("is_emulator", zk.i());
      ((JSONObject)localObject3).put("is_rooted", zk.g());
      ((JSONObject)localObject3).put("app_boot_time", zk.a());
      ((JSONObject)localObject2).put("device_info_env", localObject3);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("cell_id", zm.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("cell_rssi", zm.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("lac", zm.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("latitude", zm.a(RqdApplication.n(), zl.c));
      ((JSONObject)localObject3).put("longitude", zm.a(RqdApplication.n(), zl.d));
      ((JSONObject)localObject3).put("gps_open", zm.d(RqdApplication.n()));
      ((JSONObject)localObject2).put("device_info_location", localObject3);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject3 = new AtomicReference(null);
      qz.a().a(localta.k.b().mUin, (JSONObject)localObject2, new qz.a()
      {
        public final void a(rb paramAnonymousrb)
        {
          this.a.set(paramAnonymousrb);
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
      Object localObject1 = (rb)((AtomicReference)localObject3).get();
      if (localObject1 == null)
      {
        localwz.a(-357, null, null);
        return localwz;
      }
      int i = ((rb)localObject1).b;
      xb.c("errCode:".concat(String.valueOf(i)));
      xb.c("====上报信息结束====");
      if (i != 0)
      {
        localObject1 = ((rb)localObject1).d;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("--");
        ((StringBuilder)localObject2).append((String)localObject1);
        xb.c(((StringBuilder)localObject2).toString());
        localwz.a(i, (String)localObject1, (String)localObject1);
        return localwz;
      }
      localObject1 = ((rb)localObject1).c;
      if (localObject1 != null)
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this);
        ((StringBuilder)localObject2).append("json=");
        ((StringBuilder)localObject2).append(localObject1);
        xb.a(((StringBuilder)localObject2).toString());
        i = ((JSONObject)localObject1).optInt("seq_id");
        if (i != this.b)
        {
          localwz.a(10030, null, null);
          localObject1 = new StringBuilder("parseJSON error seq is wrong seq=");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(",right = ");
          ((StringBuilder)localObject1).append(this.b);
          xb.c(((StringBuilder)localObject1).toString());
          return localwz;
        }
        if (1 == ((JSONObject)localObject1).optInt("user_action_report"))
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
        localwz.a = 0;
        return localwz;
      }
      xb.c("parseJSON error decodeData");
      localwz.a(10022, RqdApplication.n().getString(2131493068), null);
      return localwz;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder("unknown err: ");
      ((StringBuilder)localObject2).append(localException.toString());
      xb.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localException.toString());
      localwz.a(10021, ((StringBuilder)localObject2).toString(), null);
      return localwz;
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = new StringBuilder("parse json failed: ");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      xb.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      localwz.a(10020, ((StringBuilder)localObject2).toString(), null);
    }
    return localwz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zj
 * JD-Core Version:    0.7.0.1
 */
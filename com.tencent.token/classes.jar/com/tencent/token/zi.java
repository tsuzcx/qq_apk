package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class zi
{
  private static zi a;
  private int b;
  
  public static zi a()
  {
    if (a == null) {
      a = new zi();
    }
    return a;
  }
  
  public final wy b()
  {
    wy localwy = new wy();
    try
    {
      sz localsz = sz.a();
      xa.c("====上报信息开始====");
      localObject2 = new JSONObject();
      Object localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("cpu_info", zh.a());
      ((JSONObject)localObject3).put("available_internal_memory_size", zm.a());
      ((JSONObject)localObject3).put("available_sd_card_size", zm.c());
      ((JSONObject)localObject3).put("band_ver", zj.v());
      ((JSONObject)localObject3).put("battery_level_and_status", zj.b());
      ((JSONObject)localObject3).put("cpu_hardware", zh.c());
      ((JSONObject)localObject3).put("cpu_serial", zh.b());
      ((JSONObject)localObject3).put("cpu_count", zh.d());
      ((JSONObject)localObject3).put("cpu_frequent", zh.e());
      ((JSONObject)localObject3).put("cpu_name", zh.a());
      ((JSONObject)localObject3).put("imei", zj.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("imsi", zj.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("mac_address", zj.d(RqdApplication.n()));
      ((JSONObject)localObject3).put("memory_size", zm.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("phone_number", zj.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("sd_card_size", zm.d());
      ((JSONObject)localObject3).put("sim_serial", zj.c());
      ((JSONObject)localObject3).put("screen_dpi", zo.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("screen_height", zo.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("screen_resolution", zo.d(RqdApplication.n()));
      ((JSONObject)localObject3).put("screen_width", zo.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("sensor_info", zp.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("serial_number", zj.c());
      ((JSONObject)localObject3).put("support_instruction_sets", zj.y());
      ((JSONObject)localObject3).put("system_lock_screen_status", zo.e(RqdApplication.n()));
      ((JSONObject)localObject3).put("system_volume_setting", zq.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("total_internal_memory_size", zm.b());
      ((JSONObject)localObject3).put("voice_mail_number", zq.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("voice_mail_tag", zq.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("acclerometer", zp.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("magnetic", zp.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("gyroscope", zp.d(RqdApplication.n()));
      ((JSONObject)localObject3).put("gravity", zp.e(RqdApplication.n()));
      ((JSONObject)localObject3).put("linear_accleration", zp.f(RqdApplication.n()));
      ((JSONObject)localObject3).put("light", zp.g(RqdApplication.n()));
      ((JSONObject)localObject3).put("proximity", zp.h(RqdApplication.n()));
      ((JSONObject)localObject3).put("temperature", zp.i(RqdApplication.n()));
      ((JSONObject)localObject3).put("pressure", zp.j(RqdApplication.n()));
      ((JSONObject)localObject2).put("device_info_device", localObject3);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("network_interfaces", zn.b());
      ((JSONObject)localObject3).put("air_plane_mode", zn.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("network_connection_type", zn.m(RqdApplication.n()));
      ((JSONObject)localObject3).put("network_operator_name", zn.k(RqdApplication.n()));
      ((JSONObject)localObject3).put("network_type", zn.l(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject3).put("network_type_and_ip_address", zn.c());
      ((JSONObject)localObject3).put("operator_name", zn.k(RqdApplication.n()));
      ((JSONObject)localObject3).put("operator_type", zn.b(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject3).put("phone_ip", zn.c());
      ((JSONObject)localObject3).put("wifi_bass_id", zn.g(RqdApplication.n()));
      ((JSONObject)localObject3).put("gsm_sim_stat", zn.a(0));
      ((JSONObject)localObject3).put("gsm_sim_stat2", zn.a(1));
      ((JSONObject)localObject3).put("wifi_interface", zn.d());
      ((JSONObject)localObject3).put("wifi_encrypted", zn.d(RqdApplication.n()));
      ((JSONObject)localObject3).put("mcc", zn.i(RqdApplication.n()));
      ((JSONObject)localObject3).put("mnc", zn.j(RqdApplication.n()));
      ((JSONObject)localObject3).put("wifi_ssid", zn.f(RqdApplication.n()));
      ((JSONObject)localObject3).put("wifi_list_near_by", zn.e(RqdApplication.n()));
      ((JSONObject)localObject3).put("wifi_strength", zn.h(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject3).put("ip_address", zn.c());
      ((JSONObject)localObject3).put("is_wifi_active", zn.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("device_info_network", localObject3);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("all_app_name", zg.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("android_id", zj.e(RqdApplication.n()));
      ((JSONObject)localObject3).put("kernel_version", zj.d());
      ((JSONObject)localObject3).put("language", zj.j());
      ((JSONObject)localObject3).put("system_boot_time", zj.e());
      ((JSONObject)localObject3).put("system_boot_time_length", zj.f());
      ((JSONObject)localObject3).put("time_zone", zj.k());
      ((JSONObject)localObject3).put("build_display_id", zj.w());
      ((JSONObject)localObject3).put("build_tags", zj.x());
      ((JSONObject)localObject3).put("build_version_incremental", zj.m());
      ((JSONObject)localObject3).put("build_version_release", zj.n());
      ((JSONObject)localObject3).put("build_version_sdk", zj.o());
      ((JSONObject)localObject3).put("kernel_qume", zj.h());
      ((JSONObject)localObject3).put("os_name", zj.l());
      ((JSONObject)localObject3).put("product_board", zj.p());
      ((JSONObject)localObject3).put("product_brand", zj.q());
      ((JSONObject)localObject3).put("product_device", zj.r());
      ((JSONObject)localObject3).put("product_manufacture", zj.s());
      ((JSONObject)localObject3).put("product_model", zj.t());
      ((JSONObject)localObject3).put("product_name", zj.u());
      ((JSONObject)localObject3).put("usb_stat", zj.f(RqdApplication.n()));
      ((JSONObject)localObject3).put("is_emulator", zj.i());
      ((JSONObject)localObject3).put("is_rooted", zj.g());
      ((JSONObject)localObject3).put("app_boot_time", zj.a());
      ((JSONObject)localObject2).put("device_info_env", localObject3);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("cell_id", zl.a(RqdApplication.n()));
      ((JSONObject)localObject3).put("cell_rssi", zl.c(RqdApplication.n()));
      ((JSONObject)localObject3).put("lac", zl.b(RqdApplication.n()));
      ((JSONObject)localObject3).put("latitude", zl.a(RqdApplication.n(), zk.c));
      ((JSONObject)localObject3).put("longitude", zl.a(RqdApplication.n(), zk.d));
      ((JSONObject)localObject3).put("gps_open", zl.d(RqdApplication.n()));
      ((JSONObject)localObject2).put("device_info_location", localObject3);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject3 = new AtomicReference(null);
      qy.a().a(localsz.k.b().mUin, (JSONObject)localObject2, new qy.a()
      {
        public final void a(ra paramAnonymousra)
        {
          this.a.set(paramAnonymousra);
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
      Object localObject1 = (ra)((AtomicReference)localObject3).get();
      if (localObject1 == null)
      {
        localwy.a(-357, null, null);
        return localwy;
      }
      int i = ((ra)localObject1).b;
      xa.c("errCode:".concat(String.valueOf(i)));
      xa.c("====上报信息结束====");
      if (i != 0)
      {
        localObject1 = ((ra)localObject1).d;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("--");
        ((StringBuilder)localObject2).append((String)localObject1);
        xa.c(((StringBuilder)localObject2).toString());
        localwy.a(i, (String)localObject1, (String)localObject1);
        return localwy;
      }
      localObject1 = ((ra)localObject1).c;
      if (localObject1 != null)
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this);
        ((StringBuilder)localObject2).append("json=");
        ((StringBuilder)localObject2).append(localObject1);
        xa.a(((StringBuilder)localObject2).toString());
        i = ((JSONObject)localObject1).optInt("seq_id");
        if (i != this.b)
        {
          localwy.a(10030, null, null);
          localObject1 = new StringBuilder("parseJSON error seq is wrong seq=");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(",right = ");
          ((StringBuilder)localObject1).append(this.b);
          xa.c(((StringBuilder)localObject1).toString());
          return localwy;
        }
        if (1 == ((JSONObject)localObject1).optInt("user_action_report"))
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
        localwy.a = 0;
        return localwy;
      }
      xa.c("parseJSON error decodeData");
      localwy.a(10022, RqdApplication.n().getString(2131493068), null);
      return localwy;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder("unknown err: ");
      ((StringBuilder)localObject2).append(localException.toString());
      xa.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localException.toString());
      localwy.a(10021, ((StringBuilder)localObject2).toString(), null);
      return localwy;
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = new StringBuilder("parse json failed: ");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      xa.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      localwy.a(10020, ((StringBuilder)localObject2).toString(), null);
    }
    return localwy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zi
 * JD-Core Version:    0.7.0.1
 */
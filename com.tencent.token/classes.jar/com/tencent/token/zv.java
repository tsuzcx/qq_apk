package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class zv
{
  private static zv a;
  private int b;
  
  public static zv a()
  {
    if (a == null) {
      a = new zv();
    }
    return a;
  }
  
  public final xh b()
  {
    xh localxh = new xh();
    try
    {
      th localth = th.a();
      xj.c("====上报信息开始====");
      localObject2 = new JSONObject();
      Object localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("cpu_info", zu.a());
      ((JSONObject)localObject3).put("available_internal_memory_size", zy.a());
      ((JSONObject)localObject3).put("available_sd_card_size", zy.c());
      ((JSONObject)localObject3).put("band_ver", zw.v());
      ((JSONObject)localObject3).put("battery_level_and_status", zw.b());
      ((JSONObject)localObject3).put("cpu_hardware", zu.c());
      ((JSONObject)localObject3).put("cpu_serial", zu.b());
      ((JSONObject)localObject3).put("cpu_count", zu.d());
      ((JSONObject)localObject3).put("cpu_frequent", zu.e());
      ((JSONObject)localObject3).put("cpu_name", zu.a());
      ((JSONObject)localObject3).put("imei", zw.a(RqdApplication.p()));
      ((JSONObject)localObject3).put("imsi", zw.b(RqdApplication.p()));
      ((JSONObject)localObject3).put("mac_address", zw.d(RqdApplication.p()));
      ((JSONObject)localObject3).put("memory_size", zy.a(RqdApplication.p()));
      ((JSONObject)localObject3).put("phone_number", zw.c(RqdApplication.p()));
      ((JSONObject)localObject3).put("sd_card_size", zy.d());
      ((JSONObject)localObject3).put("sim_serial", zw.c());
      ((JSONObject)localObject3).put("screen_dpi", aaa.c(RqdApplication.p()));
      ((JSONObject)localObject3).put("screen_height", aaa.a(RqdApplication.p()));
      ((JSONObject)localObject3).put("screen_resolution", aaa.d(RqdApplication.p()));
      ((JSONObject)localObject3).put("screen_width", aaa.b(RqdApplication.p()));
      ((JSONObject)localObject3).put("sensor_info", aab.a(RqdApplication.p()));
      ((JSONObject)localObject3).put("serial_number", zw.c());
      ((JSONObject)localObject3).put("support_instruction_sets", zw.y());
      ((JSONObject)localObject3).put("system_lock_screen_status", aaa.e(RqdApplication.p()));
      ((JSONObject)localObject3).put("system_volume_setting", aac.a(RqdApplication.p()));
      ((JSONObject)localObject3).put("total_internal_memory_size", zy.b());
      ((JSONObject)localObject3).put("voice_mail_number", aac.b(RqdApplication.p()));
      ((JSONObject)localObject3).put("voice_mail_tag", aac.c(RqdApplication.p()));
      ((JSONObject)localObject3).put("acclerometer", aab.b(RqdApplication.p()));
      ((JSONObject)localObject3).put("magnetic", aab.c(RqdApplication.p()));
      ((JSONObject)localObject3).put("gyroscope", aab.d(RqdApplication.p()));
      ((JSONObject)localObject3).put("gravity", aab.e(RqdApplication.p()));
      ((JSONObject)localObject3).put("linear_accleration", aab.f(RqdApplication.p()));
      ((JSONObject)localObject3).put("light", aab.g(RqdApplication.p()));
      ((JSONObject)localObject3).put("proximity", aab.h(RqdApplication.p()));
      ((JSONObject)localObject3).put("temperature", aab.i(RqdApplication.p()));
      ((JSONObject)localObject3).put("pressure", aab.j(RqdApplication.p()));
      ((JSONObject)localObject2).put("device_info_device", localObject3);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("network_interfaces", zz.b());
      ((JSONObject)localObject3).put("air_plane_mode", zz.a(RqdApplication.p()));
      ((JSONObject)localObject3).put("network_connection_type", zz.m(RqdApplication.p()));
      ((JSONObject)localObject3).put("network_operator_name", zz.k(RqdApplication.p()));
      ((JSONObject)localObject3).put("network_type", zz.l(RqdApplication.p()));
      RqdApplication.p();
      ((JSONObject)localObject3).put("network_type_and_ip_address", zz.c());
      ((JSONObject)localObject3).put("operator_name", zz.k(RqdApplication.p()));
      ((JSONObject)localObject3).put("operator_type", zz.b(RqdApplication.p()));
      RqdApplication.p();
      ((JSONObject)localObject3).put("phone_ip", zz.c());
      ((JSONObject)localObject3).put("wifi_bass_id", zz.g(RqdApplication.p()));
      ((JSONObject)localObject3).put("gsm_sim_stat", zz.a(0));
      ((JSONObject)localObject3).put("gsm_sim_stat2", zz.a(1));
      ((JSONObject)localObject3).put("wifi_interface", zz.d());
      ((JSONObject)localObject3).put("wifi_encrypted", zz.d(RqdApplication.p()));
      ((JSONObject)localObject3).put("mcc", zz.i(RqdApplication.p()));
      ((JSONObject)localObject3).put("mnc", zz.j(RqdApplication.p()));
      ((JSONObject)localObject3).put("wifi_ssid", zz.f(RqdApplication.p()));
      ((JSONObject)localObject3).put("wifi_list_near_by", zz.e(RqdApplication.p()));
      ((JSONObject)localObject3).put("wifi_strength", zz.h(RqdApplication.p()));
      RqdApplication.p();
      ((JSONObject)localObject3).put("ip_address", zz.c());
      ((JSONObject)localObject3).put("is_wifi_active", zz.c(RqdApplication.p()));
      ((JSONObject)localObject2).put("device_info_network", localObject3);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("all_app_name", zt.a(RqdApplication.p()));
      ((JSONObject)localObject3).put("android_id", zw.e(RqdApplication.p()));
      ((JSONObject)localObject3).put("kernel_version", zw.d());
      ((JSONObject)localObject3).put("language", zw.j());
      ((JSONObject)localObject3).put("system_boot_time", zw.e());
      ((JSONObject)localObject3).put("system_boot_time_length", zw.f());
      ((JSONObject)localObject3).put("time_zone", zw.k());
      ((JSONObject)localObject3).put("build_display_id", zw.w());
      ((JSONObject)localObject3).put("build_tags", zw.x());
      ((JSONObject)localObject3).put("build_version_incremental", zw.m());
      ((JSONObject)localObject3).put("build_version_release", zw.n());
      ((JSONObject)localObject3).put("build_version_sdk", zw.o());
      ((JSONObject)localObject3).put("kernel_qume", zw.h());
      ((JSONObject)localObject3).put("os_name", zw.l());
      ((JSONObject)localObject3).put("product_board", zw.p());
      ((JSONObject)localObject3).put("product_brand", zw.q());
      ((JSONObject)localObject3).put("product_device", zw.r());
      ((JSONObject)localObject3).put("product_manufacture", zw.s());
      ((JSONObject)localObject3).put("product_model", zw.t());
      ((JSONObject)localObject3).put("product_name", zw.u());
      ((JSONObject)localObject3).put("usb_stat", zw.f(RqdApplication.p()));
      ((JSONObject)localObject3).put("is_emulator", zw.i());
      ((JSONObject)localObject3).put("is_rooted", zw.g());
      ((JSONObject)localObject3).put("app_boot_time", zw.a());
      ((JSONObject)localObject2).put("device_info_env", localObject3);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("cell_id", zx.b);
      ((JSONObject)localObject3).put("cell_rssi", 0);
      ((JSONObject)localObject3).put("lac", zx.b);
      ((JSONObject)localObject3).put("latitude", zx.b);
      ((JSONObject)localObject3).put("longitude", zx.b);
      ((JSONObject)localObject3).put("gps_open", 0);
      ((JSONObject)localObject2).put("device_info_location", localObject3);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject3 = new AtomicReference(null);
      rf.a().a(localth.k.b().mUin, (JSONObject)localObject2, new rf.a()
      {
        public final void a(ri paramAnonymousri)
        {
          this.a.set(paramAnonymousri);
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
      Object localObject1 = (ri)((AtomicReference)localObject3).get();
      if (localObject1 == null)
      {
        localxh.a(-357, null, null);
        return localxh;
      }
      int i = ((ri)localObject1).b;
      xj.c("errCode:".concat(String.valueOf(i)));
      xj.c("====上报信息结束====");
      if (i != 0)
      {
        localObject1 = ((ri)localObject1).d;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("--");
        ((StringBuilder)localObject2).append((String)localObject1);
        xj.c(((StringBuilder)localObject2).toString());
        localxh.a(i, (String)localObject1, (String)localObject1);
        return localxh;
      }
      localObject1 = ((ri)localObject1).c;
      if (localObject1 != null)
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this);
        ((StringBuilder)localObject2).append("json=");
        ((StringBuilder)localObject2).append(localObject1);
        xj.a(((StringBuilder)localObject2).toString());
        i = ((JSONObject)localObject1).optInt("seq_id");
        if (i != this.b)
        {
          localxh.a(10030, null, null);
          localObject1 = new StringBuilder("parseJSON error seq is wrong seq=");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(",right = ");
          ((StringBuilder)localObject1).append(this.b);
          xj.c(((StringBuilder)localObject1).toString());
          return localxh;
        }
        if (1 == ((JSONObject)localObject1).optInt("user_action_report"))
        {
          aad.a();
          aad.g = true;
          xj.c("isNeedUpload:true");
        }
        else
        {
          aad.a();
          aad.g = false;
          xj.c("isNeedUpload:false");
        }
        localxh.a = 0;
        return localxh;
      }
      xj.c("parseJSON error decodeData");
      localxh.a(10022, RqdApplication.p().getString(2131493068), null);
      return localxh;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder("unknown err: ");
      ((StringBuilder)localObject2).append(localException.toString());
      xj.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localException.toString());
      localxh.a(10021, ((StringBuilder)localObject2).toString(), null);
      return localxh;
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = new StringBuilder("parse json failed: ");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      xj.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      localxh.a(10020, ((StringBuilder)localObject2).toString(), null);
    }
    return localxh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zv
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qqtoken.c;
import com.tencent.qqtoken.c.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class rt
{
  static boolean c;
  static UnsatisfiedLinkError d;
  static String e = null;
  private static rt f = new rt();
  protected Context a;
  protected b b;
  private rr g;
  private HashMap<Long, ru> h = new HashMap();
  private c i = new c();
  
  static
  {
    c = false;
    try
    {
      System.loadLibrary("qqtoken-lib");
      c = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      d = localUnsatisfiedLinkError;
    }
  }
  
  public static rt a()
  {
    return f;
  }
  
  public static void a(String paramString)
  {
    e = paramString;
  }
  
  private static rv b(String paramString)
  {
    rv localrv = new rv();
    localrv.b = -756;
    localrv.a = 1L;
    localrv.d = paramString;
    StringBuilder localStringBuilder = new StringBuilder("{\"info\":\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"}");
    localrv.c = localStringBuilder.toString();
    return localrv;
  }
  
  private boolean d(a parama)
  {
    if (this.g == null)
    {
      if (parama != null) {
        parama.a(b("尚未初始化"));
      }
      return false;
    }
    if (this.b == null)
    {
      if (parama != null) {
        parama.a(b("尚未初始化"));
      }
      return false;
    }
    if (!c)
    {
      if (parama != null) {
        parama.a(b("完整性校验失败，请重新安装"));
      }
      return false;
    }
    return true;
  }
  
  protected static long i()
  {
    if (!c) {
      return 9999L;
    }
    return c.j();
  }
  
  @SuppressLint({"MissingPermission"})
  private String j()
  {
    Object localObject = this.a;
    if (localObject != null) {
      try
      {
        localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
        if (localObject != null)
        {
          if (((NetworkInfo)localObject).getType() == 0)
          {
            if (((NetworkInfo)localObject).getExtraInfo() == null) {
              return "";
            }
            return ((NetworkInfo)localObject).getExtraInfo().toLowerCase(Locale.getDefault());
          }
          localObject = ((NetworkInfo)localObject).getTypeName().toLowerCase(Locale.getDefault());
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return "";
  }
  
  private static String k()
  {
    if (e == null) {
      e = Build.MODEL;
    }
    return e;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString, long paramLong2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "C94334F95F64C37ACC078B48C571FD9D";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("uin", paramLong1);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("msg_type", paramInt3);
      parama.put("req_msg_num", 40);
      parama.put("start_time", paramLong2);
      parama.put("end_time", h() + 300L);
      parama.put("source", paramInt1);
      parama.put("filter_type", paramInt2);
      if ((paramInt2 == 0) && (paramInt3 == 1))
      {
        parama.put("guid", this.g.d);
        parama.put("appid", this.g.b);
        parama.put("subappid", this.g.c);
        parama.put("appname", this.g.a);
        parama.put("A2", paramString);
      }
    }
    catch (JSONException paramString)
    {
      label237:
      break label237;
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "9F3F9056CEBD71D7CD0641324295FBDC";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("mobile_brand", Build.BRAND);
      parama.put("mobile_model", k());
      parama.put("mobile_sys_version", Build.VERSION.RELEASE);
      parama.put("screen_width", paramInt1);
      parama.put("screen_height", paramInt2);
      parama.put("screen_dpi", paramInt3);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(int paramInt, long paramLong, String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "3B1B93134164CA0F0B8B906DD2B86C36";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("id", paramInt);
      parama.put("guid", this.g.d);
      parama.put("appid", this.g.b);
      parama.put("subappid", this.g.c);
      parama.put("appname", this.g.a);
      parama.put("uin", paramLong);
      parama.put("A2", paramString);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(int paramInt, String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "19E23E326C4D01DAD0F19ED6C4D9E9B7";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("clear_kick", paramInt);
      if (paramString != null) {
        parama.put("channel_id", paramString);
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong)
  {
    if (!c) {
      return;
    }
    this.i.d2(paramLong);
  }
  
  public final void a(long paramLong, byte paramByte, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "AC01BFB92BE5169CF571381B8FFF207F";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("source", paramByte);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "50A401953EDCEE1B1C690DE0720828F2";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      JSONObject localJSONObject4 = new JSONObject();
      localJSONObject2.put("type_a", paramInt4);
      localJSONObject2.put("type_b", paramInt5);
      localJSONObject2.put("type_c", paramInt6);
      localJSONObject3.put("ip", paramInt7);
      localJSONObject3.put("country_id", paramInt8);
      localJSONObject3.put("prov_id", paramInt9);
      localJSONObject3.put("city_id", paramInt10);
      localJSONObject4.put("ip", paramInt7);
      localJSONObject4.put("country_id", 1);
      localJSONObject4.put("prov_id", paramInt1);
      localJSONObject4.put("city_id", paramInt2);
      localJSONObject1.put("msg_time", paramLong2);
      localJSONObject1.put("msg_type", localJSONObject2);
      localJSONObject1.put("old_loc", localJSONObject3);
      localJSONObject1.put("new_loc", localJSONObject4);
      if ((paramInt3 == 1) || (paramInt3 == 2)) {
        localJSONObject1.put("feed_priv_ip_type", paramInt3);
      }
      parama.put("seq_id", localru.b);
      parama.put("uin", paramLong1);
      parama.put("data", localJSONObject1.toString());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "44A002F2915AE7AE4EC64CC88158923F";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("real_uin", paramLong);
      parama.put("scene_id", paramInt1);
      parama.put("mobile_brand", URLEncoder.encode(Build.BRAND));
      parama.put("mobile_model", URLEncoder.encode(k()));
      parama.put("mobile_sdk_int", Integer.parseInt(Build.VERSION.SDK));
      parama.put("mobile_sdk_str", URLEncoder.encode(Build.VERSION.RELEASE));
      parama.put("screen_width", paramInt2);
      parama.put("screen_height", paramInt3);
      parama.put("screen_dpi", paramInt4);
      parama.put("cpu_count", paramInt5);
      parama.put("cpu_freq", paramInt6);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "DFA91EB80E402F06FD4CD719C2A1D83D";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("real_uin", paramLong);
      parama.put("mobile_model", URLEncoder.encode(k()));
      parama.put("screen_witdh", paramInt1);
      parama.put("screen_height", paramInt2);
      parama.put("screen_dpi", paramInt3);
      parama.put("cpu_count", paramInt4);
      parama.put("cpu_freq", paramInt5);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "333CDBD2430E70272952CAB6D6702E32";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("real_uin", paramLong);
      parama.put("verify_type_id", paramInt1);
      parama.put("scene_id", paramInt2);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "0FB8C96B560F379CBB37C2C1C083450D";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("verify_type", paramInt1);
      parama.put("action_type", paramInt2);
      parama.put("input_data", paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, int paramInt4, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "FADB69A40722109769E92646ED10F542";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong1);
      parama.put("appid", paramInt1);
      parama.put("msgid", paramLong2);
      parama.put("msg_type", paramInt2);
      parama.put("msg_status", paramInt3);
      parama.put("msg_uin", paramLong3);
      parama.put("msg_type", paramInt4);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, int paramInt, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "74DD203E3F2B081F7234CB597FEBD35B";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("real_uin", paramLong);
      parama.put("unbind_type", String.valueOf(paramInt));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, int paramInt, String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "98F7841164F6AC41F06BF8D3DAF6CA3F";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("real_uin", paramLong);
      parama.put("scene_id", paramInt);
      parama.put("mobile_code", paramString);
      parama.put("verify_type_id", 0);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, int paramInt, String paramString1, String paramString2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "B0548EA57A99E2F48E1EB7EFBEF5B8BA";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("uin", paramLong);
      parama.put("verify_type_id", String.valueOf(paramInt));
      parama.put("mobile", paramString1);
      parama.put("area_code", paramString2);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean, String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "C45762F55EE1A15EABB8B2E2D8F10217";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    if (paramInt != 0) {}
    for (;;)
    {
      try
      {
        parama.put("scene_id", paramInt);
        parama.put("A2", paramString);
        if (!paramBoolean) {
          break label172;
        }
        paramInt = 1;
        parama.put("on_off", paramInt);
        parama.put("seq_id", localru.b);
        parama.put("op_time", h());
        parama.put("uin", paramLong);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      this.i.c(localru.b, localru.c, parama.toString());
      return;
      label172:
      paramInt = 0;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17, int paramInt18, int paramInt19, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    int j = 1;
    if ((paramInt3 != 2) && (paramInt3 != 10) && (paramInt3 != 1)) {
      localru.c = "AF9B8A96E551B7650EF5BEE33B690043";
    } else {
      localru.c = "AF9B8A96E551B7650EF5BEE33B690042";
    }
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    int k = 0;
    for (;;)
    {
      try
      {
        parama.put("seq_id", localru.b);
        parama.put("op_time", h());
        if (paramInt1 != 2)
        {
          parama.put("uin", paramLong1);
        }
        else
        {
          parama.put("uin", paramLong2);
          if (paramInt2 > 0) {
            parama.put("lock_status", paramInt2);
          }
        }
        parama.put("op_type", paramInt1);
        paramLong1 = System.currentTimeMillis();
        if (paramInt1 != 3)
        {
          parama.put("img_data", paramString1);
          parama.put("resolution", paramString2);
          parama.put("so_code_time", paramInt5);
          parama.put("face_detect_time", paramInt6);
          parama.put("face_detect_frame", paramInt7);
          paramInt1 = k;
          if (paramBoolean) {
            paramInt1 = 1;
          }
          parama.put("is_neon", paramInt1);
          parama.put("face_model_init_time", paramInt8);
          parama.put("vivo_model_init_time", paramInt9);
          parama.put("vivo_reg_action1_time", paramInt10);
          parama.put("vivo_reg_action2_time", paramInt11);
          parama.put("vivo_reg_action1_frame", paramInt12);
          parama.put("vivo_reg_action2_frame", paramInt13);
          parama.put("vivo_ver_action_time", paramInt14);
          parama.put("vivo_ver_action_frame", paramInt15);
          parama.put("vivo_reg_action1_type", paramInt16);
          parama.put("vivo_reg_action2_type", paramInt17);
          parama.put("vivo_ver_action_type", paramInt18);
          paramString1 = new StringBuilder("android:");
          paramString1.append(URLEncoder.encode(Build.VERSION.RELEASE));
          parama.put("mobile_os", paramString1.toString());
          parama.put("algorithm", paramInt19);
        }
        parama.put("highlighted", paramInt4);
        if (paramInt3 != 10) {
          break label529;
        }
        paramInt1 = j;
        parama.put("scene", paramInt1);
        parama.put("encode_time", (int)(System.currentTimeMillis() - paramLong1));
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
      this.i.c(localru.b, localru.c, parama.toString(), new String[0], new String[0]);
      return;
      label529:
      paramInt1 = paramInt3;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17, int paramInt18, String paramString9, String paramString10, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    if (paramInt1 == 1) {
      localru.c = "3D705DA929E34A7C5A9F7E1CFCD16BEB";
    } else if (paramInt1 == 3) {
      localru.c = "3D705DA929E34A7C5A9F7E1CFCD16BEB";
    } else {
      localru.c = "3D705DA929E34A7C5A9F7E1CFCD16BEA";
    }
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("real_uin", paramLong2);
      parama.put("uin", paramLong1);
      parama.put("op_type", paramInt1);
      if (paramString1 != null) {
        parama.put("face_data", paramString1);
      }
      if (paramString2 != null) {
        parama.put("id_photo_front", paramString2);
      }
      if (paramString3 != null) {
        parama.put("id_photo_back", paramString3);
      }
      if (paramString4 != null) {
        parama.put("id_photo_info_front", paramString4);
      }
      if (paramString5 != null) {
        parama.put("id_photo_info_back", paramString5);
      }
      parama.put("guid", this.g.d);
      System.currentTimeMillis();
      parama.put("vendor_id", Build.MANUFACTURER);
      parama.put("android_id", paramString6);
      parama.put("imei", paramString7);
      parama.put("mac", paramString8);
      parama.put("device_model", k());
      parama.put("sys_ver", Build.VERSION.RELEASE);
      parama.put("face_detect_time", paramInt2);
      parama.put("face_detect_frame", paramInt3);
      parama.put("face_model_init_time", paramInt4);
      parama.put("vivo_model_init_time", paramInt5);
      parama.put("vivo_reg_action1_time", paramInt6);
      parama.put("vivo_reg_action2_time", paramInt7);
      parama.put("vivo_reg_action1_frame", paramInt8);
      parama.put("vivo_reg_action2_frame", paramInt9);
      parama.put("vivo_ver_action_time", paramInt10);
      parama.put("vivo_ver_action_frame", paramInt11);
      parama.put("vivo_reg_action1_type", paramInt12);
      parama.put("vivo_reg_action2_type", paramInt13);
      parama.put("vivo_ver_action_type", paramInt14);
      parama.put("id_photo_front_time", paramInt15);
      parama.put("id_photo_front_frame", paramInt16);
      parama.put("id_photo_back_time", paramInt17);
      parama.put("id_photo_back_frame", paramInt18);
      if (!TextUtils.isEmpty(paramString9)) {
        parama.put("route_name", paramString9);
      }
      if (!TextUtils.isEmpty(paramString10)) {
        parama.put("route_mac", paramString10);
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString(), new String[0], new String[0]);
  }
  
  public final void a(long paramLong1, long paramLong2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "F175FC5637F6D8B8DF233674868A9AC0";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong1);
      parama.put("msgid", String.valueOf(paramLong2));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "5BD55AA7E5809627669C61369F0DD361";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("uin", paramLong);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, String paramString, int paramInt, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    if (1 == paramInt) {
      localru.c = "479A4FB69763836611D26943B834C329";
    } else {
      localru.c = "479A4FB69763836611D26943B834C32A";
    }
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("uin", paramLong);
      parama.put("seq_id", localru.b);
      parama.put("op_time", this.i.b());
      parama.put("guid", this.g.d);
      parama.put("scene", paramInt);
      parama.put("wtlogin_sig", paramString);
      paramString = new StringBuilder();
      paramString.append(this.g.f);
      parama.put("wtlogin_type", paramString.toString());
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "C16E10370E478F79269FFEB9425FE21A";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("uin", String.valueOf(paramLong));
      parama.put("wtlogin_sig", paramString);
      parama.put("wtlogin_type", this.g.f);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "08CF9F6B8DF42EEE097B808193CE344B";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("uin", paramLong);
      parama.put("op_type", paramInt);
      parama.put("new_mobile", paramString1);
      parama.put("area_code", paramString2);
      parama.put("guid", this.g.d);
      parama.put("A2", paramString3);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "04D6E7893DDFE646767FC205385D104F";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("dguid", paramString1);
      parama.put("ddes", paramString2);
      parama.put("dappid", paramInt);
      parama.put("dappname", paramString3);
      parama.put("guid", paramString4);
      parama.put("appid", 523005419);
      parama.put("subappid", 1);
      parama.put("appname", paramString5);
      parama.put("encryptedA2", paramString6);
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, String paramString, boolean paramBoolean, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    if (paramBoolean) {
      localru.c = "53E34C4843494C4162B629849D78105A";
    } else {
      localru.c = "53E34C4843494C4162B629849D781059";
    }
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("real_uin", paramLong);
      parama.put("id_number", paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "99F26100CF92C33991A8775439A7F2C4";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int j = 0;
      while (j < paramArrayOfInt1.length)
      {
        localJSONArray.put(new JSONObject().put("id", paramArrayOfInt1[j]).put("value", paramArrayOfInt2[j]));
        j += 1;
      }
      parama.put("conf_data", localJSONArray);
      parama.put("uin", paramLong);
      parama.put("A2", paramString);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, JSONArray paramJSONArray, String paramString1, String paramString2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "771DD55790CDC5AC5B813EDB31F850E7";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    String[] arrayOfString = new String[2];
    JSONArray localJSONArray = new JSONArray();
    try
    {
      arrayOfProcess = new Process[2];
      arrayOfProcess[0] = Runtime.getRuntime().exec("getprop net.dns1");
      arrayOfProcess[1] = Runtime.getRuntime().exec("getprop net.dns2");
      j = 0;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Process[] arrayOfProcess;
        int j;
        BufferedReader localBufferedReader;
        continue;
        j += 1;
      }
    }
    if (j < 2)
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(arrayOfProcess[j].getInputStream()));
      arrayOfString[j] = "";
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(arrayOfString[j]);
        localStringBuilder.append(str);
        arrayOfString[j] = localStringBuilder.toString();
      }
    }
    arrayOfProcess[0].destroy();
    arrayOfProcess[1].destroy();
    j = 0;
    while (j < paramJSONArray.length())
    {
      localJSONArray.put(InetAddress.getByName(paramJSONArray.getString(j)).getHostAddress());
      j += 1;
    }
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("dns_ip1", arrayOfString[0]);
      parama.put("dns_ip2", arrayOfString[1]);
      parama.put("domain_list", paramJSONArray);
      parama.put("ret_ip_list", localJSONArray);
      parama.put("MNC", paramString1);
      parama.put("MCC", paramString2);
      parama.put("net_type", j());
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(long paramLong, JSONObject paramJSONObject, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "28D1740924201BB5211FC63EE5A14BAA";
    this.h.put(Long.valueOf(localru.b), localru);
    try
    {
      paramJSONObject.put("seq_id", localru.b);
      paramJSONObject.put("op_time", h());
      paramJSONObject.put("uin", paramLong);
    }
    catch (JSONException parama)
    {
      parama.printStackTrace();
    }
    this.i.c(localru.b, localru.c, paramJSONObject.toString(), new String[0], new String[0]);
  }
  
  public final void a(long paramLong, int[] paramArrayOfInt, String[] paramArrayOfString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "A9E50633700022EF114BD0EDB19E3A00";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("uin", paramLong);
      parama.put("op_time", h());
      parama.put("ques_id_0", paramArrayOfInt[0]);
      parama.put("answer_0", paramArrayOfString[0]);
      parama.put("ques_id_1", paramArrayOfInt[1]);
      parama.put("answer_1", paramArrayOfString[1]);
      parama.put("ques_id_2", paramArrayOfInt[2]);
      parama.put("answer_2", paramArrayOfString[2]);
    }
    catch (JSONException paramArrayOfInt)
    {
      paramArrayOfInt.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, b paramb)
  {
    this.a = paramContext.getApplicationContext();
    this.g = new rr(paramString1, paramString2, paramString3);
    this.i.r = new c();
    this.b = paramb;
    if (d != null)
    {
      paramString1 = this.b;
      if (paramString1 != null)
      {
        paramString2 = new StringBuilder("load so err:");
        paramString2.append(d.getMessage());
        paramString1.a(paramString2.toString());
      }
    }
    long l1 = -1L;
    long l2 = l1;
    try
    {
      paramString1 = this.a.getSharedPreferences("qqtoken", 0);
      l2 = l1;
      if (paramString1.contains("sic"))
      {
        l2 = l1;
        l1 = paramString1.getLong("sic", -1L);
      }
      else
      {
        l2 = l1;
        paramString1.edit().putLong("sic", System.currentTimeMillis()).commit();
      }
      l2 = l1;
      if (paramString1.contains("init_code"))
      {
        l2 = l1;
        paramString1.edit().clear().commit();
      }
    }
    catch (Throwable paramString1)
    {
      label216:
      break label216;
    }
    l1 = l2;
    if (c) {
      this.i.n(paramContext, paramString3, 523005419L, 1, l1);
    }
  }
  
  public final void a(a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "34B175E318A75EB93A82CCAF64A31A9E";
    this.h.put(Long.valueOf(localru.b), localru);
    this.i.c(localru.b, localru.c, "");
  }
  
  public final void a(File paramFile, String paramString, long paramLong1, long paramLong2, int paramInt, a parama)
  {
    if (!d(parama)) {
      return;
    }
    Object localObject1 = new ru();
    ((ru)localObject1).a = parama;
    ((ru)localObject1).c = "72DB5B82D88142908BC8FC1AFADFF186";
    this.h.put(Long.valueOf(((ru)localObject1).b), localObject1);
    parama = new JSONObject();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramLong1);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(paramString);
    paramString = ((StringBuilder)localObject2).toString();
    localObject2 = this.i;
    paramLong1 = ((ru)localObject1).b;
    localObject1 = ((ru)localObject1).c;
    parama = parama.toString();
    paramFile = paramFile.getAbsolutePath();
    ((c)localObject2).c(paramLong1, (String)localObject1, parama, new String[] { "uin", "log_date" }, new String[] { String.valueOf(paramLong2), String.valueOf(paramInt) }, paramFile, paramString, "log_file");
  }
  
  public final void a(String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "FA806047F65F95CB10B75D210411C17C";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("comment", paramString);
      parama.put("net_type", j());
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", 0L);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "F8A3779851B6648E065023F54D5A8EE7";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("mobile", paramString1);
      parama.put("uin", paramLong);
      parama.put("is_mb_mobile", paramInt1);
      parama.put("scene", paramInt2);
      parama.put("area_code", paramString2);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    new StringBuilder("getSmsChanlel json=").append(parama.toString());
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void a(byte[] paramArrayOfByte, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "E0B905EEA37A12C6CF5378B6A70C02DD";
    this.h.put(Long.valueOf(localru.b), localru);
    this.i.c(localru.b, localru.c, paramArrayOfByte);
  }
  
  public final String b()
  {
    if (!c) {
      return "66666666666666";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.i.c2());
    return localStringBuilder.toString();
  }
  
  public final void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "E596F0205A5BDB6C7397249FDC22CAEA";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("real_uin", paramLong);
      parama.put("scene_id", 1);
      parama.put("mobile_brand", URLEncoder.encode(Build.BRAND));
      parama.put("mobile_model", URLEncoder.encode(k()));
      parama.put("mobile_sdk_int", Integer.parseInt(Build.VERSION.SDK));
      parama.put("mobile_sdk_str", URLEncoder.encode(Build.VERSION.RELEASE));
      parama.put("screen_width", paramInt1);
      parama.put("screen_height", paramInt2);
      parama.put("screen_dpi", paramInt3);
      parama.put("cpu_count", paramInt4);
      parama.put("cpu_freq", paramInt5);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void b(long paramLong, int paramInt1, int paramInt2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "273B4F4457207103E27981A41529C0DB";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("action_type", paramInt1);
      parama.put("nosafe", paramInt2);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void b(long paramLong, int paramInt, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "CD4C69A4177412144231058A42BDB905";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("item_id", paramInt);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void b(long paramLong, int paramInt, String paramString1, String paramString2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "FA46402A1B15548C7CDE81C6E7F1F732";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("uin", paramLong);
      parama.put("new_mobile", paramString1);
      parama.put("op_type", paramInt);
      parama.put("area_code", paramString2);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void b(long paramLong1, long paramLong2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "E71A126EA00EB610340E9F8D0B2BECC6";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("uin", paramLong1);
      parama.put("pt_appid", paramLong2);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void b(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "41A162EE938691A32828F0DEA38E9DD3";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("uin", paramLong);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void b(long paramLong, String paramString, int paramInt, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "1D707B1CCFEC2F2CC4B940E5130F5E74";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("qqtoken_code", paramString);
      parama.put("verify_type_id", paramInt);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void b(long paramLong, String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "99814609F13A6C96EEAF766292B21C0B";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("A2", paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void b(a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "EB743F61BAC709EF2E9EA84DF8E4F095";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void b(String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "AC237F5468E06656F7ADAE11108F4D54";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("url", paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void c(long paramLong, int paramInt1, int paramInt2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    if (paramInt2 == 0) {
      localru.c = "0D623F92C0B0C3F9BF08F2A167C34176";
    } else {
      localru.c = "448C7C440DE2C2997A91EA1AD6BAC7B6";
    }
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("real_uin", paramLong);
      parama.put("scene_id", paramInt1);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void c(long paramLong, int paramInt, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "2B3FAD8767D1610B7F710A24334EB23C";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("real_uin", paramLong);
      parama.put("scene_id", paramInt);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void c(long paramLong, int paramInt, String paramString1, String paramString2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "59684C276159686ED63345F6B6AA034A";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("uin", paramLong);
      parama.put("mobile", paramString1);
      parama.put("area_code", paramString2);
      parama.put("bind_type", String.valueOf(paramInt));
      parama.put("op_time", h());
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void c(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "918ABE6DD0DEE0CA3B98282AE9639EE2";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("uin", paramLong);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void c(long paramLong, String paramString, int paramInt, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "AB09BD83BABC6EBF82C9CA1BF6DDA37F";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    if (paramInt != 0) {}
    try
    {
      parama.put("scene_id", paramInt);
      parama.put("uin", paramLong);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("pwd", paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void c(long paramLong, String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "41F7D5CECF0997AD21ED395396B9AB38";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("spp_key", paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void c(a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "7CC75354408C4834323634866588017C";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void c(String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "86DA4530C533BC0C758C1292AF8C3173";
    this.h.put(Long.valueOf(localru.b), localru);
    this.i.c(localru.b, localru.c, paramString, new String[0], new String[0]);
  }
  
  public final boolean c()
  {
    try
    {
      boolean bool = d(null);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label8:
      break label8;
    }
    return false;
  }
  
  public final void d(long paramLong, int paramInt, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "668101455655578A4F39B91F23918B7A";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("real_uin", paramLong);
      parama.put("imei", this.g.e);
      parama.put("verify_type", paramInt);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void d(long paramLong, int paramInt, String paramString1, String paramString2, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "0324CAC2D43F0443CFCFA583026BEFF2";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("scenario_id", paramInt);
      parama.put("ticket", paramString1);
      parama.put("randstr", paramString2);
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void d(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "5F1BFABD896BAFA440C4AA17E7DFBCE7";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("uin", paramLong);
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void d(long paramLong, String paramString, int paramInt, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "83C85119A617707571F9AF47FD856827";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("mobile", paramString);
      parama.put("verify_type_id", paramInt);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void d(long paramLong, String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "2840C98F0786E3E70302A9226EC5A712";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("mobile_code", paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void d(String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "D941BCD7924B6B6311F5CF92765B2D93";
    this.h.put(Long.valueOf(localru.b), localru);
    this.i.c(localru.b, localru.c, paramString, new String[0], new String[0]);
  }
  
  public final boolean d()
  {
    if ((this.g != null) && (this.b != null) && (c)) {
      return this.i.c3();
    }
    return false;
  }
  
  public final String e()
  {
    if (!c) {
      return "666666";
    }
    return this.i.a();
  }
  
  public final void e(long paramLong, int paramInt, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "E7DECE972D03B599CE2408A62F157A83";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("scenario_id", paramInt);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void e(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "26FF6825B86C68E1FABA9D9278AE1DB8";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void e(long paramLong, String paramString, int paramInt, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "D842F36E7AF0618988642B19803C0087";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("mobile_code", paramString);
      parama.put("verify_type_id", paramInt);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void e(long paramLong, String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "9E84194DFFBCBB23DA2E6300B2603753";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("url_data", paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void e(String paramString, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "EF59AE164087EC5F15461FFCF40D7EF7";
    this.h.put(Long.valueOf(localru.b), localru);
    this.i.c(localru.b, localru.c, paramString, new String[0], new String[0]);
  }
  
  public final void f(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "6E9B98C6054981CA934F7D2B6788D40D";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void f(long paramLong, String paramString, int paramInt, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "7657CC5E58154D915FCA63ABAE0B6733";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("sign_qq", paramInt);
      parama.put("a2_sign", paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final int[] f()
  {
    String str = e();
    int[] arrayOfInt = new int[6];
    int j = 0;
    while (j < 6)
    {
      arrayOfInt[j] = (str.charAt(j) - '0');
      j += 1;
    }
    return arrayOfInt;
  }
  
  public final long g()
  {
    if (!c) {
      return 0L;
    }
    return this.i.d2();
  }
  
  public final void g(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "F003698209A3250BE06FAD011DD79BB8";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final long h()
  {
    if (!c) {
      return 1234567890L;
    }
    return this.i.b();
  }
  
  public final void h(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "370D289E3FE3E8ED668DA209815CDEFF";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void i(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "9CE121E6F54413367610232409BB47BD";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("uin", paramLong);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void j(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "E77CB26DE18145EDAA56393DB1A5E471";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("uin", paramLong);
      parama.put("op_time", h());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void k(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "BE915045169753B18F19EF34EBEFFA1A";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void l(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "9E808C16098A0A14D88D169B2F9D1F21";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
      parama.put("guid", this.g.d);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void m(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "7ADA7075D675A2D03A82FA01528E2620";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public final void n(long paramLong, a parama)
  {
    if (!d(parama)) {
      return;
    }
    ru localru = new ru();
    localru.a = parama;
    localru.c = "DB3278FC63B5F2CAC5FADDCC62E4B87F";
    this.h.put(Long.valueOf(localru.b), localru);
    parama = new JSONObject();
    try
    {
      parama.put("seq_id", localru.b);
      parama.put("op_time", h());
      parama.put("uin", paramLong);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.i.c(localru.b, localru.c, parama.toString());
  }
  
  public static abstract interface a
  {
    public abstract void a(rv paramrv);
  }
  
  public static abstract interface b
  {
    public abstract String a();
    
    public abstract void a(long paramLong, String paramString1, String paramString2);
    
    public abstract void a(String paramString);
    
    public abstract boolean a(long paramLong);
    
    public abstract rs b();
  }
  
  final class c
    implements c.a
  {
    c() {}
    
    public final String a()
    {
      if (rt.this.b != null) {
        return rt.this.b.a();
      }
      return null;
    }
    
    public final void a(long paramLong, int paramInt, String paramString1, String paramString2)
    {
      rt.a(rt.this, paramLong, paramInt, paramString1, paramString2);
    }
    
    public final void a(long paramLong, String paramString1, String paramString2)
    {
      if (rt.this.b != null) {
        rt.this.b.a(paramLong, paramString1, paramString2);
      }
    }
    
    public final void a(String paramString)
    {
      if (rt.this.b != null) {
        rt.this.b.a(paramString);
      }
    }
    
    public final void a(String paramString1, String paramString2)
    {
      try
      {
        rt.this.a.getSharedPreferences("qqtoken", 0).edit().putString(paramString1, paramString2).commit();
        return;
      }
      catch (Throwable paramString1) {}
    }
    
    public final boolean a(long paramLong)
    {
      return (rt.this.b != null) && (rt.this.b.a(paramLong));
    }
    
    public final long b()
    {
      if (rt.this.b != null) {
        return rt.this.b.b().a;
      }
      return 0L;
    }
    
    public final String b(String paramString1, String paramString2)
    {
      try
      {
        paramString1 = rt.this.a.getSharedPreferences("qqtoken", 0).getString(paramString1, paramString2);
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        label23:
        break label23;
      }
      return null;
    }
    
    public final long c()
    {
      if (rt.this.b != null) {
        return rt.this.b.b().b;
      }
      return 0L;
    }
    
    public final String d()
    {
      if (rt.this.b != null)
      {
        rs localrs = rt.this.b.b();
        if (!TextUtils.isEmpty(localrs.c)) {
          return localrs.c;
        }
        return "";
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rt
 * JD-Core Version:    0.7.0.1
 */
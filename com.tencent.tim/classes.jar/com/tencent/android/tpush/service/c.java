package com.tencent.android.tpush.service;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.AppInfos;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.common.h;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.protocol.f;
import com.tencent.android.tpush.service.protocol.l;
import com.tencent.android.tpush.service.protocol.m;
import com.tencent.android.tpush.service.protocol.o;
import com.tencent.android.tpush.service.protocol.p;
import com.tencent.android.tpush.service.protocol.q;
import com.tencent.android.tpush.service.protocol.r;
import com.tencent.android.tpush.service.protocol.s;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private static c a = new c();
  private static JSONArray b = new JSONArray();
  private static final String c = Md5.md5("com.tencent.tpush.last_wifi_ts");
  private static int d = -1;
  private static int e = -1;
  private static f f;
  private static boolean g = false;
  
  public static byte a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1;
    }
    return 0;
  }
  
  public static c a()
  {
    return a;
  }
  
  public static f a(Context paramContext)
  {
    if (f == null) {
      f = new f();
    }
    if (TextUtils.isEmpty(f.c))
    {
      f.i = ("" + AppInfos.getApiLevel());
      f.a = CustomDeviceInfos.getFacilityIdentity(paramContext);
      if (!DeviceInfos.checkSimulator(paramContext)) {
        break label291;
      }
      f.h = "SIMULATOR";
    }
    for (f.b = DeviceInfos.getSimulatorModel(paramContext);; f.b = TGlobalHelper.getDM(paramContext))
    {
      f.c = "android";
      DisplayMetrics localDisplayMetrics = DeviceInfos.getDisplayMetrics(paramContext);
      f.g = (localDisplayMetrics.widthPixels + "*" + localDisplayMetrics.heightPixels);
      f.i = ("" + Build.VERSION.SDK_INT);
      f.e = DeviceInfos.getExternalStorageInfo(paramContext);
      f.f = CustomDeviceInfos.getSimOperator(paramContext);
      f.j = Build.VERSION.RELEASE;
      f.k = DeviceInfos.hasRootAccess(paramContext);
      f.n = Locale.getDefault().getLanguage();
      f.p = AppInfos.getLauncherPackageName(paramContext);
      f.u = c(paramContext);
      f.r = com.tencent.android.tpush.common.g.a();
      f.s = com.tencent.android.tpush.common.g.c();
      f.o = TimeZone.getDefault().getID();
      f.d = DeviceInfos.getLinkedWay(paramContext);
      f.t = com.tencent.android.tpush.service.util.b.b(paramContext);
      return f;
      label291:
      f.h = Build.MANUFACTURER;
    }
  }
  
  private static com.tencent.android.tpush.service.protocol.g a(Context paramContext, String paramString)
  {
    if (!e(paramContext)) {
      return null;
    }
    com.tencent.android.tpush.service.protocol.g localg = new com.tencent.android.tpush.service.protocol.g();
    localg.a = XGApiConfig.getFreeVersionAccessId(paramContext);
    localg.b = com.tencent.android.tpush.c.b.b(paramContext);
    if ((TextUtils.isEmpty(localg.b)) || (localg.b.equals("0")))
    {
      localg.b = paramString;
      TLogger.dd("PushServiceNetworkHandler", "FreeVersionInfo -> user channel token");
    }
    localg.c = d(paramContext);
    TLogger.dd("PushServiceNetworkHandler", "FreeVersionInfo ->  AccessId:" + localg.a + ", token:" + localg.b + ", channel:" + localg.c);
    return localg;
  }
  
  private int b()
  {
    if ((e != -1) || ((ChannelUtils.isBrandHuaWei()) || (ChannelUtils.isBrandHonor()))) {}
    for (;;)
    {
      try
      {
        Class.forName("com.huawei.hms.aaid.HmsInstanceId");
        e = 4;
        return e;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          Class.forName("com.huawei.android.hms.agent.HMSAgent");
          e = 2;
        }
        catch (Throwable localThrowable2)
        {
          e = 0;
        }
        continue;
      }
      e = 0;
    }
  }
  
  static void b(Context paramContext)
  {
    if (XGApiConfig.getFreeVersionAccessId(paramContext) < 0L) {}
    while (g) {
      return;
    }
    String str1 = SharePrefsUtil.getString(paramContext, "freeinfo.last.succ.date", "");
    String str2 = com.tencent.android.tpush.common.i.a(System.currentTimeMillis());
    if ((!TextUtils.isEmpty(str1)) && (str2.equals(str1)))
    {
      g = true;
      return;
    }
    SharePrefsUtil.setString(paramContext, "freeinfo.last.succ.date", str2);
    SharePrefsUtil.setInt(paramContext, "freeinfo.succ.count", SharePrefsUtil.getInt(paramContext, "freeinfo.succ.count", 0) + 1);
    g = true;
  }
  
  private static o c(Context paramContext)
  {
    o localo = new o();
    localo.a = DeviceInfos.getBootTime();
    localo.b = Locale.getDefault().getCountry();
    localo.c = DeviceInfos.getDeviceName(paramContext);
    localo.d = DeviceInfos.getCarrierInfo(paramContext);
    localo.e = String.valueOf(DeviceInfos.getTotalMemory());
    localo.f = String.valueOf(DeviceInfos.getTotalInternalMemorySize());
    localo.g = DeviceInfos.getSysFileTime();
    return localo;
  }
  
  private static String d(Context paramContext)
  {
    String str = d.g();
    if (ChannelUtils.isBrandXiaoMi()) {
      return "xiaomi";
    }
    if (ChannelUtils.isBrandHuaWei()) {
      return "huawei";
    }
    if (ChannelUtils.isBrandMeiZu()) {
      return "meizu";
    }
    if (("oppo".equals(str)) || ("oneplus".equals(str))) {
      return "oppo";
    }
    if ("vivo".equals(str)) {
      return "vivo";
    }
    if (h.a(paramContext).c()) {
      return "fcm";
    }
    return null;
  }
  
  private static boolean e(Context paramContext)
  {
    if (XGApiConfig.getFreeVersionAccessId(paramContext) < 0L) {
      return false;
    }
    if (g)
    {
      TLogger.dd("PushServiceNetworkHandler", "isNeedGetFreeVersionInfo-> hasSucessGetFreeVersionInfo");
      return false;
    }
    int i = SharePrefsUtil.getInt(paramContext, "freeinfo.succ.count", 0);
    TLogger.dd("PushServiceNetworkHandler", "isNeedGetFreeVersionInfo-> succsssCount:" + i);
    if (i >= 7)
    {
      g = true;
      return false;
    }
    paramContext = SharePrefsUtil.getString(paramContext, "freeinfo.last.succ.date", "");
    String str = com.tencent.android.tpush.common.i.a(System.currentTimeMillis());
    TLogger.dd("PushServiceNetworkHandler", "isNeedGetFreeVersionInfo-> lastSuccessDate:" + paramContext + ", tody:" + str);
    if ((!TextUtils.isEmpty(paramContext)) && (str.equals(paramContext)))
    {
      g = true;
      return false;
    }
    return true;
  }
  
  public void a(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, com.tencent.android.tpush.service.c.a parama)
  {
    l locall = new l();
    locall.a = paramLong;
    locall.b = paramString1;
    locall.d = paramInt2;
    locall.c = paramInt1;
    locall.g = paramString3;
    locall.e = (System.currentTimeMillis() / 1000L);
    locall.f = String.valueOf("1.2.7.3");
    if (XGPushConfig.enableDebug) {
      TLogger.d("PushServiceNetworkHandler", "Action -> getTags from server (" + paramLong + "," + paramString2 + ")");
    }
    if ((!Util.checkAccessId(locall.a)) || (!Util.checkAccessKey(locall.b)))
    {
      if (parama != null) {
        parama.b(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType(), ReturnCode.errCodeToMsg(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType()), locall);
      }
      return;
    }
    com.tencent.android.tpush.service.c.b.a().a(b.e(), locall, parama);
  }
  
  public void a(long paramLong, String paramString1, String paramString2, int paramInt, com.tencent.android.tpush.service.c.a parama)
  {
    int i = 0;
    long l = System.currentTimeMillis();
    com.tencent.android.tpush.service.protocol.a locala = new com.tencent.android.tpush.service.protocol.a();
    locala.a = paramLong;
    locala.b = paramString1;
    locala.c = paramInt;
    locala.d = (l / 1000L);
    locala.e = String.valueOf("1.2.7.3");
    if (!com.tencent.android.tpush.common.i.b(paramString2)) {}
    try
    {
      paramString1 = new JSONArray(paramString2);
      ArrayList localArrayList = new ArrayList();
      paramInt = i;
      while (paramInt < paramString1.length())
      {
        JSONObject localJSONObject = paramString1.getJSONObject(paramInt);
        q localq = new q();
        localq.a(localJSONObject.getString("account"));
        localq.a(localJSONObject.optInt("accountType", 0));
        localArrayList.add(localq);
        paramInt += 1;
      }
      locala.f = localArrayList;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
      com.tencent.android.tpush.service.c.b.a().a(b.e(), locala, parama);
    }
    if (XGPushConfig.enableDebug) {
      TLogger.vv("PushServiceNetworkHandler", "setAccount(" + paramLong + "," + paramString2 + ")");
    }
    if ((!Util.checkAccessId(locala.a)) || (!Util.checkAccessKey(locala.b)))
    {
      parama.b(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType(), ReturnCode.errCodeToMsg(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType()), locala);
      return;
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, com.tencent.android.tpush.service.c.a parama)
  {
    p localp = new p();
    localp.a = paramLong;
    localp.b = paramString1;
    localp.d = paramInt;
    localp.c = paramString3;
    localp.e = (System.currentTimeMillis() / 1000L);
    localp.f = String.valueOf("1.2.7.3");
    if (XGPushConfig.enableDebug) {
      TLogger.d("PushServiceNetworkHandler", "Action -> sendTag to server (" + paramLong + "," + paramString2 + ")");
    }
    if ((!Util.checkAccessId(localp.a)) || (!Util.checkAccessKey(localp.b)))
    {
      if (parama != null) {
        parama.b(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType(), ReturnCode.errCodeToMsg(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType()), localp);
      }
      return;
    }
    com.tencent.android.tpush.service.c.b.a().a(b.e(), localp, parama);
  }
  
  public void a(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, long paramLong2, String paramString7, String paramString8, String paramString9, long paramLong3, long paramLong4, String paramString10, String paramString11, long paramLong5, com.tencent.android.tpush.service.c.a parama)
  {
    m localm = new m();
    localm.a = paramLong1;
    localm.b = paramString1;
    localm.c = paramString2;
    localm.d = paramString4;
    localm.e = paramString3;
    localm.f = ((short)paramInt);
    localm.h = a(b.e());
    localm.E = a(b.e(), paramString10);
    localm.i = 4;
    localm.r = 0L;
    localm.m = paramString5;
    localm.n = paramString6;
    localm.u = paramLong2;
    localm.v = paramString9;
    localm.t = paramLong3;
    localm.s = paramLong4;
    localm.q = (System.currentTimeMillis() / 1000L);
    localm.z = String.valueOf("1.2.7.3");
    if (!com.tencent.android.tpush.common.i.b(paramString7)) {
      paramString1 = new JSONObject();
    }
    try
    {
      paramString1.put("url", paramString7);
      if (!com.tencent.android.tpush.common.i.b(paramString8)) {
        paramString1.put("payload", paramString8);
      }
      label195:
      localm.y = paramString1.toString();
      TLogger.vv("PushServiceNetworkHandler", "Register(" + paramLong1 + "," + paramString2 + "," + paramString3 + "," + paramInt + ")" + ",payload: " + localm.y + " channel id" + localm.s);
      localm.p = CacheManager.getGuid(b.e());
      if ((paramString10 != null) && (paramString11 != null))
      {
        localm.A = paramString10;
        localm.B = paramString11;
      }
      paramString1 = b.e();
      if (paramString1 != null) {
        localm.C = paramString1.getPackageName();
      }
      if (d == -1) {}
      try
      {
        Class.forName("com.qq.e.ads.ADActivity");
        d = 1;
        localm.D = d;
        localm.F = b();
        localm.G = paramLong5;
        if ((!Util.checkAccessId(localm.a)) || (!Util.checkAccessKey(localm.b)))
        {
          if (parama != null) {
            parama.b(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType(), ReturnCode.errCodeToMsg(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType()), localm);
          }
          return;
        }
      }
      catch (Throwable paramString2)
      {
        do
        {
          for (;;)
          {
            TLogger.d("PushServiceNetworkHandler", "Register get tAd error, tAd not found");
            d = 0;
          }
          if ((localm.b(paramString1)) || (!XGApiConfig.isRegistered(paramString1))) {
            break;
          }
        } while (parama == null);
        parama.a(ReturnCode.CODE_SUCCESS.getType(), "", localm);
        return;
        com.tencent.android.tpush.service.c.b.a().a(paramString1, localm, parama);
        return;
      }
    }
    catch (JSONException paramString4)
    {
      break label195;
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, String paramString3, com.tencent.android.tpush.service.c.a parama)
  {
    paramString1 = new s(paramLong, paramString1, paramString2, paramString3, System.currentTimeMillis() / 1000L, String.valueOf("1.2.7.3"));
    com.tencent.android.tpush.service.c.b.a().a(b.e(), paramString1, parama);
  }
  
  public void a(Intent paramIntent, com.tencent.android.tpush.service.c.a parama)
  {
    com.tencent.android.tpush.service.protocol.i locali = new com.tencent.android.tpush.service.protocol.i();
    locali.a = paramIntent.getLongExtra("type", 0L);
    try
    {
      locali.b = Long.parseLong(Rijndael.decrypt(paramIntent.getStringExtra("accessId")));
      locali.c = paramIntent.getLongExtra("msgId", 0L);
      locali.d = paramIntent.getLongExtra("broadcastId", 0L);
      locali.e = paramIntent.getLongExtra("msgTimestamp", 0L);
      locali.f = paramIntent.getLongExtra("clientTimestamp", 0L);
      locali.i = paramIntent.getStringExtra("pkgName");
      String str = Rijndael.decrypt(paramIntent.getStringExtra("msg"));
      if (str != null) {
        locali.g = str;
      }
      paramIntent = Rijndael.decrypt(paramIntent.getStringExtra("ext"));
      if (paramIntent != null) {
        locali.h = paramIntent;
      }
      if (!Util.checkAccessId(locali.b))
      {
        if (parama != null) {
          parama.b(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType(), ReturnCode.errCodeToMsg(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType()), locali);
        }
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        TLogger.e("PushServiceNetworkHandler", "sendCommReportMessage NumberFormatException");
      }
      com.tencent.android.tpush.service.c.b.a().b(b.e(), locali, parama);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, com.tencent.android.tpush.service.c.a parama)
  {
    r localr = new r();
    paramString1 = "";
    try
    {
      paramString2 = TpnsSecurity.getEncryptAPKSignature(b.e().createPackageContext(paramString4, 0));
      paramString1 = paramString2;
    }
    catch (Throwable paramString2)
    {
      for (;;)
      {
        TLogger.e("PushServiceNetworkHandler", ">> create context [for: " + paramString4 + "] fail.", paramString2);
      }
      com.tencent.android.tpush.service.c.b.a().a(b.e(), localr, parama);
    }
    localr.b = paramLong;
    localr.c = paramString3;
    localr.d = paramString1;
    localr.e = 0;
    localr.f = 0;
    localr.g = (System.currentTimeMillis() / 1000L);
    localr.h = String.valueOf("1.2.7.3");
    if ((!Util.checkAccessId(localr.b)) || (!Util.checkAccessKey(localr.c)))
    {
      if (parama != null) {
        parama.b(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType(), ReturnCode.errCodeToMsg(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType()), localr);
      }
      return;
    }
  }
  
  public void b(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, com.tencent.android.tpush.service.c.a parama)
  {
    com.tencent.android.tpush.service.protocol.b localb = new com.tencent.android.tpush.service.protocol.b();
    localb.a = paramLong;
    localb.b = paramString1;
    localb.d = paramInt;
    localb.c = paramString3;
    localb.e = (System.currentTimeMillis() / 1000L);
    localb.f = "1.2.7.3";
    TLogger.d("PushServiceNetworkHandler", "Action -> sendAttributes to server (" + paramLong + "," + paramString2 + ")");
    if ((!Util.checkAccessId(localb.a)) || (!Util.checkAccessKey(localb.b)))
    {
      if (parama != null) {
        parama.b(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType(), ReturnCode.errCodeToMsg(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType()), localb);
      }
      return;
    }
    com.tencent.android.tpush.service.c.b.a().a(b.e(), localb, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.c
 * JD-Core Version:    0.7.0.1
 */
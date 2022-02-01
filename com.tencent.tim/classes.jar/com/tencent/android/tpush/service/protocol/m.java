package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.Md5;
import org.json.JSONObject;

public class m
  extends d
{
  public String A = "";
  public String B = "";
  public String C = "";
  public int D = 0;
  public g E = null;
  public int F = 0;
  public long G = 0L;
  private boolean H = true;
  public long a = 0L;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public short f = 0;
  public short g = 0;
  public f h = null;
  public short i = 0;
  public byte j = 0;
  public h k = null;
  public short l = 0;
  public String m = "";
  public String n = "";
  public String o = "";
  public long p = 0L;
  public long q = 0L;
  public long r = 0L;
  public long s = 0L;
  public long t = 0L;
  public long u = 0L;
  public String v = "";
  public long w = 0L;
  public long x = 0L;
  public String y = "";
  public String z = "";
  
  public MessageType a()
  {
    return MessageType.REGISTER;
  }
  
  public JSONObject a(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("accessId", this.a);
    localJSONObject.put("accessKey", this.b);
    localJSONObject.put("deviceId", this.c);
    localJSONObject.put("appCert", this.d);
    localJSONObject.put("ticket", this.e);
    localJSONObject.put("ticketType", this.f);
    localJSONObject.put("deviceType", this.g);
    if (this.h != null) {
      localJSONObject.put("deviceInfo", this.h.a());
    }
    localJSONObject.put("version", this.i);
    localJSONObject.put("keyEncrypted", this.j);
    if (this.k != null) {
      localJSONObject.put("mutableInfo", this.k.a());
    }
    localJSONObject.put("updateAutoTag", this.l);
    localJSONObject.put("appVersion", this.m);
    localJSONObject.put("clientid", this.o);
    localJSONObject.put("connVersion", this.r);
    localJSONObject.put("channelId", this.s);
    localJSONObject.put("otherPushTokenOpType", this.t);
    localJSONObject.put("otherPushTokenType", this.u);
    localJSONObject.put("otherPushToken", this.v);
    localJSONObject.put("otherPushTokenCrc32", this.w);
    localJSONObject.put("tokenCrc32", this.x);
    localJSONObject.put("otherPushData", this.y);
    localJSONObject.put("sdkVersion", this.z);
    if ((!i.b(this.A)) && (!i.b(this.B)))
    {
      localJSONObject.put("channelToken", this.A);
      localJSONObject.put("channelType", this.B);
    }
    if (!i.b(this.C)) {
      localJSONObject.put("appPkgName", this.C);
    }
    localJSONObject.put("tAd", this.D);
    if ((this.E != null) && (this.E.a())) {
      localJSONObject.put("freeVersionInfo", this.E.b());
    }
    localJSONObject.put("hwSdk", this.F);
    localJSONObject.put("cloudVersion", this.G);
    try
    {
      String str1 = localJSONObject.toString();
      str1 = str1.substring(0, str1.indexOf("bootTime")) + str1.substring(str1.indexOf("countryCode"));
      String str2 = SharePrefsUtil.getString(paramContext, "REGISTERED_REQ", "");
      if (Md5.md5(str1).equals(str2)) {
        this.H = false;
      }
      for (;;)
      {
        localJSONObject.put("timestamp", this.q);
        return localJSONObject;
        this.H = true;
        SharePrefsUtil.setString(paramContext, "REGISTERED_REQ", Md5.md5(str1));
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        this.H = true;
      }
    }
  }
  
  public boolean b(Context paramContext)
  {
    try
    {
      a(paramContext);
      return this.H;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TLogger.d("RegisterReq", "unexpected for:" + paramContext.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.m
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.android.tpush.service.protocol;

import com.tencent.android.tpush.logging.TLogger;
import org.json.JSONObject;

public class j
{
  public long a = 0L;
  public long b = 0L;
  public long c = 0L;
  public String d = "";
  public String e = "";
  public long f = 0L;
  public String g = "";
  public long h = 0L;
  public long i = 0L;
  public String j = "";
  public long k = 0L;
  public int l = 0;
  public long m = 0L;
  public long n = 0L;
  public long o = 0L;
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public long t = 0L;
  public long u = 0L;
  public int v = 0;
  public String w = "";
  public String x = "";
  public String y = "";
  
  public void a(JSONObject paramJSONObject)
  {
    b(paramJSONObject);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("content");
    if (localJSONObject != null) {
      this.e = localJSONObject.toString();
    }
    paramJSONObject = paramJSONObject.optJSONObject("inMsg");
    if (paramJSONObject != null) {
      this.y = paramJSONObject.toString();
    }
  }
  
  void b(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("xg");
      if (localJSONObject != null)
      {
        TLogger.w("PushMessage", "parse mqtt msg contain key \"xg\"");
        paramJSONObject = localJSONObject;
      }
      for (;;)
      {
        this.a = paramJSONObject.optLong("msgId", 0L);
        this.b = paramJSONObject.optLong("accessId", 0L);
        this.c = paramJSONObject.optLong("busiMsgId", 0L);
        this.d = paramJSONObject.optString("title", "");
        this.f = paramJSONObject.optLong("type", 0L);
        if (this.f == 0L) {
          this.f = paramJSONObject.optLong("msgType", 0L);
        }
        this.g = paramJSONObject.optString("appPkgName", "");
        this.h = (paramJSONObject.optLong("timestamp", 0L) * 1000L);
        this.i = paramJSONObject.optLong("multiPkg", 0L);
        this.j = paramJSONObject.optString("date", "");
        this.k = (paramJSONObject.optLong("serverTime", 0L) * 1000000L);
        this.l = paramJSONObject.optInt("ttl", 0);
        this.m = paramJSONObject.optLong("channelId", 0L);
        this.n = paramJSONObject.optLong("adPush", 0L);
        this.o = paramJSONObject.optLong("reseverId", 0L);
        this.p = paramJSONObject.optString("statTag", "");
        this.r = paramJSONObject.optString("groupId", "");
        this.t = paramJSONObject.optLong("targetType", 0L);
        this.u = paramJSONObject.optLong("source", 0L);
        this.v = paramJSONObject.optInt("revokeId", 0);
        this.w = paramJSONObject.optString("templateId", "");
        this.x = paramJSONObject.optString("traceId", "");
        return;
        TLogger.w("PushMessage", "parse mqtt msg not contain key \"xg\"");
      }
      return;
    }
    catch (Throwable paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.j
 * JD-Core Version:    0.7.0.1
 */
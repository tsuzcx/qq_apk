package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import org.json.JSONObject;

public class i
  extends d
{
  public long a = 0L;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  public long e = 0L;
  public long f = 0L;
  public String g = "";
  public String h = "";
  public String i = "";
  
  public MessageType a()
  {
    return MessageType.COMMON_REPORT;
  }
  
  public JSONObject a(Context paramContext)
  {
    paramContext = new JSONObject();
    paramContext.put("type", this.a);
    paramContext.put("accessId", this.b);
    paramContext.put("msgId", this.c);
    paramContext.put("broadcastId", this.d);
    paramContext.put("msgTimestamp", this.e);
    paramContext.put("clientTimestamp", this.f);
    paramContext.put("msg", this.g);
    paramContext.put("ext", this.h);
    paramContext.put("pkgName", this.i);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.i
 * JD-Core Version:    0.7.0.1
 */
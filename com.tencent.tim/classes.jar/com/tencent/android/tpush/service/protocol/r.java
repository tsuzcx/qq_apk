package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import org.json.JSONObject;

public class r
  extends d
{
  public short a = 0;
  public long b = 0L;
  public String c = "";
  public String d = "";
  public byte e = 0;
  public byte f = 0;
  public long g = 0L;
  public String h = "";
  
  public MessageType a()
  {
    return MessageType.UNREGISTER;
  }
  
  public JSONObject a(Context paramContext)
  {
    paramContext = new JSONObject();
    paramContext.put("deviceType", this.a);
    paramContext.put("accessId", this.b);
    paramContext.put("accessKey", this.c);
    paramContext.put("appCert", this.d);
    paramContext.put("keyEncrypted", this.e);
    paramContext.put("isUninstall", this.f);
    paramContext.put("timestamp", this.g);
    paramContext.put("sdkVersion", this.h);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.r
 * JD-Core Version:    0.7.0.1
 */
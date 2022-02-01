package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import org.json.JSONObject;

public class s
  extends d
{
  public long a = 0L;
  public String b = "";
  public String c = "";
  public String d = "";
  public long e = 0L;
  public String f = "";
  
  public s() {}
  
  public s(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, String paramString4)
  {
    this.a = paramLong1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramLong2;
    this.f = paramString4;
  }
  
  public MessageType a()
  {
    return MessageType.UPDATE_OTHER_TOKEN;
  }
  
  public JSONObject a(Context paramContext)
  {
    paramContext = new JSONObject();
    paramContext.put("accessId", this.a);
    paramContext.put("accessKey", this.b);
    paramContext.put("channelType", this.c);
    paramContext.put("channelToken", this.d);
    paramContext.put("timestamp", this.e);
    paramContext.put("sdkVersion", this.f);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.s
 * JD-Core Version:    0.7.0.1
 */
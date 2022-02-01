package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import org.json.JSONObject;

public class b
  extends d
{
  public long a = 0L;
  public String b = "";
  public String c = "";
  public int d = 0;
  public long e = 0L;
  public String f = "";
  
  public MessageType a()
  {
    return MessageType.ATTRIBUTE_INFO;
  }
  
  public JSONObject a(Context paramContext)
  {
    paramContext = new JSONObject();
    paramContext.put("accessId", this.a);
    paramContext.put("accessKey", this.b);
    paramContext.put("attributes", new JSONObject(this.c));
    paramContext.put("operateType", this.d);
    paramContext.put("timestamp", this.e);
    paramContext.put("sdkVersion", this.f);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.b
 * JD-Core Version:    0.7.0.1
 */
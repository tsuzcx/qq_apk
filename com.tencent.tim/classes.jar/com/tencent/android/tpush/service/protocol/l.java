package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

public class l
  extends d
{
  public long a = 0L;
  public String b = "";
  public int c = 0;
  public int d = 100;
  public long e = 0L;
  public String f = "";
  public String g = "";
  
  public MessageType a()
  {
    return MessageType.QUERY_TAGS;
  }
  
  public JSONObject a(Context paramContext)
  {
    paramContext = new JSONObject();
    paramContext.put("accessId", this.a);
    paramContext.put("accessKey", this.b);
    paramContext.put("offset", this.c);
    paramContext.put("limit", this.d);
    paramContext.put("timestamp", this.e);
    paramContext.put("sdkVersion", this.f);
    if (!TextUtils.isEmpty(this.g)) {
      paramContext.put("tagType", this.g);
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.l
 * JD-Core Version:    0.7.0.1
 */
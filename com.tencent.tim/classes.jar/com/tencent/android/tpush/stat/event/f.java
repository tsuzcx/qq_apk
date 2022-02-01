package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.common.i;
import org.json.JSONObject;

public class f
  extends Event
{
  public long a = 0L;
  public long b = 0L;
  double l = 0.0D;
  String m;
  String n;
  
  public f(Context paramContext, String paramString1, String paramString2, int paramInt, double paramDouble, long paramLong)
  {
    super(paramContext, paramInt, paramLong);
    this.n = paramString1;
    this.m = paramString2;
    this.l = paramDouble;
  }
  
  public EventType getType()
  {
    return EventType.PAGE_VIEW;
  }
  
  public boolean onEncode(JSONObject paramJSONObject)
  {
    i.a(paramJSONObject, "pi", this.m);
    i.a(paramJSONObject, "rf", this.n);
    if (this.l > 0.0D) {
      paramJSONObject.put("du", this.l);
    }
    if (this.a > 0L) {
      i.a(paramJSONObject, "msgId", this.a);
    }
    if (this.b > 0L) {
      i.a(paramJSONObject, "busiMsgId", this.b);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.event.f
 * JD-Core Version:    0.7.0.1
 */
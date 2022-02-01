package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.stat.b.a;
import com.tencent.android.tpush.stat.b.b;
import org.json.JSONObject;

public class h
  extends Event
{
  private a a;
  private JSONObject b = null;
  
  public h(Context paramContext, int paramInt, JSONObject paramJSONObject, long paramLong)
  {
    super(paramContext, paramInt, paramLong);
    this.a = new a(paramContext, paramLong);
    this.b = paramJSONObject;
  }
  
  public EventType getType()
  {
    return EventType.SESSION_ENV;
  }
  
  public boolean onEncode(JSONObject paramJSONObject)
  {
    paramJSONObject.put("ut", 1);
    if (this.b != null) {
      paramJSONObject.put("cfg", this.b);
    }
    if (b.e(this.k)) {
      paramJSONObject.put("ncts", 1);
    }
    this.a.a(paramJSONObject, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.event.h
 * JD-Core Version:    0.7.0.1
 */
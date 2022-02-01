package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.stat.b.d;
import org.json.JSONObject;

public class a
  extends f
{
  private static int o = 0;
  
  public a(Context paramContext, int paramInt, double paramDouble, long paramLong)
  {
    super(paramContext, null, null, paramInt, paramDouble, paramLong);
    if (o == 0)
    {
      o = d.a(paramContext, "back_ev_index", 0);
      if (o > 2147383647) {
        o = 0;
      }
    }
    o += 1;
    d.b(paramContext, "back_ev_index", o);
  }
  
  public EventType getType()
  {
    return EventType.BACKGROUND;
  }
  
  public boolean onEncode(JSONObject paramJSONObject)
  {
    paramJSONObject.put("bc", o);
    paramJSONObject.put("ft", 1);
    return super.onEncode(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.event.a
 * JD-Core Version:    0.7.0.1
 */
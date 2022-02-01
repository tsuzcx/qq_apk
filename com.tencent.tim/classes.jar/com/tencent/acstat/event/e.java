package com.tencent.acstat.event;

import android.content.Context;
import com.tencent.acstat.StatConfig;
import com.tencent.acstat.StatSpecifyReportedInfo;
import com.tencent.acstat.common.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends d
{
  public static final StatSpecifyReportedInfo a;
  
  static
  {
    StatSpecifyReportedInfo localStatSpecifyReportedInfo = new StatSpecifyReportedInfo();
    a = localStatSpecifyReportedInfo;
    localStatSpecifyReportedInfo.setAppKey("A9VH9B8L4GX4");
  }
  
  public e(Context paramContext)
  {
    super(paramContext, 0, a);
  }
  
  public EventType a()
  {
    return EventType.NETWORK_DETECTOR;
  }
  
  public boolean a(JSONObject paramJSONObject)
    throws JSONException
  {
    Util.jsonPut(paramJSONObject, "actky", StatConfig.getAppKey(this.n));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.acstat.event.e
 * JD-Core Version:    0.7.0.1
 */
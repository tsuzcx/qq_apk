package com.tencent.acstat.event;

import android.content.Context;
import com.tencent.acstat.StatAccount;
import com.tencent.acstat.StatSpecifyReportedInfo;
import com.tencent.acstat.common.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends d
{
  private StatAccount a = null;
  
  public a(Context paramContext, int paramInt, StatAccount paramStatAccount, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    super(paramContext, paramInt, paramStatSpecifyReportedInfo);
    this.a = paramStatAccount;
  }
  
  public EventType a()
  {
    return EventType.ADDITION;
  }
  
  public boolean a(JSONObject paramJSONObject)
    throws JSONException
  {
    Util.jsonPut(paramJSONObject, "qq", this.a.getAccount());
    paramJSONObject.put("acc", this.a.toJsonString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.acstat.event.a
 * JD-Core Version:    0.7.0.1
 */
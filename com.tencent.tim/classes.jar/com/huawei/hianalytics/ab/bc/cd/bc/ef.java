package com.huawei.hianalytics.ab.bc.cd.bc;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.ab.bc.ab;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ef
  implements fg
{
  private List<de> ab;
  private bc bc;
  private cd cd;
  private fg de;
  private String ef = "";
  private String fg;
  
  public ef(String paramString)
  {
    this.fg = paramString;
  }
  
  public void ab(bc parambc)
  {
    this.bc = parambc;
  }
  
  public void ab(cd paramcd)
  {
    this.cd = paramcd;
  }
  
  public void ab(com.huawei.hianalytics.ab.ef.ab paramab)
  {
    this.de = paramab;
  }
  
  public void ab(String paramString)
  {
    if (paramString != null) {
      this.ef = paramString;
    }
  }
  
  public void ab(List<de> paramList)
  {
    this.ab = paramList;
  }
  
  public JSONObject cd()
  {
    if ((this.ab == null) || (this.ab.size() == 0))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("EventUploadModel", "Not have actionEvent to send");
      return null;
    }
    if ((this.bc == null) || (this.cd == null) || (this.de == null))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("EventUploadModel", "model in wrong format");
      return null;
    }
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("header", this.bc.cd());
    Object localObject1 = new JSONObject();
    Object localObject2 = this.de.cd();
    ((JSONObject)localObject2).put("properties", this.cd.cd());
    try
    {
      ((JSONObject)localObject2).put("events_global_properties", new JSONObject(this.ef));
      ((JSONObject)localObject1).put("events_common", localObject2);
      localObject2 = new JSONArray();
      Iterator localIterator = this.ab.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label223;
        }
        JSONObject localJSONObject2 = ((de)localIterator.next()).cd();
        if (localJSONObject2 == null) {
          break;
        }
        ((JSONArray)localObject2).put(localJSONObject2);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ((JSONObject)localObject2).put("events_global_properties", this.ef);
        continue;
        com.huawei.hianalytics.ab.bc.ef.ab.cd("EventUploadModel", "custom event is empty,delete this event");
      }
      label223:
      ((JSONObject)localObject1).put("events", localObject2);
      localObject1 = ((JSONObject)localObject1).toString();
      try
      {
        localObject1 = com.huawei.hianalytics.ab.bc.kl.de.ab(((String)localObject1).getBytes("UTF-8"));
        localObject1 = com.huawei.hianalytics.ab.bc.ab.bc.ab().ab(bc.ab.ab).ab(this.fg, (byte[])localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          com.huawei.hianalytics.ab.bc.ef.ab.cd("EventUploadModel", "eventInfo encrypt failed,report over!");
          return null;
        }
        localJSONObject1.put("event", localObject1);
        return localJSONObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("EventUploadModel", "getBitZip(): Unsupported coding : utf-8");
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.cd.bc.ef
 * JD-Core Version:    0.7.0.1
 */
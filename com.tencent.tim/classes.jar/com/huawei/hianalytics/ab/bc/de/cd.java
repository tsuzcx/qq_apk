package com.huawei.hianalytics.ab.bc.de;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cd
{
  private String ab;
  private String bc;
  private String cd;
  private List<com.huawei.hianalytics.ab.bc.cd.bc.de> de;
  private String ef;
  
  public cd(String paramString1, String paramString2, String paramString3, List<com.huawei.hianalytics.ab.bc.cd.bc.de> paramList, String paramString4)
  {
    this.ab = paramString1;
    this.bc = paramString2;
    this.cd = paramString3;
    this.de = paramList;
    this.ef = paramString4;
  }
  
  private String ab(String paramString1, String paramString2)
  {
    String str = com.huawei.hianalytics.ab.ab.cd.cd(paramString1, paramString2);
    if (TextUtils.isEmpty(str)) {
      com.huawei.hianalytics.ab.bc.ef.ab.ab("DataReportHandler", "No report address,TAG : %s,TYPE: %s ", new Object[] { paramString1, paramString2 });
    }
    do
    {
      return "";
      if ("oper".equals(paramString2)) {
        return "{url}/common/hmshioperqrt".replace("{url}", str);
      }
      if ("maint".equals(paramString2)) {
        return "{url}/common/hmshimaintqrt".replace("{url}", str);
      }
    } while (!"diffprivacy".equals(paramString2));
    return "{url}/common/common2".replace("{url}", str);
  }
  
  private byte[] ab(com.huawei.hianalytics.ab.bc.cd.bc.ef paramef)
  {
    try
    {
      paramef = paramef.cd();
      if (paramef == null)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("DataReportHandler", "uploadEvents is null");
        return new byte[0];
      }
      paramef = com.huawei.hianalytics.ab.bc.kl.de.ab(paramef.toString().getBytes("UTF-8"));
      return paramef;
    }
    catch (JSONException paramef)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("DataReportHandler", "uploadEvents to json error");
      return new byte[0];
    }
    catch (UnsupportedEncodingException paramef)
    {
      for (;;)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("DataReportHandler", "sendData(): getBytes - Unsupported coding format!!");
      }
    }
  }
  
  private JSONArray bc()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.de.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (com.huawei.hianalytics.ab.bc.cd.bc.de)localIterator.next();
      try
      {
        localObject = ((com.huawei.hianalytics.ab.bc.cd.bc.de)localObject).de();
        localJSONArray.put(localObject);
      }
      catch (JSONException localJSONException)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.bc("DataReportHandler", "handleEvents: json error,Abandon this data");
      }
    }
    return localJSONArray;
  }
  
  private void cd()
  {
    if (com.huawei.hianalytics.ab.bc.kl.bc.ab(com.huawei.hianalytics.ab.ab.bc.ik(), "backup_event", 5242880))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("DataReportHandler", "backup file reach max limited size, discard new event ");
      return;
    }
    JSONArray localJSONArray = bc();
    String str = com.huawei.hianalytics.ab.bc.kl.ef.ab(this.ab, this.bc, this.ef);
    com.huawei.hianalytics.ab.bc.ef.ab.bc("DataReportHandler", "Update data cached into backup,spKey: " + str);
    com.huawei.hianalytics.ab.bc.ij.ab.ab(com.huawei.hianalytics.ab.ab.bc.ik(), "backup_event", str, localJSONArray.toString());
  }
  
  private com.huawei.hianalytics.ab.bc.cd.bc.ef de()
  {
    return com.huawei.hianalytics.ab.de.ab.ab(this.de, this.ab, this.bc, this.ef, this.cd);
  }
  
  public void ab()
  {
    Object localObject1 = ab(this.ab, this.bc);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (!"preins".equals(this.bc)))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("DataReportHandler", "collectUrl is empty");
      return;
    }
    if ((!"_hms_config_tag".equals(this.ab)) && (!"_openness_config_tag".equals(this.ab))) {
      cd();
    }
    Object localObject2 = de();
    if (localObject2 != null)
    {
      localObject2 = ab((com.huawei.hianalytics.ab.bc.cd.bc.ef)localObject2);
      if (localObject2.length == 0)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("DataReportHandler", "request body is empty");
        return;
      }
      localObject1 = new com.huawei.hianalytics.ab.bc.ik.bc.ab((byte[])localObject2, (String)localObject1, this.ab, this.bc, this.ef, this.de);
      com.huawei.hianalytics.ab.bc.ik.cd.bc.bc().ab((com.huawei.hianalytics.ab.bc.ik.cd.ab)localObject1);
      return;
    }
    localObject1 = new com.huawei.hianalytics.ab.bc.ik.bc.de(this.de, this.ab, this.ef, this.bc);
    com.huawei.hianalytics.ab.bc.ik.cd.bc.ab().ab((com.huawei.hianalytics.ab.bc.ik.cd.ab)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.de.cd
 * JD-Core Version:    0.7.0.1
 */
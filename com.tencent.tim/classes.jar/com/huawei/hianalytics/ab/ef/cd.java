package com.huawei.hianalytics.ab.ef;

import android.os.Build;
import org.json.JSONObject;

public class cd
  extends com.huawei.hianalytics.ab.bc.cd.bc.cd
{
  String fg;
  String gh;
  private String hi;
  
  public JSONObject cd()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("_rom_ver", this.hi);
    localJSONObject.put("_emui_ver", this.ab);
    localJSONObject.put("_model", Build.MODEL);
    localJSONObject.put("_mcc", this.fg);
    localJSONObject.put("_mnc", this.gh);
    localJSONObject.put("_package_name", this.bc);
    localJSONObject.put("_app_ver", this.cd);
    localJSONObject.put("_lib_ver", "2.2.0.303");
    localJSONObject.put("_channel", this.de);
    localJSONObject.put("_lib_name", "hianalytics");
    localJSONObject.put("_oaid_tracking_flag", this.ef);
    return localJSONObject;
  }
  
  public void fg(String paramString)
  {
    this.fg = paramString;
  }
  
  public void gh(String paramString)
  {
    this.gh = paramString;
  }
  
  public void hi(String paramString)
  {
    this.hi = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.ef.cd
 * JD-Core Version:    0.7.0.1
 */
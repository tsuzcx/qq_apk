package com.huawei.hianalytics.ab.ef;

import org.json.JSONObject;

public class ab
  extends com.huawei.hianalytics.ab.bc.cd.bc.ab
{
  protected String bc = "";
  private String cd = "";
  private String de = "";
  private String ef = "";
  private String fg = "";
  private String gh;
  
  public void bc(String paramString)
  {
    this.cd = paramString;
  }
  
  public JSONObject cd()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("androidid", this.ab);
    localJSONObject.put("oaid", this.gh);
    localJSONObject.put("uuid", this.bc);
    localJSONObject.put("upid", this.fg);
    localJSONObject.put("imei", this.cd);
    localJSONObject.put("sn", this.de);
    localJSONObject.put("udid", this.ef);
    return localJSONObject;
  }
  
  public void cd(String paramString)
  {
    this.de = paramString;
  }
  
  public void de(String paramString)
  {
    this.fg = paramString;
  }
  
  public void ef(String paramString)
  {
    this.ef = paramString;
  }
  
  public void fg(String paramString)
  {
    this.bc = paramString;
  }
  
  public void gh(String paramString)
  {
    this.gh = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.ef.ab
 * JD-Core Version:    0.7.0.1
 */
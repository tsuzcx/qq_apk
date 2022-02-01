package com.tencent.qqmail.utilities.qmnetwork.qmuser;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.qmdomain.QMDomain;

public class QMVerify
  extends QMDomain
{
  private static final long serialVersionUID = -842506846316923300L;
  private String authtype;
  private String vid;
  private String vuin;
  private String vurl;
  
  public QMVerify() {}
  
  public QMVerify(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public String getAuthtype()
  {
    return this.authtype;
  }
  
  public String getVid()
  {
    return this.vid;
  }
  
  public String getVuin()
  {
    return this.vuin;
  }
  
  public String getVurl()
  {
    return this.vurl;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    setVid((String)paramJSONObject.get("vid"));
    setVuin((String)paramJSONObject.get("vuin"));
    setVurl((String)paramJSONObject.get("vurl"));
    setAuthtype((String)paramJSONObject.get("authtype"));
    return false;
  }
  
  public void setAuthtype(String paramString)
  {
    this.authtype = paramString;
  }
  
  public void setVid(String paramString)
  {
    this.vid = paramString;
  }
  
  public void setVuin(String paramString)
  {
    this.vuin = paramString;
  }
  
  public void setVurl(String paramString)
  {
    this.vurl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.qmuser.QMVerify
 * JD-Core Version:    0.7.0.1
 */
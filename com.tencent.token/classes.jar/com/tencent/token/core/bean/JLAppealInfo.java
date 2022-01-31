package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public class JLAppealInfo
  implements Serializable
{
  private static final long serialVersionUID = -4144237682312765693L;
  public String desc;
  public String id;
  public String subTitle;
  public String table;
  public String title;
  
  public JLAppealInfo(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.getString("id");
    this.title = paramJSONObject.getString("title");
    this.subTitle = paramJSONObject.getString("subtitle");
    this.desc = paramJSONObject.getString("desc");
    this.table = paramJSONObject.getJSONArray("table").toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.JLAppealInfo
 * JD-Core Version:    0.7.0.1
 */
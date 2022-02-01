package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONObject;

public class ZzbIntroItem
  implements Serializable
{
  private static final long serialVersionUID = -2457137122729009982L;
  public String desc;
  public String title;
  
  public ZzbIntroItem(JSONObject paramJSONObject)
  {
    this.title = paramJSONObject.optString("title");
    this.desc = paramJSONObject.optString("desc");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.ZzbIntroItem
 * JD-Core Version:    0.7.0.1
 */
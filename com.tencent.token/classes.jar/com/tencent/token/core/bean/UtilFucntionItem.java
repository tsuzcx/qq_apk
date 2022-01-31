package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONObject;

public class UtilFucntionItem
  implements Serializable
{
  private static final long serialVersionUID = 1286682972544608251L;
  private String id;
  private String name;
  private String url;
  private int version;
  
  public UtilFucntionItem(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optString("id");
    this.version = paramJSONObject.optInt("version");
    this.name = paramJSONObject.optString("name");
    this.url = paramJSONObject.optString("url");
  }
  
  public final String a()
  {
    return this.id;
  }
  
  public final int b()
  {
    return this.version;
  }
  
  public final String c()
  {
    return this.name;
  }
  
  public final String d()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.UtilFucntionItem
 * JD-Core Version:    0.7.0.1
 */
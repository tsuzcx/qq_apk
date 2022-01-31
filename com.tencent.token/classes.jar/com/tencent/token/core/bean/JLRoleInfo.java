package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONObject;

public class JLRoleInfo
  implements Serializable
{
  private static final long serialVersionUID = -3263251584503260606L;
  public int id;
  public String name;
  
  public JLRoleInfo(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.getInt("role_id");
    this.name = paramJSONObject.getString("role_name");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.JLRoleInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONObject;

public class JLProtectionInfo$ProtectionInfoItem
  implements Serializable
{
  public static final int EM_SVC_TYPE_ACCOUNT_LOCK = 3;
  public static final int EM_SVC_TYPE_GAME_LOCK = 2;
  public static final int EM_SVC_TYPE_GAME_PROTECT = 1;
  public static final int EM_SVC_TYPE_QBQD_PROTECT = 4;
  private static final long serialVersionUID = 2797458695263568056L;
  public boolean busy;
  public String desc;
  public int id;
  public String name;
  public int type;
  public int value;
  
  public JLProtectionInfo$ProtectionInfoItem(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.getInt("id");
    this.name = paramJSONObject.getString("name");
    this.desc = paramJSONObject.getString("desc");
    this.value = paramJSONObject.getInt("value");
    this.type = paramJSONObject.getInt("type");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.JLProtectionInfo.ProtectionInfoItem
 * JD-Core Version:    0.7.0.1
 */
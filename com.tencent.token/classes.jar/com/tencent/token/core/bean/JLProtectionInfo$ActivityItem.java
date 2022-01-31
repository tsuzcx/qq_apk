package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONObject;

public class JLProtectionInfo$ActivityItem
  implements Serializable
{
  private static final long serialVersionUID = -7543733014347670018L;
  public String jumpURL;
  public String picURL;
  
  public JLProtectionInfo$ActivityItem(JSONObject paramJSONObject)
  {
    this.picURL = paramJSONObject.getString("pic_url");
    this.jumpURL = paramJSONObject.getString("jump_url");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.JLProtectionInfo.ActivityItem
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.token.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class JLProtectionInfo
  implements Serializable
{
  private static final long serialVersionUID = -5660582609249992294L;
  public ArrayList activityItem = new ArrayList();
  public String appealDesc;
  public String appealName;
  public int detail_max;
  public int detail_min;
  public boolean is_xy;
  public ArrayList protectionInfoItem = new ArrayList();
  public String recommandDesc;
  public String recommandName;
  
  public JLProtectionInfo(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.getJSONArray("prot_list");
    int i = 0;
    Object localObject;
    while (i < localJSONArray.length())
    {
      localObject = new JLProtectionInfo.ProtectionInfoItem(localJSONArray.getJSONObject(i));
      this.protectionInfoItem.add(localObject);
      i += 1;
    }
    localJSONArray = paramJSONObject.getJSONArray("activity_list");
    i = 0;
    while (i < localJSONArray.length())
    {
      localObject = new JLProtectionInfo.ActivityItem(localJSONArray.getJSONObject(i));
      this.activityItem.add(localObject);
      i += 1;
    }
    this.appealName = paramJSONObject.getString("appeal_name");
    this.appealDesc = paramJSONObject.getString("appeal_desc");
    this.recommandName = paramJSONObject.getString("recomd_name");
    this.recommandDesc = paramJSONObject.getString("recomd_desc");
    this.detail_max = paramJSONObject.getInt("detail_max");
    this.detail_min = paramJSONObject.getInt("detail_min");
    if (paramJSONObject.getInt("is_xy") == 1) {
      bool = true;
    }
    this.is_xy = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.JLProtectionInfo
 * JD-Core Version:    0.7.0.1
 */
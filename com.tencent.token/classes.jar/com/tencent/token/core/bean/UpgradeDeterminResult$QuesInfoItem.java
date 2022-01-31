package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONObject;

public class UpgradeDeterminResult$QuesInfoItem
  implements Serializable
{
  private static final long serialVersionUID = -6303479941324604162L;
  public String mContent = null;
  public int mId = 0;
  public int mType = 0;
  
  public UpgradeDeterminResult$QuesInfoItem(UpgradeDeterminResult paramUpgradeDeterminResult, JSONObject paramJSONObject)
  {
    this.mId = paramJSONObject.getInt("ques_id");
    this.mContent = paramJSONObject.getString("ques_content");
    this.mType = paramJSONObject.getInt("ques_type");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.UpgradeDeterminResult.QuesInfoItem
 * JD-Core Version:    0.7.0.1
 */
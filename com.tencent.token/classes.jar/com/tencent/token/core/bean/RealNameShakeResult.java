package com.tencent.token.core.bean;

import com.tencent.token.global.e;
import java.io.Serializable;
import org.json.JSONObject;

public class RealNameShakeResult
  implements Serializable
{
  private static final long serialVersionUID = 341525324058326856L;
  public int action1_id;
  public String bottomText;
  public String button1_text;
  public int chanceLeft;
  public int icon_id;
  public String main_title;
  public int shakeStatus;
  public String sub_title;
  public String target_url;
  public String third_title;
  public int totalLeft;
  public String wx_share_text;
  public String wx_share_title;
  
  public RealNameShakeResult(JSONObject paramJSONObject)
  {
    e.a("shake jsonObject=" + paramJSONObject);
    this.icon_id = paramJSONObject.getInt("icon_id");
    this.main_title = paramJSONObject.getString("main_title");
    this.sub_title = paramJSONObject.getString("sub_title");
    this.third_title = paramJSONObject.getString("third_title");
    this.action1_id = paramJSONObject.getInt("action_id");
    this.button1_text = paramJSONObject.getString("button_text");
    this.bottomText = paramJSONObject.getString("bottom_text");
    this.target_url = paramJSONObject.getString("target_url");
    this.wx_share_title = paramJSONObject.getString("wx_share_title");
    this.wx_share_text = paramJSONObject.getString("wx_share_text");
    this.shakeStatus = paramJSONObject.getInt("shake_status");
    this.chanceLeft = paramJSONObject.getInt("chance_left");
    this.totalLeft = paramJSONObject.getInt("total_left");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.RealNameShakeResult
 * JD-Core Version:    0.7.0.1
 */
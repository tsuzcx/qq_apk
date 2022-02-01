package com.tencent.token.core.bean;

import com.tencent.token.global.g;
import java.io.Serializable;
import org.json.JSONObject;

public class RealNameRegResult
  implements Serializable
{
  private static final long serialVersionUID = 736958906972493428L;
  public int chance_left;
  public int change_face_result;
  public int complete_time;
  public int daily_zzb_cnt;
  public int dispatch_time;
  public int submit_time;
  public int time_left;
  public String top_msg_text;
  
  public RealNameRegResult(JSONObject paramJSONObject)
  {
    this.time_left = paramJSONObject.getInt("time_left");
    this.submit_time = paramJSONObject.getInt("submit_time");
    this.complete_time = paramJSONObject.getInt("complete_time");
    this.chance_left = paramJSONObject.getInt("chance_left");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chance_left:");
    localStringBuilder.append(this.chance_left);
    g.a(localStringBuilder.toString());
    this.daily_zzb_cnt = paramJSONObject.getInt("daily_zzb_cnt");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("daily_zzb_cnt:");
    localStringBuilder.append(this.daily_zzb_cnt);
    g.a(localStringBuilder.toString());
    this.top_msg_text = paramJSONObject.getString("top_msg_text");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("top_msg_text:");
    localStringBuilder.append(this.top_msg_text);
    g.a(localStringBuilder.toString());
    this.dispatch_time = paramJSONObject.getInt("dispatch_time");
    this.change_face_result = paramJSONObject.getInt("change_face_result");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.RealNameRegResult
 * JD-Core Version:    0.7.0.1
 */
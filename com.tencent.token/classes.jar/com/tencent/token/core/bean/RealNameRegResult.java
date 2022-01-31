package com.tencent.token.core.bean;

import com.tencent.token.global.e;
import java.io.Serializable;
import org.json.JSONObject;

public class RealNameRegResult
  implements Serializable
{
  private static final long serialVersionUID = 736958906972493428L;
  public int chance_left;
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
    e.a("chance_left:" + this.chance_left);
    this.daily_zzb_cnt = paramJSONObject.getInt("daily_zzb_cnt");
    e.a("daily_zzb_cnt:" + this.daily_zzb_cnt);
    this.top_msg_text = paramJSONObject.getString("top_msg_text");
    e.a("top_msg_text:" + this.top_msg_text);
    this.dispatch_time = paramJSONObject.getInt("dispatch_time");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.RealNameRegResult
 * JD-Core Version:    0.7.0.1
 */
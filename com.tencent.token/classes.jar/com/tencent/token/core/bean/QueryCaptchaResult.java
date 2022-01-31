package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONObject;

public class QueryCaptchaResult
  implements Serializable
{
  private static final long serialVersionUID = -3090433295861489742L;
  public String mAppid = "1600000810";
  public long mLastGetUrlTime;
  public boolean mNeedCaptcha = false;
  public long mRealUin;
  public int mSceneId;
  public int mUrlValidTimeSecs;
  
  public QueryCaptchaResult(JSONObject paramJSONObject)
  {
    if (paramJSONObject.getInt("need_captcha") == 1) {}
    for (;;)
    {
      this.mNeedCaptcha = bool;
      if (this.mNeedCaptcha)
      {
        this.mUrlValidTimeSecs = paramJSONObject.getInt("url_valid_time");
        this.mLastGetUrlTime = (System.currentTimeMillis() / 1000L);
        this.mAppid = ("" + paramJSONObject.getInt("appid"));
      }
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.QueryCaptchaResult
 * JD-Core Version:    0.7.0.1
 */
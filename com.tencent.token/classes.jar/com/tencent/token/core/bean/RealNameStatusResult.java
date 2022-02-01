package com.tencent.token.core.bean;

import com.tencent.token.xb;
import java.io.Serializable;
import org.json.JSONObject;

public class RealNameStatusResult
  implements Serializable
{
  public static final int STATUS_IS_REAL_NAME = 1;
  public static final int STATUS_NOT_REAL_NAME_SUBMITTED_DATA = 2;
  public static final int STATUS_NOT_REAL_NAME_WITHOUT_QUALIFICATION = 4;
  public static final int STATUS_NOT_REAL_NAME_WITH_QUALIFICATION = 3;
  private static final long serialVersionUID = -4162087501328710134L;
  public int chanceLeft;
  public long mApplyRefuseTime;
  public long mCompleteTime;
  public int mDailyZzbCnt;
  public int mDispatchTime;
  public long mLeftTime;
  public String mMaskId;
  public String mMaskMobile;
  public String mMaskName;
  public String mMsgText;
  public int mRealStatus;
  public long mSubmitTime;
  public String mToastText;
  public String mToastUrl;
  public int mVerify_sms;
  public int realnameday;
  public int regVersion;
  public int reg_rank;
  public String shareCircleText;
  public String shareFriendText;
  public String shareTitle;
  public String subTitle;
  public int totalLeft;
  public String urlShare;
  
  public RealNameStatusResult() {}
  
  public RealNameStatusResult(JSONObject paramJSONObject)
  {
    this.mRealStatus = paramJSONObject.getInt("realname_status");
    xb.a("real_name_status_result: ".concat(String.valueOf(paramJSONObject)));
    label137:
    try
    {
      this.mToastText = paramJSONObject.getString("top_toast_text");
      this.mToastUrl = paramJSONObject.getString("top_toast_url");
    }
    catch (Exception localException1)
    {
      label49:
      break label49;
    }
    xb.c("json parse error: mToastText,mToastUrl");
    switch (this.mRealStatus)
    {
    default: 
      break;
    case 4: 
      this.subTitle = paramJSONObject.getString("subtitle_text");
      break;
    case 3: 
      this.mMaskMobile = paramJSONObject.getString("masked_mobile");
      this.mDailyZzbCnt = paramJSONObject.getInt("daily_zzb_cnt");
    }
    try
    {
      this.mApplyRefuseTime = paramJSONObject.getLong("apply_refused_time");
    }
    catch (Exception localException2)
    {
      break label137;
    }
    xb.c("json parse error: apply_refused_time");
    this.mDispatchTime = paramJSONObject.getInt("dispatch_time");
    this.mVerify_sms = paramJSONObject.optInt("verify_sms", 1);
    break label372;
    this.regVersion = paramJSONObject.getInt("reg_version");
    if (this.regVersion == 1)
    {
      this.mLeftTime = paramJSONObject.getInt("time_left");
      this.mSubmitTime = paramJSONObject.getLong("submit_time");
      this.mCompleteTime = paramJSONObject.getLong("complete_time");
    }
    else
    {
      this.mLeftTime = paramJSONObject.getInt("time_left");
      this.chanceLeft = paramJSONObject.getInt("chance_left");
      this.mMsgText = paramJSONObject.getString("top_msg_text");
    }
    this.mDailyZzbCnt = paramJSONObject.getInt("daily_zzb_cnt");
    this.mMaskMobile = paramJSONObject.getString("masked_mobile");
    this.mDispatchTime = paramJSONObject.getInt("dispatch_time");
    break label372;
    this.mMaskName = paramJSONObject.getString("masked_name");
    this.mMaskId = paramJSONObject.getString("masked_id");
    this.mMaskMobile = paramJSONObject.getString("masked_mobile");
    this.reg_rank = paramJSONObject.getInt("reg_rank");
    this.realnameday = paramJSONObject.getInt("protect_days");
    this.urlShare = paramJSONObject.getString("url_share");
    this.shareTitle = paramJSONObject.getString("share_title");
    this.shareCircleText = paramJSONObject.getString("share_circle_text");
    this.shareFriendText = paramJSONObject.getString("share_friend_text");
    label372:
    paramJSONObject = new StringBuilder("realname_status=");
    paramJSONObject.append(this.mRealStatus);
    paramJSONObject.append(", mobile=");
    paramJSONObject.append(this.mMaskMobile);
    xb.b(paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.RealNameStatusResult
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.token.core.bean;

import com.tencent.token.global.e;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SafeMsgItem
  implements Serializable
{
  public static final int QQ_MSG_FLAG_BIT_ABNORM = 7;
  public static final int QQ_MSG_FLAG_BIT_FB = 0;
  public static final int QQ_MSG_FLAG_BIT_IPC = 2;
  public static final int QQ_MSG_FLAG_BIT_LONG_MSG = 2147483647;
  public static final int QQ_MSG_FLAG_BIT_NORMAL_NORESIDENT_LOGIN = 8;
  public static final int QQ_MSG_FLAG_BIT_PULL = 1;
  public static final int QQ_MSG_TYPE_A_ABNORM = 4;
  public static final int QQ_MSG_TYPE_A_INT = 3;
  public static final int QQ_MSG_TYPE_A_LOGIN = 1;
  public static final int QQ_MSG_TYPE_A_SENS = 2;
  public static final int QQ_MSG_TYPE_B_CTLOGIN = 1;
  public static final int QQ_MSG_TYPE_B_MOBILE_QQ = 3;
  public static final int QQ_MSG_TYPE_B_PTLOGIN = 2;
  public static final int QQ_MSG_TYPE_B_QB_INT = 1;
  public static final int QQ_MSG_TYPE_B_WTLOGIN = 11;
  private static final long serialVersionUID = -7664964646815479758L;
  public SafeMsgItem.MsgAction mAction;
  public String mContent;
  public String mDetail;
  public SafeMsgItem.MsgAction mFeedBack;
  public int mFlag;
  public String mIP;
  public long mId;
  public boolean mIsChecked;
  public boolean mIsRead;
  public int mLoc_city_id;
  public int mLoc_country_id;
  public int mLoc_prov_id;
  public String mMsgVersion;
  public String mTable;
  public String mTextAfterTable;
  public String mTextBeforeTable;
  public long mTime;
  public String mTitle;
  public int mTypea;
  public int mTypeb;
  public int mTypec;
  public long mUin;
  public String mUri;
  
  private static int a(String paramString)
  {
    try
    {
      paramString = paramString.split("\\.");
      int i = Integer.parseInt(paramString[0]);
      int j = Integer.parseInt(paramString[1]);
      int k = Integer.parseInt(paramString[2]);
      int m = Integer.parseInt(paramString[3]);
      return (m & 0xFF) + (((i & 0xFF) << 24) + ((j & 0xFF) << 16) + ((k & 0xFF) << 8));
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public final int a()
  {
    return a(this.mIP);
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    try
    {
      this.mTitle = paramJSONObject.getString("title");
      this.mContent = paramJSONObject.getString("content");
      this.mTime = paramJSONObject.getInt("time");
      this.mFlag = paramJSONObject.getInt("flag");
      this.mTextBeforeTable = paramJSONObject.getString("text_before_table");
      this.mTextAfterTable = paramJSONObject.getString("text_after_table");
      JSONObject localJSONObject = paramJSONObject.getJSONObject("type");
      if (localJSONObject != null)
      {
        this.mTypea = localJSONObject.getInt("typea");
        this.mTypeb = localJSONObject.getInt("typeb");
        this.mTypec = localJSONObject.getInt("typec");
      }
      localJSONObject = paramJSONObject.getJSONObject("action");
      if (localJSONObject != null)
      {
        this.mAction = new SafeMsgItem.MsgAction(this);
        this.mAction.mActionType = localJSONObject.getString("action_type");
        this.mAction.mButtonText = localJSONObject.getString("btn_text");
        this.mAction.mTargetUrl = localJSONObject.getString("target");
      }
      localJSONObject = paramJSONObject.getJSONObject("feedback");
      if (localJSONObject != null)
      {
        this.mFeedBack = new SafeMsgItem.MsgAction(this);
        this.mFeedBack.mActionType = localJSONObject.getString("type");
        this.mFeedBack.mButtonText = localJSONObject.getString("btn_text");
        this.mFeedBack.mTargetUrl = localJSONObject.getString("target");
      }
      this.mTextBeforeTable = paramJSONObject.getString("text_before_table");
      this.mTable = paramJSONObject.getJSONArray("table").toString();
      if (this.mTypea == 1)
      {
        this.mIP = paramJSONObject.getString("ip");
        localJSONObject = paramJSONObject.getJSONObject("location");
        if (localJSONObject != null)
        {
          this.mLoc_country_id = localJSONObject.getInt("country_id");
          this.mLoc_prov_id = localJSONObject.getInt("prov_id");
          this.mLoc_city_id = localJSONObject.getInt("city_id");
        }
      }
      this.mTextAfterTable = paramJSONObject.getString("text_after_table");
      this.mMsgVersion = "5";
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      e.c("JSONException: " + paramJSONObject.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.SafeMsgItem
 * JD-Core Version:    0.7.0.1
 */
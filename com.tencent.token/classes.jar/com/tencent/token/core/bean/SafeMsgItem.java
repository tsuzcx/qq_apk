package com.tencent.token.core.bean;

import com.tencent.token.xj;
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
  public MsgAction mAction;
  public String mContent;
  public String mDetail;
  public MsgAction mFeedBack;
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
  
  public static int a(String paramString)
  {
    try
    {
      paramString = paramString.split("\\.");
      int i = Integer.parseInt(paramString[0]);
      int j = Integer.parseInt(paramString[1]);
      int k = Integer.parseInt(paramString[2]);
      int m = Integer.parseInt(paramString[3]);
      return ((i & 0xFF) << 24) + ((j & 0xFF) << 16) + ((k & 0xFF) << 8) + (m & 0xFF);
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public final boolean a()
  {
    return (this.mFlag & 0x80) == 128;
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
      localObject = paramJSONObject.getJSONObject("type");
      if (localObject != null)
      {
        this.mTypea = ((JSONObject)localObject).getInt("typea");
        this.mTypeb = ((JSONObject)localObject).getInt("typeb");
        this.mTypec = ((JSONObject)localObject).getInt("typec");
      }
      localObject = paramJSONObject.getJSONObject("action");
      if (localObject != null)
      {
        this.mAction = new MsgAction();
        this.mAction.mActionType = ((JSONObject)localObject).getString("action_type");
        this.mAction.mButtonText = ((JSONObject)localObject).getString("btn_text");
        this.mAction.mTargetUrl = ((JSONObject)localObject).getString("target");
      }
      localObject = paramJSONObject.getJSONObject("feedback");
      if (localObject != null)
      {
        this.mFeedBack = new MsgAction();
        this.mFeedBack.mActionType = ((JSONObject)localObject).getString("type");
        this.mFeedBack.mButtonText = ((JSONObject)localObject).getString("btn_text");
        this.mFeedBack.mTargetUrl = ((JSONObject)localObject).getString("target");
      }
      this.mTextBeforeTable = paramJSONObject.getString("text_before_table");
      this.mTable = paramJSONObject.getJSONArray("table").toString();
      if (this.mTypea == 1)
      {
        this.mIP = paramJSONObject.getString("ip");
        localObject = paramJSONObject.getJSONObject("location");
        if (localObject != null)
        {
          this.mLoc_country_id = ((JSONObject)localObject).getInt("country_id");
          this.mLoc_prov_id = ((JSONObject)localObject).getInt("prov_id");
          this.mLoc_city_id = ((JSONObject)localObject).getInt("city_id");
        }
      }
      this.mTextAfterTable = paramJSONObject.getString("text_after_table");
      this.mMsgVersion = "5";
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject = new StringBuilder("JSONException: ");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      xj.c(((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public final boolean b()
  {
    return (this.mFlag & 0x4) == 4;
  }
  
  public final boolean c()
  {
    return (this.mFlag & 0x100) == 256;
  }
  
  public final boolean d()
  {
    return (this.mFlag & 0x1) == 1;
  }
  
  public class MsgAction
    implements Serializable
  {
    private static final long serialVersionUID = -179518061041549637L;
    public String mActionType;
    public String mButtonText;
    public String mTargetUrl;
    
    public MsgAction() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.SafeMsgItem
 * JD-Core Version:    0.7.0.1
 */
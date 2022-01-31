package com.tencent.token.core.bean;

import com.tencent.token.global.h;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class EvalAccountResult
  implements Serializable
{
  public static final int RECOMMD_ITEM_ID_MY_FOOT = 1;
  public static final int RECOMMD_ITEM_ID_MY_MB = 4;
  public static final int RECOMMD_ITEM_ID_MY_PWD = 2;
  public static final int RECOMMD_ITEM_ID_MY_QQPIM_PROTECT = 5;
  public static final int RECOMMD_ITEM_ID_SUB_ACC_LOCK = 305;
  public static final int RECOMMD_ITEM_ID_SUB_FACE_MB = 401;
  public static final int RECOMMD_ITEM_ID_SUB_FINGER_MB = 402;
  public static final int RECOMMD_ITEM_ID_SUB_GAME_LOCK = 306;
  public static final int RECOMMD_ITEM_ID_SUB_GAME_PROT = 302;
  public static final int RECOMMD_ITEM_ID_SUB_MAIL_PROT = 303;
  public static final int RECOMMD_ITEM_ID_SUB_MOBILE_MB = 404;
  public static final int RECOMMD_ITEM_ID_SUB_PWD = 201;
  public static final int RECOMMD_ITEM_ID_SUB_PWD_ABNORMAL_LOGIN_TIMES = 202;
  public static final int RECOMMD_ITEM_ID_SUB_QB_PROT = 304;
  public static final int RECOMMD_ITEM_ID_SUB_QQ_PROT = 301;
  public static final int RECOMMD_ITEM_ID_SUB_QUESTION_MB = 405;
  public static final int RECOMMD_ITEM_ID_SUB_REALNAME_MB = 403;
  public static final int RECOMMD_ITEM_ID_SUB_TOKEN_MB = 406;
  private static final long serialVersionUID = -6565579543089831219L;
  public int mActionId;
  public int mCanZzb;
  public int mDegree;
  public String mDesc;
  public String mMarketUrl;
  public boolean mOutOfDate;
  public ArrayList mRecommends = new ArrayList();
  public int mStatus;
  public int mSubStatus;
  public String mSummary;
  public String mTitle;
  public long mUin;
  public long mUinHash;
  public String mUpdateInfo;
  public String mUrl;
  
  public EvalAccountResult(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    JSONObject localJSONObject = paramJSONObject1.getJSONObject("check_result");
    h.b("check_result:" + localJSONObject.toString());
    this.mStatus = localJSONObject.getInt("status");
    this.mSubStatus = localJSONObject.getInt("sub_status");
    this.mTitle = localJSONObject.getString("title");
    this.mDegree = localJSONObject.getInt("urgency_degree");
    this.mActionId = localJSONObject.getInt("action_id");
    if (localJSONObject.has("url")) {
      this.mUrl = localJSONObject.getString("url");
    }
    if (localJSONObject.has("desc")) {
      this.mDesc = localJSONObject.getString("desc");
    }
    if (localJSONObject.has("can_zzb")) {
      this.mCanZzb = localJSONObject.getInt("can_zzb");
    }
    this.mSummary = paramJSONObject2.getString("summary");
    if (paramJSONObject2.getInt("out_of_date") == 0) {}
    for (boolean bool = false;; bool = true)
    {
      this.mOutOfDate = bool;
      if (this.mOutOfDate)
      {
        this.mUpdateInfo = paramJSONObject2.getString("update_note");
        if (paramJSONObject2.has("market_url")) {
          this.mMarketUrl = paramJSONObject2.getString("market_url");
        }
      }
      paramJSONObject1 = paramJSONObject1.getJSONArray("recommends");
      while (i < paramJSONObject1.length())
      {
        h.b("一级推荐列表" + paramJSONObject1.getJSONObject(i).toString());
        paramJSONObject2 = new EvalAccountResult.RecommendItem(paramJSONObject1.getJSONObject(i));
        this.mRecommends.add(paramJSONObject2);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.EvalAccountResult
 * JD-Core Version:    0.7.0.1
 */
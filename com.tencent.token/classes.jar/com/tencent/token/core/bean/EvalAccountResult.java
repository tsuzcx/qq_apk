package com.tencent.token.core.bean;

import com.tencent.token.xv;
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
  public ArrayList<RecommendItem> mRecommends = new ArrayList();
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
    StringBuilder localStringBuilder = new StringBuilder("check_result:");
    localStringBuilder.append(localJSONObject.toString());
    xv.b(localStringBuilder.toString());
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
    int j = paramJSONObject2.getInt("out_of_date");
    int i = 0;
    boolean bool;
    if (j == 0) {
      bool = false;
    } else {
      bool = true;
    }
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
      paramJSONObject2 = new StringBuilder("一级推荐列表");
      paramJSONObject2.append(paramJSONObject1.getJSONObject(i).toString());
      xv.b(paramJSONObject2.toString());
      paramJSONObject2 = new RecommendItem(paramJSONObject1.getJSONObject(i));
      this.mRecommends.add(paramJSONObject2);
      i += 1;
    }
  }
  
  public static class DetailItem
    implements Serializable
  {
    private static final long serialVersionUID = 5521091018833642724L;
    public int mDegree;
    public String mDesc;
    public int mRecommendId;
    public String mTitle;
    
    public DetailItem(JSONObject paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder("DetailItem:");
      localStringBuilder.append(paramJSONObject.toString());
      xv.b(localStringBuilder.toString());
      this.mRecommendId = paramJSONObject.getInt("recommend_id");
      this.mDegree = paramJSONObject.getInt("degree");
      this.mTitle = paramJSONObject.getString("title");
      this.mDesc = paramJSONObject.getString("desc");
    }
  }
  
  public static class RecommendItem
    implements Serializable
  {
    private static final long serialVersionUID = -7344683138244993145L;
    public int mDegree;
    public String mDesc;
    public ArrayList<EvalAccountResult.DetailItem> mDetails = new ArrayList();
    public int mRecommendId;
    public String mSubTitle;
    public String mTitle;
    
    public RecommendItem(JSONObject paramJSONObject)
    {
      this.mRecommendId = paramJSONObject.getInt("recommend_id");
      this.mDegree = paramJSONObject.getInt("degree");
      this.mTitle = paramJSONObject.getString("title");
      this.mSubTitle = paramJSONObject.getString("sub_title");
      this.mDesc = paramJSONObject.getString("desc");
      paramJSONObject = paramJSONObject.getJSONArray("detail_items");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        Object localObject = new StringBuilder("二级推荐列表");
        ((StringBuilder)localObject).append(paramJSONObject.getJSONObject(i).toString());
        xv.b(((StringBuilder)localObject).toString());
        localObject = new EvalAccountResult.DetailItem(paramJSONObject.getJSONObject(i));
        this.mDetails.add(localObject);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.EvalAccountResult
 * JD-Core Version:    0.7.0.1
 */
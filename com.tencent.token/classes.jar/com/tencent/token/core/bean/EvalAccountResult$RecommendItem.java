package com.tencent.token.core.bean;

import com.tencent.token.global.e;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class EvalAccountResult$RecommendItem
  implements Serializable
{
  private static final long serialVersionUID = -7344683138244993145L;
  public int mDegree;
  public String mDesc;
  public ArrayList mDetails = new ArrayList();
  public int mRecommendId;
  public String mSubTitle;
  public String mTitle;
  
  public EvalAccountResult$RecommendItem(JSONObject paramJSONObject)
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
      e.b("二级推荐列表" + paramJSONObject.getJSONObject(i).toString());
      EvalAccountResult.DetailItem localDetailItem = new EvalAccountResult.DetailItem(paramJSONObject.getJSONObject(i));
      this.mDetails.add(localDetailItem);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.EvalAccountResult.RecommendItem
 * JD-Core Version:    0.7.0.1
 */
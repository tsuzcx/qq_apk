package com.tencent.token.core.bean;

import com.tencent.token.global.e;
import java.io.Serializable;
import org.json.JSONObject;

public class EvalAccountResult$DetailItem
  implements Serializable
{
  private static final long serialVersionUID = 5521091018833642724L;
  public int mDegree;
  public String mDesc;
  public int mRecommendId;
  public String mTitle;
  
  public EvalAccountResult$DetailItem(JSONObject paramJSONObject)
  {
    e.b("DetailItem:" + paramJSONObject.toString());
    this.mRecommendId = paramJSONObject.getInt("recommend_id");
    this.mDegree = paramJSONObject.getInt("degree");
    this.mTitle = paramJSONObject.getString("title");
    this.mDesc = paramJSONObject.getString("desc");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.EvalAccountResult.DetailItem
 * JD-Core Version:    0.7.0.1
 */
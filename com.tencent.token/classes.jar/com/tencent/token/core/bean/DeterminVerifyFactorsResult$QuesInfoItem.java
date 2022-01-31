package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONObject;

public class DeterminVerifyFactorsResult$QuesInfoItem
  implements Serializable
{
  private static final long serialVersionUID = -545981221446172220L;
  public String mContent = null;
  public int mId = 0;
  public int mType = 0;
  
  public DeterminVerifyFactorsResult$QuesInfoItem(DeterminVerifyFactorsResult paramDeterminVerifyFactorsResult, JSONObject paramJSONObject)
  {
    this.mId = paramJSONObject.getInt("ques_id");
    this.mContent = paramJSONObject.getString("ques_context");
    this.mType = paramJSONObject.getInt("ques_type");
  }
  
  public int a()
  {
    return this.mId;
  }
  
  public String b()
  {
    return this.mContent;
  }
  
  public int c()
  {
    return this.mType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.DeterminVerifyFactorsResult.QuesInfoItem
 * JD-Core Version:    0.7.0.1
 */
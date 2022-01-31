package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class MbInfoResult$MbInfoItem
  implements Serializable
{
  private static final long serialVersionUID = 5162164365673394343L;
  public String mContent;
  public String mDesc;
  public MbInfoResult.MbInfoItemDetail mDetail;
  public int mId;
  public String mName;
  public String mOpName;
  public int mValue;
  
  public MbInfoResult$MbInfoItem(JSONObject paramJSONObject)
  {
    this.mId = paramJSONObject.getInt("id");
    this.mName = paramJSONObject.getString("name");
    this.mDesc = paramJSONObject.getString("desc");
    this.mValue = paramJSONObject.getInt("value");
    this.mOpName = paramJSONObject.getString("value_word");
    try
    {
      this.mContent = paramJSONObject.getString("content");
      this.mDetail = new MbInfoResult.MbInfoItemDetail(paramJSONObject.getJSONObject("detail_info"));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.MbInfoResult.MbInfoItem
 * JD-Core Version:    0.7.0.1
 */
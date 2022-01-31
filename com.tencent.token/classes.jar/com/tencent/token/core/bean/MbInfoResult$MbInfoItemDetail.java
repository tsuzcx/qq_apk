package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MbInfoResult$MbInfoItemDetail
  implements Serializable
{
  private static final long serialVersionUID = -909766217975577730L;
  public int mBtnExtStatus;
  public String mBtnExtText;
  public int mBtnExtType;
  public int mBtnStatus;
  public String mBtnText;
  public int mBtnType;
  public String mDesc;
  public String mTable;
  
  public MbInfoResult$MbInfoItemDetail(JSONObject paramJSONObject)
  {
    this.mDesc = paramJSONObject.getString("detail_word");
    this.mBtnType = paramJSONObject.getInt("btn_type");
    this.mBtnText = paramJSONObject.getString("btn_text");
    this.mBtnStatus = paramJSONObject.getInt("btn_status");
    this.mTable = paramJSONObject.getJSONArray("tab_info").toString();
    try
    {
      this.mBtnExtType = paramJSONObject.getInt("ex_btn_type");
      this.mBtnExtText = paramJSONObject.getString("ex_btn_text");
      this.mBtnExtStatus = paramJSONObject.getInt("ex_btn_status");
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.MbInfoResult.MbInfoItemDetail
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.token.core.bean;

import com.tencent.token.xa;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MbInfoResult
  implements Serializable
{
  private static final long serialVersionUID = 1491530977583986061L;
  public ArrayList<MbInfoItem> mMbInfoItems = new ArrayList();
  
  public MbInfoResult(JSONArray paramJSONArray)
  {
    xa.c(paramJSONArray.toString());
    int i = 0;
    while (i < paramJSONArray.length())
    {
      MbInfoItem localMbInfoItem = new MbInfoItem(paramJSONArray.getJSONObject(i));
      this.mMbInfoItems.add(localMbInfoItem);
      i += 1;
    }
  }
  
  public static class MbInfoItem
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
    
    public MbInfoItem(JSONObject paramJSONObject)
    {
      this.mId = paramJSONObject.getInt("id");
      this.mName = paramJSONObject.getString("name");
      this.mDesc = paramJSONObject.getString("desc");
      this.mValue = paramJSONObject.getInt("value");
      this.mOpName = paramJSONObject.getString("value_word");
      try
      {
        this.mContent = paramJSONObject.getString("content");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      this.mDetail = new MbInfoResult.MbInfoItemDetail(paramJSONObject.getJSONObject("detail_info"));
    }
  }
  
  public static class MbInfoItemDetail
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
    
    public MbInfoItemDetail(JSONObject paramJSONObject)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.MbInfoResult
 * JD-Core Version:    0.7.0.1
 */
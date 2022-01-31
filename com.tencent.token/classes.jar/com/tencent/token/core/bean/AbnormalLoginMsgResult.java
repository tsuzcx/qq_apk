package com.tencent.token.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AbnormalLoginMsgResult
  implements Serializable
{
  private static final long serialVersionUID = -5970917243977567223L;
  public int mCnt;
  public boolean mIsNeedAgain;
  public List mMsgList = null;
  
  public AbnormalLoginMsgResult(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("is_have_msg");
    this.mCnt = paramJSONObject.getInt("rsp_msg_num");
    boolean bool;
    JSONArray localJSONArray;
    if ((j > 0) && (this.mCnt > 0))
    {
      bool = true;
      this.mIsNeedAgain = bool;
      localJSONArray = paramJSONObject.getJSONArray("msgs");
      if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
        this.mMsgList = new ArrayList();
      }
    }
    else
    {
      for (;;)
      {
        if (i >= localJSONArray.length()) {
          break label184;
        }
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        SafeMsgItem localSafeMsgItem = new SafeMsgItem();
        localSafeMsgItem.mUin = paramJSONObject.getLong("uin");
        if (!localSafeMsgItem.a(localJSONObject))
        {
          throw new JSONException("parse msg[" + i + "] error");
          bool = false;
          break;
        }
        this.mMsgList.add(localSafeMsgItem);
        i += 1;
      }
      label184:
      if (this.mCnt != this.mMsgList.size()) {
        throw new JSONException("cnt not equas msgs.size");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.AbnormalLoginMsgResult
 * JD-Core Version:    0.7.0.1
 */
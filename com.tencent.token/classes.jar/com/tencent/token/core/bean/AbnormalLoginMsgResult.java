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
  public List<SafeMsgItem> mMsgList = null;
  
  public AbnormalLoginMsgResult(JSONObject paramJSONObject)
  {
    this.mCnt = paramJSONObject.getInt("rsp_msg_num");
    JSONArray localJSONArray = paramJSONObject.getJSONArray("msgs");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      this.mMsgList = new ArrayList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        SafeMsgItem localSafeMsgItem = new SafeMsgItem();
        localSafeMsgItem.mUin = paramJSONObject.getLong("uin");
        if (localSafeMsgItem.a(localJSONObject))
        {
          this.mMsgList.add(localSafeMsgItem);
          i += 1;
        }
        else
        {
          paramJSONObject = new StringBuilder("parse msg[");
          paramJSONObject.append(i);
          paramJSONObject.append("] error");
          throw new JSONException(paramJSONObject.toString());
        }
      }
      if (this.mCnt == this.mMsgList.size()) {
        return;
      }
      throw new JSONException("cnt not equas msgs.size");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.AbnormalLoginMsgResult
 * JD-Core Version:    0.7.0.1
 */
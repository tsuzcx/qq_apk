package com.tencent.token.core.bean;

import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MbInfoResult
  implements Serializable
{
  private static final long serialVersionUID = 1491530977583986061L;
  public ArrayList mMbInfoItems = new ArrayList();
  
  public MbInfoResult(JSONObject paramJSONObject)
  {
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject == null) {
      throw new JSONException("dec transdata error");
    }
    paramJSONObject = new JSONArray(new String(paramJSONObject));
    e.c(paramJSONObject.toString());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      MbInfoResult.MbInfoItem localMbInfoItem = new MbInfoResult.MbInfoItem(paramJSONObject.getJSONObject(i));
      this.mMbInfoItems.add(localMbInfoItem);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.MbInfoResult
 * JD-Core Version:    0.7.0.1
 */
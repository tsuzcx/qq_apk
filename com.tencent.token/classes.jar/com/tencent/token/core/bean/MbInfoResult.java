package com.tencent.token.core.bean;

import com.tencent.token.global.h;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;

public class MbInfoResult
  implements Serializable
{
  private static final long serialVersionUID = 1491530977583986061L;
  public ArrayList mMbInfoItems = new ArrayList();
  
  public MbInfoResult(JSONArray paramJSONArray)
  {
    h.c(paramJSONArray.toString());
    int i = 0;
    while (i < paramJSONArray.length())
    {
      MbInfoResult.MbInfoItem localMbInfoItem = new MbInfoResult.MbInfoItem(paramJSONArray.getJSONObject(i));
      this.mMbInfoItems.add(localMbInfoItem);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.MbInfoResult
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

public class QMDomain
  implements Serializable
{
  public QMDomain()
  {
    initData();
  }
  
  public QMDomain(JSONObject paramJSONObject)
  {
    initData();
    parseWithDictionary(paramJSONObject);
  }
  
  public static Object fromDictionary(JSONObject paramJSONObject, QMDomain paramQMDomain)
  {
    paramQMDomain.init(paramJSONObject);
    return paramQMDomain;
  }
  
  protected static Boolean getBoolean(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    if ((paramObject instanceof Number))
    {
      if (((Number)paramObject).intValue() == 1) {}
      for (;;)
      {
        return Boolean.valueOf(bool);
        bool = false;
      }
    }
    return Boolean.valueOf("1".equals(paramObject));
  }
  
  public void init(JSONObject paramJSONObject)
  {
    parseWithDictionary(paramJSONObject);
  }
  
  public void initData() {}
  
  public String key()
  {
    return "";
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.QMDomain
 * JD-Core Version:    0.7.0.1
 */
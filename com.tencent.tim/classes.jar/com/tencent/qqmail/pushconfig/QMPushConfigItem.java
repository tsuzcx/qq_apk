package com.tencent.qqmail.pushconfig;

import com.alibaba.fastjson.JSONObject;

public class QMPushConfigItem
{
  private String action;
  private int id;
  private String text;
  
  public String getAction()
  {
    return this.action;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public void parseWithDictionary(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.getInteger("id") != null) {
        setId(paramJSONObject.getInteger("id").intValue());
      }
      String str = "";
      if (paramJSONObject.getString("text") != null) {
        str = paramJSONObject.getString("text");
      }
      setText(str);
      str = "";
      if (paramJSONObject.getString("action") != null) {
        str = paramJSONObject.getString("action");
      }
      setAction(str);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
  
  public String toString()
  {
    return String.format("%d,%s,%s", new Object[] { Integer.valueOf(this.id), this.text, this.action });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.pushconfig.QMPushConfigItem
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.utilities.qmnetwork.service;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.IJsonInterface;
import com.tencent.qqmail.utilities.json.JSONReader;

public class PushSyncBody
  implements IJsonInterface
{
  private String uin;
  
  public JSONObject fromJson(String paramString)
  {
    paramString = (JSONObject)JSONReader.parse(paramString);
    if ((paramString != null) && (paramString.getString("uin") != null)) {
      this.uin = paramString.getString("uin");
    }
    return paramString;
  }
  
  public String getAddress()
  {
    return this.uin;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("uin", this.uin);
    return localJSONObject.toJSONString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PushSyncBody
 * JD-Core Version:    0.7.0.1
 */
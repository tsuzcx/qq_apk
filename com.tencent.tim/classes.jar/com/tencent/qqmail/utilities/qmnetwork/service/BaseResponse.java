package com.tencent.qqmail.utilities.qmnetwork.service;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.IJsonInterface;
import com.tencent.qqmail.utilities.json.JSONReader;

public class BaseResponse
  implements IJsonInterface
{
  public int retcode;
  public long uin;
  
  public JSONObject fromJson(String paramString)
  {
    paramString = (JSONObject)JSONReader.parse(paramString);
    Object localObject;
    if (paramString != null)
    {
      if (!paramString.containsKey("retcode")) {
        break label76;
      }
      this.retcode = paramString.getIntValue("retcode");
      if (paramString.containsKey("uin"))
      {
        localObject = paramString.get("uin");
        if ((!(localObject instanceof String)) || (localObject.equals(""))) {
          break label98;
        }
        this.uin = Long.parseLong((String)localObject);
      }
    }
    label76:
    label98:
    while (localObject.equals(""))
    {
      return paramString;
      if (!paramString.containsKey("app_code")) {
        break;
      }
      this.retcode = paramString.getIntValue("app_code");
      break;
    }
    this.uin = ((Long)localObject).longValue();
    return paramString;
  }
  
  public String toJson()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.BaseResponse
 * JD-Core Version:    0.7.0.1
 */
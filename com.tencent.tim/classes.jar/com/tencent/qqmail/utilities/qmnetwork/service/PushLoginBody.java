package com.tencent.qqmail.utilities.qmnetwork.service;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.IJsonInterface;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Iterator;

public class PushLoginBody
  implements IJsonInterface
{
  public String deviceId;
  public String pKey;
  public String pUin;
  public ArrayList<String> relatives;
  public String rsaKey;
  public long uin;
  
  public JSONObject fromJson(String paramString)
  {
    return null;
  }
  
  public String toJson()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"uin\":");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(",\"deviceid\":\"");
    localStringBuilder.append(this.deviceId);
    localStringBuilder.append(",\"key\":\"");
    localStringBuilder.append(this.rsaKey);
    localStringBuilder.append("\",\"puin\":\"");
    localStringBuilder.append(StringExtention.encodeURI(this.pUin));
    localStringBuilder.append("\",\"pkey\":\"");
    localStringBuilder.append(StringExtention.encodeURI(this.pKey));
    localStringBuilder.append("\",\"relative\":[");
    if (this.relatives != null)
    {
      int i = 0;
      if (i < this.relatives.size())
      {
        String str = (String)this.relatives.get(i);
        if (i == 0) {
          localStringBuilder.append("\"");
        }
        for (;;)
        {
          localStringBuilder.append(str);
          localStringBuilder.append("\",\"");
          i += 1;
          break;
          localStringBuilder.append(",\"");
        }
      }
    }
    localStringBuilder.append("]}");
    return localStringBuilder.toString();
  }
  
  public String toPostData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deviceid=");
    localStringBuilder.append(StringExtention.encodeURI(this.deviceId));
    localStringBuilder.append("&f=xhtml&error=app&uin=");
    localStringBuilder.append(String.valueOf(this.uin));
    localStringBuilder.append("&key=");
    localStringBuilder.append(StringExtention.encodeURI(this.rsaKey));
    localStringBuilder.append("&puin=");
    localStringBuilder.append(StringExtention.encodeURI(this.pUin));
    localStringBuilder.append("&pkey=");
    localStringBuilder.append(StringExtention.encodeURI(this.pKey));
    Iterator localIterator = this.relatives.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append("&relative=");
      localStringBuilder.append(StringExtention.encodeURI(str));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PushLoginBody
 * JD-Core Version:    0.7.0.1
 */
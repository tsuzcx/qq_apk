package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;

class MailBigAttachList
  extends QMDomain
{
  private static final long serialVersionUID = 1L;
  final String className = "bigattLst";
  ArrayList<Object> list = null;
  long mailId = 0L;
  
  public long getMailId()
  {
    return this.mailId;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool = false;
    if (paramJSONObject == null) {}
    do
    {
      return false;
      localObject = paramJSONObject.getJSONArray("bigattLst");
    } while (localObject == null);
    paramJSONObject = new ArrayList();
    Object localObject = ((JSONArray)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      JSONObject localJSONObject = (JSONObject)((Iterator)localObject).next();
      MailBigAttach localMailBigAttach = new MailBigAttach(false);
      localMailBigAttach.parseWithDictionary(localJSONObject);
      localMailBigAttach.setBelongMailId(this.mailId);
      localMailBigAttach.setOrderIndex(i);
      paramJSONObject.add(localMailBigAttach);
      i += 1;
    }
    if ((this.list == null) || (this.list.size() != paramJSONObject.size())) {
      bool = true;
    }
    this.list = paramJSONObject;
    return bool;
  }
  
  public void setMailId(long paramLong)
  {
    this.mailId = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.list != null) && (this.list.size() > 0))
    {
      localStringBuilder.append("\"bigattLst\":[");
      Iterator localIterator = this.list.iterator();
      while (localIterator.hasNext())
      {
        MailBigAttach localMailBigAttach = (MailBigAttach)localIterator.next();
        localStringBuilder.append(localMailBigAttach.toString() + ",");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      localStringBuilder.append("]");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailBigAttachList
 * JD-Core Version:    0.7.0.1
 */
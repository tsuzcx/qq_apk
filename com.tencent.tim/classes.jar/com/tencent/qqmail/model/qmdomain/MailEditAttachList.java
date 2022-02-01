package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;

class MailEditAttachList
  extends QMDomain
{
  private final String className = "editattLst";
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
      localObject = paramJSONObject.getJSONArray("editattLst");
    } while (localObject == null);
    paramJSONObject = new ArrayList();
    Object localObject = ((JSONArray)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      JSONObject localJSONObject = (JSONObject)((Iterator)localObject).next();
      MailEditAttach localMailEditAttach = new MailEditAttach(false);
      localMailEditAttach.parseWithDictionary(localJSONObject);
      localMailEditAttach.setBelongMailId(this.mailId);
      localMailEditAttach.setOrderIndex(i);
      paramJSONObject.add(localMailEditAttach);
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
      localStringBuilder.append("\"editattLst\":[");
      Iterator localIterator = this.list.iterator();
      while (localIterator.hasNext())
      {
        MailEditAttach localMailEditAttach = (MailEditAttach)localIterator.next();
        localStringBuilder.append(localMailEditAttach.toString() + ",");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      localStringBuilder.append("]");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailEditAttachList
 * JD-Core Version:    0.7.0.1
 */
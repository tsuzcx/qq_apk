package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;

class MailTagList
  extends QMDomain
{
  private static final long serialVersionUID = 1L;
  final String className = "tagLst";
  ArrayList<Object> list = null;
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    Object localObject = paramJSONObject.getJSONArray("tagLst");
    boolean bool;
    if (localObject != null)
    {
      paramJSONObject = new ArrayList();
      localObject = ((JSONArray)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramJSONObject.add(MailTag.fromDictionary((JSONObject)((Iterator)localObject).next(), new MailTag()));
      }
      if ((this.list == null) || (this.list.size() != paramJSONObject.size()))
      {
        bool = true;
        this.list = paramJSONObject;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.list != null) && (this.list.size() > 0))
    {
      localStringBuilder.append("\"tagLst\":[");
      Iterator localIterator = this.list.iterator();
      while (localIterator.hasNext())
      {
        MailTag localMailTag = (MailTag)localIterator.next();
        localStringBuilder.append(localMailTag.toString() + ",");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      localStringBuilder.append("]");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailTagList
 * JD-Core Version:    0.7.0.1
 */
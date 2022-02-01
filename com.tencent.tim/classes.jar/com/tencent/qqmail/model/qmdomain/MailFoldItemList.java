package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;

class MailFoldItemList
  extends QMDomain
{
  private static final long serialVersionUID = 1L;
  final String className;
  ArrayList<MailFoldItem> list;
  
  MailFoldItemList(String paramString)
  {
    this.className = paramString;
    this.list = null;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getJSONArray(this.className);
    if (localObject != null)
    {
      paramJSONObject = new ArrayList();
      localObject = ((JSONArray)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        JSONArray localJSONArray = (JSONArray)((Iterator)localObject).next();
        MailFoldItem localMailFoldItem = new MailFoldItem();
        if (localJSONArray.getLong(0).longValue() == 1L) {}
        for (boolean bool = true;; bool = false)
        {
          localMailFoldItem.setCanExpend(bool);
          localMailFoldItem.setContent(localJSONArray.getString(1));
          paramJSONObject.add(localMailFoldItem);
          break;
        }
      }
      this.list = paramJSONObject;
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.list != null) && (this.list.size() > 0))
    {
      localStringBuilder.append("\"" + this.className + "\":[");
      int i = 0;
      if (i < this.list.size())
      {
        localStringBuilder.append("[");
        Object localObject = new StringBuilder();
        long l;
        if (((MailFoldItem)this.list.get(i)).isCanExpend())
        {
          l = 1L;
          label108:
          localStringBuilder.append(l + ",");
          if (((MailFoldItem)this.list.get(i)).getContent() == null) {
            break label239;
          }
          localObject = ((MailFoldItem)this.list.get(i)).getContent().replaceAll("\\\\", "\\\\\\\\");
          localStringBuilder.append("\"" + ((String)localObject).replaceAll("\"", "\\\\\"") + "\"");
          label206:
          if (i != this.list.size() - 1) {
            break label250;
          }
          localStringBuilder.append("]");
        }
        for (;;)
        {
          i += 1;
          break;
          l = 0L;
          break label108;
          label239:
          localStringBuilder.append("\"\"");
          break label206;
          label250:
          localStringBuilder.append("],");
        }
      }
      localStringBuilder.append("]");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailFoldItemList
 * JD-Core Version:    0.7.0.1
 */
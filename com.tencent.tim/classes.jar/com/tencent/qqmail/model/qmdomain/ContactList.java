package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

class ContactList
  extends QMDomain
{
  private static final long serialVersionUID = 1L;
  final String className;
  ArrayList<Object> list;
  
  ContactList(String paramString)
  {
    this.className = paramString;
    this.list = null;
  }
  
  public String getSearchStr()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.list != null) && (this.list.size() > 0))
    {
      Iterator localIterator = this.list.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof MailContact)) {
          localStringBuilder.append(((MailContact)localObject).getSearchStr(true));
        } else if ((localObject instanceof MailGroupContact)) {
          localStringBuilder.append(((MailGroupContact)localObject).getSearchStr());
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    Object localObject1 = paramJSONObject.getJSONArray(this.className);
    boolean bool;
    if (localObject1 != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((JSONArray)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (JSONObject)((Iterator)localObject1).next();
        if (((JSONObject)localObject2).get("class") != null)
        {
          if (((JSONObject)localObject2).get("class").equals("MailContact")) {
            localArrayList.add(MailContact.fromDictionary((JSONObject)localObject2, new MailContact()));
          } else if (((JSONObject)localObject2).get("class").equals("MailGroupContact")) {
            localArrayList.add(MailGroupContact.fromDictionary((JSONObject)localObject2, new MailGroupContact()));
          }
        }
        else
        {
          String str = (String)paramJSONObject.get("gid");
          if ((!StringUtils.isBlank(str)) && (!StringUtils.equalsIgnoreCase("0", str)))
          {
            localArrayList.add(MailGroupContact.fromDictionary((JSONObject)localObject2, new MailGroupContact()));
          }
          else
          {
            localObject2 = (MailContact)MailContact.fromDictionary((JSONObject)localObject2, new MailContact());
            if (!StringUtils.isBlank(((MailContact)localObject2).getAddress())) {
              localArrayList.add(localObject2);
            }
          }
        }
      }
      if ((this.list == null) || (this.list.size() != localArrayList.size()))
      {
        bool = true;
        this.list = localArrayList;
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
      localStringBuilder.append("\"" + this.className + "\":[");
      Iterator localIterator = this.list.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof MailContact))
        {
          localObject = (MailContact)localObject;
          localStringBuilder.append(((MailContact)localObject).toString() + ",");
          i += 1;
        }
        for (;;)
        {
          break;
          int j = i;
          if ((localObject instanceof MailGroupContact))
          {
            j = i + 1;
            localObject = (MailGroupContact)localObject;
            localStringBuilder.append(((MailGroupContact)localObject).toString() + ",");
          }
          i = j;
        }
      }
      if (i > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      localStringBuilder.append("]");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.ContactList
 * JD-Core Version:    0.7.0.1
 */
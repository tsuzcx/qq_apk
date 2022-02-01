package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;

public class MailGroupContactList
  extends QMDomain
{
  private ArrayList<MailGroupContact> groupContacts;
  
  public void clearData()
  {
    if ((getGroupContacts() != null) && (getGroupContacts().size() > 0)) {
      getGroupContacts().clear();
    }
  }
  
  public ArrayList<MailGroupContact> getGroupContacts()
  {
    return this.groupContacts;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.getJSONArray("item");
      if ((paramJSONObject != null) && (paramJSONObject.size() != 0)) {}
    }
    else
    {
      return false;
    }
    clearData();
    int j = paramJSONObject.size();
    while (i < j)
    {
      if (getGroupContacts() == null) {
        setGroupContacts(new ArrayList());
      }
      JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
      MailGroupContact localMailGroupContact = new MailGroupContact();
      localMailGroupContact.parseWithDictionary(localJSONObject);
      this.groupContacts.add(localMailGroupContact);
      i += 1;
    }
    return true;
  }
  
  public boolean parseWithJson(JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.getJSONArray("item");
      if ((paramJSONObject != null) && (paramJSONObject.size() != 0)) {}
    }
    else
    {
      return false;
    }
    clearData();
    int j = paramJSONObject.size();
    while (i < j)
    {
      if (getGroupContacts() == null) {
        setGroupContacts(new ArrayList());
      }
      JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
      MailGroupContact localMailGroupContact = new MailGroupContact();
      localMailGroupContact.parseWithJson(localJSONObject, paramInt);
      this.groupContacts.add(localMailGroupContact);
      i += 1;
    }
    return true;
  }
  
  public void setGroupContacts(ArrayList<MailGroupContact> paramArrayList)
  {
    this.groupContacts = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailGroupContactList
 * JD-Core Version:    0.7.0.1
 */
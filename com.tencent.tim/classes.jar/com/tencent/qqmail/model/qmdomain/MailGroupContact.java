package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONObject;

public class MailGroupContact
  extends MailContact
{
  private String gid;
  
  public String getGid()
  {
    return this.gid;
  }
  
  public String getSearchStr()
  {
    return getName() + "\n" + this.gid + "\n";
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool2 = super.parseWithDictionary(paramJSONObject) | false;
    String str = (String)paramJSONObject.get("id");
    boolean bool1 = bool2;
    if (str != null) {
      if ((getGid() != null) && (!getGid().equals("")))
      {
        bool1 = bool2;
        if (getGid().equals(str)) {}
      }
      else
      {
        setGid(str);
        bool1 = true;
      }
    }
    paramJSONObject = (String)paramJSONObject.get("name");
    bool2 = bool1;
    if (paramJSONObject != null) {
      if ((getName() != null) && (!getName().equals("")))
      {
        bool2 = bool1;
        if (getName().equals(paramJSONObject)) {}
      }
      else
      {
        setName(paramJSONObject);
        setNick(paramJSONObject);
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean parseWithJson(JSONObject paramJSONObject, int paramInt)
  {
    String str = (String)paramJSONObject.get("id");
    if ((str != null) && ((getGid() == null) || (getGid().equals("")) || (!getGid().equals(str))))
    {
      setGid(str);
      setAddress(str);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      paramJSONObject = (String)paramJSONObject.get("name");
      boolean bool2 = bool1;
      if (paramJSONObject != null) {
        if ((getName() != null) && (!getName().equals("")))
        {
          bool2 = bool1;
          if (getName().equals(paramJSONObject)) {}
        }
        else
        {
          setName(paramJSONObject);
          setNick(paramJSONObject);
          bool2 = true;
        }
      }
      setCid("0");
      setAccountId(paramInt);
      setType(MailContact.ContactType.GroupContact);
      setHashType(0);
      setHash(MailContact.generateHash(this));
      setOfflineType(0);
      setId(MailContact.generateGroupContactId(paramInt, getType().ordinal(), getCid(), getAddress()));
      return bool2;
    }
  }
  
  public void setGid(String paramString)
  {
    this.gid = paramString;
  }
  
  public String showText()
  {
    if ((getName() == null) || (getName().equals(""))) {
      return getGid().split("@")[0];
    }
    return getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailGroupContact
 * JD-Core Version:    0.7.0.1
 */